package br.com.bluedot.moviemvp.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.paging.PagedList;

import java.util.Observable;

import javax.inject.Inject;

import br.com.bluedot.moviemvp.model.MovieInfo;
import br.com.bluedot.moviemvp.repository.search.SearchRepository;

public class SearchViewModel extends BaseViewModel {
    private SearchRepository mRepository;
    MediatorLiveData<LiveData<PagedList<MovieInfo>>> mMediatorPagedSearch;
    MutableLiveData<LiveData<MovieInfo>> mLiveDataPagedSearch;

    @Inject
    public SearchViewModel(SearchRepository repository) {
        mRepository = repository;
    }

    public void getSearch(String searchContent) {

    }

//    private LiveData<PagedList<MovieInfo>> getSearchPaged(String searchContent) {
//        return Transformations.map(mRepository.getSearch(searchContent),input -> { return  input;});
//    }

}
