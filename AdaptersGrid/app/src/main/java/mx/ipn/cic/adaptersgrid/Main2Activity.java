package mx.ipn.cic.adaptersgrid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

import mx.ipn.cic.adaptersgrid.model.SongModel;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView tvTitle = findViewById(R.id.tvTitle);
        TextView tvArtist = findViewById(R.id.tvArtist);
        ImageView ivImage = findViewById(R.id.ivImage);

        Intent intent = getIntent();
        SongModel song = (SongModel) intent.getSerializableExtra("song");

        tvTitle.setText(song.getTitle());
        tvArtist.setText(song.getArtist());
        ivImage.setImageResource(song.getImage());
    }
}
