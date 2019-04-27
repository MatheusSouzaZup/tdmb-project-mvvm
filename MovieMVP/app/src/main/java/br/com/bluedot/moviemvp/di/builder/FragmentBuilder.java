package br.com.bluedot.moviemvp.di.builder;

import br.com.bluedot.moviemvp.di.Fragment;
import br.com.bluedot.moviemvp.view.feed.FeedFragment;
import br.com.bluedot.moviemvp.view.search.SearchFragment;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module
public abstract class FragmentBuilder {

    @Fragment
    @ContributesAndroidInjector
    abstract FeedFragment bindFeedFragment();

    @Fragment
    @ContributesAndroidInjector
    abstract SearchFragment bindSearchFragment();

}
