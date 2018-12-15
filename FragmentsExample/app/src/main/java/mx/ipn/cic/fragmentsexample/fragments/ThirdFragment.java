package mx.ipn.cic.fragmentsexample.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import mx.ipn.cic.fragmentsexample.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThirdFragment extends Fragment {

    private static final String MI_CADENA = "MI_CADENA";

    private String cadena;

    public static ThirdFragment newInstance(String cadena) {

        Bundle args = new Bundle();

        args.putString(MI_CADENA, cadena);

        ThirdFragment fragment = new ThirdFragment();
        fragment.setArguments(args);

        return fragment;
    }

    public ThirdFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Se configura a nivel "logico" el fragment
        Bundle arguments = this.getArguments();

        if(arguments != null){
            this.cadena = arguments.getString(MI_CADENA);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tvTitle = view.findViewById(R.id.tvThirdFragment);
        tvTitle.setText(this.cadena);
    }
}
