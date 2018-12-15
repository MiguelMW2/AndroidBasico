package mx.ipn.cic.listviewfragment.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import mx.ipn.cic.listviewfragment.R;
import mx.ipn.cic.listviewfragment.model.SongModel;

public class ListViewAdapter extends BaseAdapter {

    private List<SongModel> list;

    public ListViewAdapter(List<SongModel> songs) {
        this.list = songs;
    }

    @Override
    public int getCount() {
        return this.list.size();
    }

    @Override
    public SongModel getItem(int position) {
        return this.list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.getItem(position).hashCode();
    }

    @Override
    public View getView(int position, View reusableView, ViewGroup viewGroup) {

        if(reusableView == null){
            Context context = viewGroup.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);
            reusableView = inflater.inflate(R.layout.layout_item, viewGroup, false);
        }

        SongModel song = getItem(position);

        TextView tvSongName = reusableView.findViewById(R.id.tvSongName);
        tvSongName.setText(song.getName());

        TextView tvArtist = reusableView.findViewById(R.id.tvArtist);
        tvArtist.setText(song.getArtist());

        return reusableView;
    }
}
