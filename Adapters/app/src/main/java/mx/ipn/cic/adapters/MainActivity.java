package mx.ipn.cic.adapters;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

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
        List<SongModel> lista = generateList(10);

        ListViewAdapter adapter = new ListViewAdapter(lista);
        lvLista.setAdapter(adapter);

        lvLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                
            }
        });
    }

    private List<SongModel> generateList(int items) {
        List<SongModel> aux = new ArrayList<>();
        for(int x = 1; x <= items; x++) {
            SongModel song = new SongModel("Nombre " + x, "Artista " + x);
            aux.add(song);
        }
        return aux;
    }
}
