package mx.ipn.cic.listviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import mx.ipn.cic.listviewexample.adapters.ListViewAdapter;
import mx.ipn.cic.listviewexample.model.SongModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvLista = findViewById(R.id.lvLista);
        List<SongModel> lista = generateList(10);

        ListViewAdapter adapter = new ListViewAdapter(lista);
        lvLista.setAdapter(adapter);
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
