package br.com.bluedot.moviemvp.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Transformations;

import java.util.List;

import javax.inject.Inject;

import br.com.bluedot.moviemvp.model.MovieInfo;
import br.com.bluedot.moviemvp.model.MovieResponse;
import br.com.bluedot.moviemvp.repository.feed.FeedRepository;

public class FeedViewModel extends BaseViewModel<FeedViewModel.Navigator> {
    private FeedRepository mRepository;

    @Inject
    public FeedViewModel(FeedRepository repository) {
        mRepository = repository;
    }


    public LiveData<List<MovieInfo>> getPopular() {
        return Transformations.map(mRepository.getPopular(), MovieResponse::getMovieInfos);
    }

    public LiveData<List<MovieInfo>> getNowPlaying() {
        return Transformations.map(mRepository.getNowPlaying(), MovieResponse::getMovieInfos);
    }

    public LiveData<List<MovieInfo>> getUpComing() {
        return Transformations.map(mRepository.getUpComing(), MovieResponse::getMovieInfos);
    }


    interface Navigator {

    }
}
