package br.com.bluedot.moviemvp.custom.tags;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import br.com.bluedot.moviemvp.R;
import br.com.bluedot.moviemvp.databinding.CustomMovieTagsBinding;

public class MovieTags extends LinearLayout {

    private CustomMovieTagsBinding bind;


    private List<String> mTags;

    public MovieTags(Context context) {
        super(context);
        init();
    }

    public MovieTags(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MovieTags(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init() {
        bind = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.custom_movie_tags, this, true);
        bind.setMovieTag(this);

        if (mTags == null) {
            mTags = tagsExample();
        }
    }

    private void setUpAdapter() {
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(VERTICAL);
        bind.recyclerView.setAdapter(new MovieTagsAdapter(mTags));
        bind.recyclerView.setLayoutManager(llm);
    }

    public void setTags(List<String> mTags) {
        this.mTags = mTags;
        setUpAdapter();
    }

    private List<String> tagsExample() {
        List<String> list = new ArrayList<>();
        list.add("Ação");
        list.add("Comédia");
        list.add("Romance");
        return list;
    }
}
