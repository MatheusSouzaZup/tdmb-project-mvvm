package br.com.bluedot.moviemvp.repository.search;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;

import javax.inject.Inject;

import br.com.bluedot.moviemvp.model.MovieInfo;
import br.com.bluedot.moviemvp.repository.BaseRepository;
import br.com.bluedot.moviemvp.service.TMDBApi;

public class SearchRepository extends BaseRepository {

    public TMDBApi mApi;

    @Inject
    public SearchRepository(TMDBApi mApi) {
        this.mApi = mApi;
    }

    public MutableLiveData<LiveData<PagedList<MovieInfo>>> getSearch(String searchContent) {
        SearchDataFactory searchDataFactory = new SearchDataFactory(mApi, searchContent);
        PagedList.Config pagedConfig = new PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setInitialLoadSizeHint(10)
                .setPageSize(10)
                .build();

        LiveData<PagedList<MovieInfo>> builder = new LivePagedListBuilder(searchDataFactory, pagedConfig).build();
        MutableLiveData<LiveData<PagedList<MovieInfo>>> data = new MutableLiveData<>();
        data.postValue(builder);
        return data;
    }
}
