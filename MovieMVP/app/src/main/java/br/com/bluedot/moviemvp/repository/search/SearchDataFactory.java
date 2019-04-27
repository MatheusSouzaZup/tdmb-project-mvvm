package br.com.bluedot.moviemvp.repository.search;

import android.arch.lifecycle.MutableLiveData;
import android.arch.paging.DataSource;

import javax.inject.Inject;

import br.com.bluedot.moviemvp.model.MovieInfo;
import br.com.bluedot.moviemvp.service.TMDBApi;

public class SearchDataFactory extends DataSource.Factory<Integer, MovieInfo> {

    private TMDBApi tmdbApi;
    private MutableLiveData<SearchDataSource> mutableLiveData = new MutableLiveData<>();
    private SearchDataSource searchDataSource;
    private String searchContent;

    @Inject
    public SearchDataFactory(TMDBApi tmdbApi, String searchContent) {
        this.tmdbApi = tmdbApi;
        this.searchContent = searchContent;
    }

    @Override
    public DataSource<Integer, MovieInfo> create() {
        searchDataSource = new SearchDataSource(tmdbApi, searchContent);
        mutableLiveData.postValue(searchDataSource);
        return searchDataSource;
    }
}
