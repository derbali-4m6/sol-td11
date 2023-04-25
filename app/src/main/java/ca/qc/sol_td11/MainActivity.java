package ca.qc.sol_td11;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{

    Intent intent;
    private TextView textView;
    Handler handler = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            Bundle reply = msg.getData();
            textView.setText(reply.getString("msg"));
            return false;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    public void demarrer(View view) {
        intent = new Intent(this, Ex1Service.class);
        intent.putExtra("messenger", new Messenger(handler));
        startService(intent);
        startService(intent);
        textView.setText("Service en cours");
    }

    public void arreter(View view) {
        if (intent == null) {
            intent = new Intent(this, Ex1Service.class);
        }
        stopService(intent);
        textView.setText("Service arrêté");
    }

    private void initView() {
        textView = (TextView) findViewById(R.id.textView);
    }





}