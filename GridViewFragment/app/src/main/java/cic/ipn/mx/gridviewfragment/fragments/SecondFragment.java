package cic.ipn.mx.gridviewfragment.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import cic.ipn.mx.gridviewfragment.R;
import cic.ipn.mx.gridviewfragment.model.SongModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {

    private static String SONG_MODEL = "SONG_MODEL";

    private SongModel song;

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

        if(arguments != null) {
            this.song = (SongModel) arguments.getSerializable(SONG_MODEL);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tvTitle = view.findViewById(R.id.tvTitle);
        TextView tvArtist = view.findViewById(R.id.tvArtist);
        ImageView ivImage = view.findViewById(R.id.ivImage);

        tvTitle.setText(song.getTitle());
        tvArtist.setText(song.getArtist());
        ivImage.setImageResource(song.getImage());
    }
}
