package br.com.bluedot.moviemvp.repository.search;

import android.arch.paging.PageKeyedDataSource;
import android.support.annotation.NonNull;

import javax.inject.Inject;

import br.com.bluedot.moviemvp.model.MovieInfo;
import br.com.bluedot.moviemvp.model.MovieResponse;
import br.com.bluedot.moviemvp.repository.BaseData;
import br.com.bluedot.moviemvp.service.BaseCallback;
import br.com.bluedot.moviemvp.service.TMDBApi;

public class SearchDataSource extends PageKeyedDataSource<Integer, MovieInfo> {
    private TMDBApi tmdbApi;
    private String searchContent;

    @Inject
    public SearchDataSource(TMDBApi tmdbApi, String searchContent) {
        this.tmdbApi = tmdbApi;
        this.searchContent = searchContent;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, MovieInfo> callback) {
        int initialPage = 1;
        tmdbApi.getSearch(searchContent, Integer.toString(initialPage)).enqueue(new BaseCallback<MovieResponse>() {
            @Override
            public void onSuccess(MovieResponse response) {
                callback.onResult(response.getMovieInfos(),
                        initialPage,
                        initialPage + 1);
            }

            @Override
            public void onError(BaseData error) {

            }
        });
    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, MovieInfo> callback) {
        int page = params.key;
        tmdbApi.getSearch(searchContent, Integer.toString(page)).enqueue(new BaseCallback<MovieResponse>() {
            @Override
            public void onSuccess(MovieResponse response) {
                callback.onResult(response.getMovieInfos(), page + 1);
            }

            @Override
            public void onError(BaseData error) {

            }
        });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, MovieInfo> callback) {

    }
}
