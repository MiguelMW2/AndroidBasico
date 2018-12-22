package mx.ipn.cic.adaptersgrid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.List;

import mx.ipn.cic.adaptersgrid.adapter.SongAdapter;
import mx.ipn.cic.adaptersgrid.model.SongModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = findViewById(R.id.gvCuadricula);
        List<SongModel> items = SongModel.defaultItems(20);
        SongAdapter songAdapter = new SongAdapter(items);

        gridView.setAdapter(songAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long elementId) {
                Adapter adapter = adapterView.getAdapter();
                SongModel item = (SongModel) adapter.getItem(position);
                Toast.makeText(getApplicationContext(), "Presionó: " + item, Toast.LENGTH_SHORT).show();
                navegar(item);
            }
        });
    }

    private void navegar(SongModel item) {
        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra("song", item);
        startActivity(intent);
    }
}
