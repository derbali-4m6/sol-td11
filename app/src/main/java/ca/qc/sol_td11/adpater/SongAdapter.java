package ca.qc.sol_td11.adpater;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ca.qc.sol_td11.MusicService;
import ca.qc.sol_td11.R;
import ca.qc.sol_td11.entities.Song;

public class SongAdapter extends RecyclerView.Adapter<SongViewHolder> {
    List<Song> songs;
    Context context;
    Intent intent;
    public SongAdapter(List<Song> songs, Context context, Intent intent) {
        this.songs = songs;
        this.context = context;
        this.intent = intent;
    }

    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.line_song, parent, false);
        return new SongViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder holder, int position) {
        holder.songTitle.setText(this.songs.get(position).getTitle());
        final int index  = position;
        holder.songCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(((CompoundButton) view).isChecked()){
                    Log.d("Music", "Checked");
                    context.stopService(intent);
                    intent.putExtra("song", songs.get(index));
                    context.startService(intent);
                } else {
                    Log.d("Music", "Un-Checked");
                    context.stopService(intent);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.songs.size();
    }
}
