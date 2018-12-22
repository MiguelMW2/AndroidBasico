package cic.ipn.mx.gridviewfragment.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cic.ipn.mx.gridviewfragment.R;
import cic.ipn.mx.gridviewfragment.model.SongModel;

public class SongAdapter extends BaseAdapter {

    private List<SongModel> list;

    public SongAdapter(List<SongModel> lista) {
        this.list = lista;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public SongModel getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).hashCode();
    }

    @Override
    public View getView(int position, View reusableView, ViewGroup container) {

        if(reusableView == null) {
            Context context = container.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);
            reusableView = inflater.inflate(R.layout.layout_gv_item, container, false);
        }

        SongModel song = getItem(position);

        TextView tvTitle = reusableView.findViewById(R.id.tvTitle);
        ImageView ivImage = reusableView.findViewById(R.id.ivImage);

        tvTitle.setText(song.getTitle());
        ivImage.setImageResource(song.getImage());

        return reusableView;
    }
}
