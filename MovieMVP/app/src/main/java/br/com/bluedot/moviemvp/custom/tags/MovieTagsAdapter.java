package br.com.bluedot.moviemvp.custom.tags;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.bluedot.moviemvp.R;
import br.com.bluedot.moviemvp.databinding.ItemMovieTagsBinding;

public class MovieTagsAdapter extends RecyclerView.Adapter<MovieTagsAdapter.TagViewHolder> {
    private List<String> mList;

    public MovieTagsAdapter(List<String> mList) {
        this.mList = mList;
    }

    @NonNull
    @Override
    public TagViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_movie_tags, viewGroup, false);
        return new TagViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TagViewHolder tagViewHolder, int pos) {
        tagViewHolder.onBind(mList.get(pos));
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    class TagViewHolder extends RecyclerView.ViewHolder {
        ItemMovieTagsBinding bind;
        TextView tvTag;

        TagViewHolder(@NonNull View itemView) {
            super(itemView);
//            bind = DataBindingUtil.bind(itemView.getRootView());
            tvTag = itemView.findViewById(R.id.tvTag);
        }

        void onBind(String tag) {
          tvTag.setText(tag);
        }
    }
}
