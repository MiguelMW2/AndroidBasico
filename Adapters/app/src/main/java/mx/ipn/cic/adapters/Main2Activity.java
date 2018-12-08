package mx.ipn.cic.adapters;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.Serializable;

import mx.ipn.cic.adapters.model.SongModel;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView tvArtist = findViewById(R.id.tvArtist);
        TextView tvSongName = findViewById(R.id.tvSongName);
        TextView tvDuration = findViewById(R.id.tvDuration);
        TextView tvYear = findViewById(R.id.tvYear);

        Intent intent = getIntent();
        SongModel song = (SongModel) intent.getSerializableExtra("song");

        tvArtist.setText(song.getArtist());
        tvSongName.setText(song.getName());
        tvDuration.setText("Duración: " + song.getDuration() + " minutos");
        tvYear.setText("Año: " + song.getYear());
    }
}
