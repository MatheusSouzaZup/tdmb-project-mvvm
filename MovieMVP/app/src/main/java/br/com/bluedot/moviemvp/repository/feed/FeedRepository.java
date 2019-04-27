package br.com.bluedot.moviemvp.repository.feed;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import javax.inject.Inject;

import br.com.bluedot.moviemvp.model.MovieResponse;
import br.com.bluedot.moviemvp.repository.BaseData;
import br.com.bluedot.moviemvp.repository.BaseRepository;
import br.com.bluedot.moviemvp.service.BaseCallback;
import br.com.bluedot.moviemvp.service.TMDBApi;

public class FeedRepository extends BaseRepository {

    public TMDBApi mApi;

    @Inject
    public FeedRepository(TMDBApi mApi) {
        this.mApi = mApi;
    }

    public LiveData<MovieResponse> getPopular() {
        MutableLiveData<MovieResponse> data = new MutableLiveData<>();

        mApi.getPopular().enqueue(new BaseCallback<MovieResponse>() {
            @Override
            public void onSuccess(MovieResponse response) {
                data.setValue(response);
            }

            @Override
            public void onError(BaseData error) {
//                data.setValue(error.getData());
            }
        });
        return data;
    }

    public LiveData<MovieResponse> getNowPlaying() {
        MutableLiveData<MovieResponse> data = new MutableLiveData<>();

        mApi.getNowPlaying().enqueue(new BaseCallback<MovieResponse>() {
            @Override
            public void onSuccess(MovieResponse response) {
                data.setValue(response);
            }

            @Override
            public void onError(BaseData error) {
//                data.setValue(error);
            }
        });
        return data;
    }

    public LiveData<MovieResponse> getUpComing() {
        MutableLiveData<MovieResponse> data = new MutableLiveData<>();

        mApi.getUpComing().enqueue(new BaseCallback<MovieResponse>() {
            @Override
            public void onSuccess(MovieResponse response) {
                data.setValue(response);
            }

            @Override
            public void onError(BaseData error) {
//                data.setValue(error);
            }
        });
        return data;
    }
}
