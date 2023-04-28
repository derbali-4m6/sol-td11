package ca.qc.sol_td11.adpater;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ca.qc.sol_td11.R;

public class SongViewHolder extends RecyclerView.ViewHolder {
    TextView songTitle;
    CheckBox songCheckBox;

    public SongViewHolder(@NonNull View itemView) {
        super(itemView);
        songTitle = itemView.findViewById(R.id.line_song_title);
        songCheckBox = itemView.findViewById(R.id.line_song_checkBox);
    }
}
