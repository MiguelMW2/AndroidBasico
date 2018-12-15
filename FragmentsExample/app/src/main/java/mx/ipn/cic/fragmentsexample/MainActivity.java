package mx.ipn.cic.fragmentsexample;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import mx.ipn.cic.fragmentsexample.fragments.FirstFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            //1.- Crear una instancia del fragment a colocar
            FirstFragment fragment = FirstFragment.newInstance();

            //2.- Obtener una instancia del FragmentManager (SupportFragmentManager)
            FragmentManager fragmentManager = this.getSupportFragmentManager();

            //3.- Iniciar una transaccion (FragmentTransaction) con ayuda del FragmentManager
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            //4.- Especificar la transaccion (add)
            transaction.add(R.id.container, fragment);

            //5.- Confirmar la transaccion (commit)
            transaction.commit();
        }
    }
}
