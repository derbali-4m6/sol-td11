package ca.qc.sol_td11;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

import ca.qc.sol_td11.entities.Song;

public class MusicService extends Service {
    MediaPlayer mediaPlayer;
    public MusicService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //récupérer la chanson à jouer et donner l'order de jouer
        Song song = intent.getParcelableExtra("song");
        Log.d("Music", song.getTitle());
        mediaPlayer = MediaPlayer.create(this, song.getRawID());
        mediaPlayer.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer = null;
        }
        stopSelf();
    }
}