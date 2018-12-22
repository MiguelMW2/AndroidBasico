package mx.ipn.cic.examfragment.fragments;


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
import android.widget.ListView;

import java.util.List;

import mx.ipn.cic.examfragment.R;
import mx.ipn.cic.examfragment.adapters.MovieAdapter;
import mx.ipn.cic.examfragment.model.MovieModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesFragment extends Fragment {

    public static MoviesFragment newInstance() {

        Bundle args = new Bundle();

        MoviesFragment fragment = new MoviesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public MoviesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<MovieModel> items = MovieModel.defaultItems(20);
        final MovieAdapter adapter = new MovieAdapter(items);

        ListView listMovies = view.findViewById(R.id.lvMovies);
        listMovies.setAdapter(adapter);

        listMovies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Adapter adapter = adapterView.getAdapter();
                MovieModel movie = (MovieModel) adapter.getItem(position);
                navigate(movie);
            }
        });
    }

    private void navigate(MovieModel movie) {
        DetailFragment detailFragment = DetailFragment.newInstance(movie);

        FragmentManager fragmentManager = this.getFragmentManager();

        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.replace(R.id.container, detailFragment);

        transaction.addToBackStack(null);

        transaction.commit();
    }
}
