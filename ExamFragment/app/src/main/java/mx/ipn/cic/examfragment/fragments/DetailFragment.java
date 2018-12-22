package mx.ipn.cic.examfragment.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import mx.ipn.cic.examfragment.R;
import mx.ipn.cic.examfragment.model.MovieModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    private static final String MOVIE = "MOVIE";

    private MovieModel movie;

    public static DetailFragment newInstance(MovieModel movie) {

        Bundle args = new Bundle();

        args.putSerializable(MOVIE, movie);

        DetailFragment fragment = new DetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle arguments = this.getArguments();
        if(arguments != null) {
            this.movie = (MovieModel) arguments.getSerializable(MOVIE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tvTitle = view.findViewById(R.id.tvTitle);
        TextView tvDirector = view.findViewById(R.id.tvDirector);
        TextView tvYear = view.findViewById(R.id.tvYear);
        ImageView ivImage = view.findViewById(R.id.ivMovie);

        tvTitle.setText(this.movie.getTitle());
        tvDirector.setText(this.movie.getDirector());
        tvYear.setText(this.movie.getYear());
        ivImage.setImageResource(this.movie.getImage());
    }
}
