package cic.ipn.mx.gridviewfragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.List;

import cic.ipn.mx.gridviewfragment.adapters.SongAdapter;
import cic.ipn.mx.gridviewfragment.fragments.FirstFragment;
import cic.ipn.mx.gridviewfragment.model.SongModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {

            FirstFragment fragment = FirstFragment.newInstance();

            FragmentManager fragmentManager = this.getSupportFragmentManager();

            FragmentTransaction transaction = fragmentManager.beginTransaction();

            transaction.add(R.id.container, fragment);

            transaction.commit();
        }
    }
}
