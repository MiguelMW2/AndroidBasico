package mx.ipn.cic.examfragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import mx.ipn.cic.examfragment.fragments.LoginFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null) {

            LoginFragment loginFragment = LoginFragment.newInstance();

            FragmentManager fragmentManager = this.getSupportFragmentManager();

            FragmentTransaction transaction = fragmentManager.beginTransaction();

            transaction.add(R.id.container, loginFragment);

            transaction.commit();
        }
    }
}
