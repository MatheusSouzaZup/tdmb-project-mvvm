package br.com.bluedot.moviemvp.di.builder;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import br.com.bluedot.moviemvp.di.ViewModelKey;
import br.com.bluedot.moviemvp.viewmodel.FeedViewModel;
import br.com.bluedot.moviemvp.viewmodel.MainViewModel;
import br.com.bluedot.moviemvp.viewmodel.SearchViewModel;
import br.com.bluedot.moviemvp.viewmodel.ViewModelProviderFactory;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;


@Module
public abstract class ViewModelBuilder {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    abstract ViewModel bindMainViewModel(MainViewModel mainViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(FeedViewModel.class)
    abstract ViewModel bindFeedViewModel(FeedViewModel feedViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel.class)
    abstract ViewModel bindSearchViewModel(SearchViewModel searchViewModel);

    // ViewModel Factory
    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory factory);
}
