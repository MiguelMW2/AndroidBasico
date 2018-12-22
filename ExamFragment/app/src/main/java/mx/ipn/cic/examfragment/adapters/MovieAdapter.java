package mx.ipn.cic.examfragment.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import mx.ipn.cic.examfragment.R;
import mx.ipn.cic.examfragment.model.MovieModel;

public class MovieAdapter extends BaseAdapter{

    private List<MovieModel> list;

    public MovieAdapter(List<MovieModel> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return this.list.size();
    }

    @Override
    public MovieModel getItem(int position) {
        return this.list.get(position);
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
            reusableView = inflater.inflate(R.layout.layout_lv_item, container, false);
        }

        MovieModel movie = getItem(position);

        ImageView ivImage = reusableView.findViewById(R.id.ivMovie);
        TextView tvTitle = reusableView.findViewById(R.id.tvTitle);
        TextView tvYear = reusableView.findViewById(R.id.tvYear);
        TextView tvDirector = reusableView.findViewById(R.id.tvDirector);

        ivImage.setImageResource(movie.getImage());
        tvTitle.setText(movie.getTitle());
        tvYear.setText(movie.getYear());
        tvDirector.setText(movie.getDirector());
        return reusableView;
    }
}
