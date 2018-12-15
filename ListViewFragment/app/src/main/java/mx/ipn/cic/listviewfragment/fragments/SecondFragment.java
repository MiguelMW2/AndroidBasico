package mx.ipn.cic.listviewfragment.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.Serializable;

import mx.ipn.cic.listviewfragment.R;
import mx.ipn.cic.listviewfragment.model.SongModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {

    private static final String SONG_MODEL = "SONG_MODEL";

    private Serializable song;

    public static SecondFragment newInstance(SongModel song) {

        Bundle args = new Bundle();

        args.putSerializable(SONG_MODEL, song);

        SecondFragment fragment = new SecondFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public SecondFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle arguments = this.getArguments();

        if(arguments == null){
            this.song = arguments.getSerializable(SONG_MODEL);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tvArtist = view.findViewById(R.id.tvArtist);
        TextView tvSongName = view.findViewById(R.id.tvSongName);
        TextView tvDuration = view.findViewById(R.id.tvDuration);
        TextView tvYear = view.findViewById(R.id.tvYear);

        SongModel songInformation = (SongModel) this.song;

        tvArtist.setText(songInformation.getArtist());
        tvSongName.setText(songInformation.getName());
        tvDuration.setText("" + songInformation.getDuration());
        tvYear.setText("" + songInformation.getYear());
    }
}
