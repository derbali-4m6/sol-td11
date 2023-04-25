package ca.qc.sol_td11;

import android.app.Activity;
import android.app.IntentService;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Ex1Service extends IntentService {  //Service {

    public Ex1Service() {
        super("Ex1 servoice");

    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        Toast.makeText(this, "Le service démarre", Toast.LENGTH_LONG).show();
        //traitement ici
        try {
            Thread.sleep(10000);  //10 secondes de traitement
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                Messenger messenger = (Messenger) bundle.get("messenger");
                Message msg = Message.obtain();
                Bundle b = new Bundle();
                b.putString("msg", "Le service s'arrête");
                msg.setData(b);
                try {
                    messenger.send(msg);
                } catch (RemoteException e) {
                    Log.i("error", "error");
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopSelf();
        Toast.makeText(this, "Le service s'arrête", Toast.LENGTH_LONG).show();
    }


   /* @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }*/



  /*  @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        return super.onStartCommand(intent, flags, startId);
    }*/


}