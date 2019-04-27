package br.com.bluedot.moviemvp.view.feed;


import android.arch.lifecycle.LiveData;

import com.squareup.picasso.Picasso;

import java.util.List;


import br.com.bluedot.moviemvp.R;
import br.com.bluedot.moviemvp.custom.tags.Genre;
import br.com.bluedot.moviemvp.databinding.FragmentFeedBinding;
import br.com.bluedot.moviemvp.model.MovieInfo;
import br.com.bluedot.moviemvp.view.BaseFragment;
import br.com.bluedot.moviemvp.viewmodel.FeedViewModel;

public class FeedFragment extends BaseFragment<FragmentFeedBinding, FeedViewModel> {
    boolean popularDone;
    boolean nowPlayingDone;
    boolean nowUpComing;

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_feed;
    }

    @Override
    protected Class<FeedViewModel> getViewModelClass() {
        return FeedViewModel.class;
    }

    @Override
    public void initBinding() {
        getViewModel().getPopular().observe(this, (input) -> {
            setMostPopular(input.get(0));
            input.remove(0);
            getBinding().fiPopular.setMovieInfoList(input);
        });
        getViewModel().getNowPlaying().observe(this, (input) -> getBinding().fiNowPlaying.setMovieInfoList(input));
        getViewModel().getUpComing().observe(this, (input) -> getBinding().fiUpComing.setMovieInfoList(input));
    }

    private void setMostPopular(MovieInfo movieInfo) {
        getBinding().mtTags.setTags(Genre.getTags(movieInfo.getGenres()));
        getBinding().tvTitle.setText(movieInfo.getTitle());
        Picasso.get().load(getString(R.string.image_base_url) + movieInfo.getPosterUrl())
                .resize(getBinding().ivPoster.getWidth(), getBinding().ivPoster.getHeight())
                .into(getBinding().ivPoster);
    }
}
