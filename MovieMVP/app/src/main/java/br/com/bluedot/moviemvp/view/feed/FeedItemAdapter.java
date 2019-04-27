package br.com.bluedot.moviemvp.view.feed;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.bluedot.moviemvp.R;
import br.com.bluedot.moviemvp.databinding.ItemMovieBinding;
import br.com.bluedot.moviemvp.model.MovieInfo;

public class FeedItemAdapter extends RecyclerView.Adapter<FeedItemAdapter.ItemViewHolder> {
    List<MovieInfo> movieInfoList;

    public FeedItemAdapter(List<MovieInfo> movieInfoList) {
        this.movieInfoList = movieInfoList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_movie, viewGroup, false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int i) {
        itemViewHolder.onBind(movieInfoList.get(i));
    }

    @Override
    public int getItemCount() {
        return movieInfoList.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        ItemMovieBinding bind;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            bind = DataBindingUtil.bind(itemView);
        }

        public void onBind(MovieInfo movieInfo) {
            Picasso.get().load(itemView.getContext().getString(R.string.image_base_url) + movieInfo.getPosterUrl())
                    .into(bind.ivPoster);
        }
    }
}
