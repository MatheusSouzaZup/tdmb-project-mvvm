package br.com.bluedot.moviemvp.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import br.com.bluedot.moviemvp.R;
import br.com.bluedot.moviemvp.databinding.ItemFeedBinding;
import br.com.bluedot.moviemvp.model.MovieInfo;
import br.com.bluedot.moviemvp.view.feed.FeedItemAdapter;

public class CustomFeedItem extends LinearLayout {
    ItemFeedBinding bind;

    private String mTitle;
    private List<MovieInfo> movieInfoList;

    public CustomFeedItem(Context context) {
        super(context);
        init(null);
    }

    public CustomFeedItem(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CustomFeedItem(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }


    public void init(AttributeSet attrs) {
        movieInfoList = new ArrayList<>();
        bind = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.item_feed, this, true);
        if (attrs != null) {
            TypedArray a = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.CustomFeedItem, 0, 0);
            try {
                mTitle = a.getString(R.styleable.CustomFeedItem_title);
            } finally {
                a.recycle();
            }
        }
        bind.tvTitle.setText(mTitle);
    }

    private void setUpAdapter() {
        bind.recyclerView.setAdapter(new FeedItemAdapter(movieInfoList));
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.HORIZONTAL);
        bind.recyclerView.setLayoutManager(llm);
    }


    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }


    public void setMovieInfoList(List<MovieInfo> movieInfoList) {
        this.movieInfoList = movieInfoList;
        setUpAdapter();
    }

}
