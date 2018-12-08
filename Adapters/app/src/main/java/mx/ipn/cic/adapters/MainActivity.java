package mx.ipn.cic.adapters;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import mx.ipn.cic.adapters.adapters.ListViewAdapter;
import mx.ipn.cic.adapters.model.SongModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvLista = findViewById(R.id.lvLista);
        List<SongModel> lista = SongModel.defaultItems(10);
        ListViewAdapter adapter = new ListViewAdapter(lista);

        lvLista.setAdapter(adapter);

        // adapterView -> ListView
        // view -> Vista presionada
        // position -> Posición del elemento presionado
        // id -> id del elemento presionado
        lvLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Adapter adapter = adapterView.getAdapter();
                SongModel song = (SongModel) adapter.getItem(position);
                Toast.makeText(getApplicationContext(), "Se presionó " + song, Toast.LENGTH_LONG).show();
                navegar(song);
            }
        });
    }

    private void navegar(SongModel song) {
        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra("song", song);
        startActivity(intent);
    }
}
