package ca.qc.sol_td11;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ca.qc.sol_td11.adpater.SongAdapter;
import ca.qc.sol_td11.entities.Song;

public class MusicPlayerActivity extends AppCompatActivity {

    List<Song> songs;
    private TextView musicTitle;
    private RecyclerView rvSongs;
    SongAdapter adapter;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);
        initSongs();
        initView();
        //init recyclerView
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvSongs.setLayoutManager(manager);

        //créer un service
        intent = new Intent(this, MusicService.class);
        adapter = new SongAdapter(songs, this, intent, musicTitle);
        rvSongs.setAdapter(adapter);
    }

    private void initSongs() {
        songs = new ArrayList<>();
        songs.add(new Song(R.raw.ed_sheeran_shape_of_you, "Shape of you"));
        songs.add(new Song(R.raw.flo_rida_feat_sia_wild_ones, "Wild Ones"));
        songs.add(new Song(R.raw.justin_bieber_sorry, "Sorry"));
        songs.add(new Song(R.raw.maroon_5_girls_like_you_ft_cardi_b, "Girls like you"));
    }

    private void initView() {
        musicTitle = (TextView) findViewById(R.id.music_title);
        rvSongs = (RecyclerView) findViewById(R.id.rv_songs);
    }

    public void stopSong(View view) {
        if (intent != null)
            stopService(intent);
        musicTitle.setText("");
    }
}