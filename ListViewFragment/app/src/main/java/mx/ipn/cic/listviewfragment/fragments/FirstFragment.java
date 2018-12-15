package mx.ipn.cic.listviewfragment.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.List;

import mx.ipn.cic.listviewfragment.R;
import mx.ipn.cic.listviewfragment.adapters.ListViewAdapter;
import mx.ipn.cic.listviewfragment.model.SongModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {

    public static FirstFragment newInstance() {

        Bundle args = new Bundle();

        FirstFragment fragment = new FirstFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ListView lvLista = view.findViewById(R.id.lvLista);
        List<SongModel> lista = SongModel.defaultItems(10);
        ListViewAdapter adapter = new ListViewAdapter(lista);
        lvLista.setAdapter(adapter);

        lvLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Adapter adapter = adapterView.getAdapter();
                SongModel song = (SongModel) adapter.getItem(position);
                //Toast.makeText(getContext(), "Se presionó " + song, Toast.LENGTH_LONG).show();
                navegar(song);
            }
        });
    }

    private void navegar(SongModel song) {

        SecondFragment secondFragment = SecondFragment.newInstance(song);

        FragmentManager fragmentManager = this.getFragmentManager();

        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.replace(R.id.container, secondFragment);

        transaction.addToBackStack(null);

        transaction.commit();
    }
}
