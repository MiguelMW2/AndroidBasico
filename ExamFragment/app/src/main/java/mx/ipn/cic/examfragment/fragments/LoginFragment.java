package mx.ipn.cic.examfragment.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import mx.ipn.cic.examfragment.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    public static LoginFragment newInstance() {

        Bundle args = new Bundle();

        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        final EditText etUser = view.findViewById(R.id.etUser);
        final EditText etPassword = view.findViewById(R.id.etPassword);
        Button btnGo = view.findViewById(R.id.btnGo);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigate(etUser.getText().toString(), etPassword.getText().toString());
            }
        });
        return view;
    }

    private void navigate(String user, String password) {
        if(user.equals("abc") && password.equals("abc")) {

            MoviesFragment moviesFragment = MoviesFragment.newInstance();

            FragmentManager fragmentManager = this.getFragmentManager();

            FragmentTransaction transaction = fragmentManager.beginTransaction();

            transaction.replace(R.id.container, moviesFragment);

            transaction.commit();
        }
        else {
            Toast.makeText(getContext(), "Usuario y contraseña incorrectos.", Toast.LENGTH_SHORT).show();
        }
    }
}
