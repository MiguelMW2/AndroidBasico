package cic.ipn.mx.gridviewfragment.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.List;

import cic.ipn.mx.gridviewfragment.R;
import cic.ipn.mx.gridviewfragment.adapters.SongAdapter;
import cic.ipn.mx.gridviewfragment.model.SongModel;

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

        GridView gridView = view.findViewById(R.id.gvCuadricula);
        List<SongModel> items = SongModel.defaultItems(20);
        final SongAdapter adapter = new SongAdapter(items);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Adapter adapter = adapterView.getAdapter();
                SongModel song = (SongModel) adapter.getItem(position);
                //Toast.makeText(getContext(), "Se presiono: " + song, Toast.LENGTH_SHORT).show();
                navigate(song);
            }
        });
    }

    private void navigate(SongModel song) {

        SecondFragment secondFragment = SecondFragment.newInstance(song);

        FragmentManager fragmentManager = this.getFragmentManager();

        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.replace(R.id.container, secondFragment);

        transaction.addToBackStack(null);

        transaction.commit();
    }
}
