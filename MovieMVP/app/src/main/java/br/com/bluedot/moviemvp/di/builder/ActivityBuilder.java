
package br.com.bluedot.moviemvp.di.builder;


import br.com.bluedot.moviemvp.di.Activity;
import br.com.bluedot.moviemvp.view.MainActivity;
import br.com.bluedot.moviemvp.view.SplashActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module
public abstract class ActivityBuilder {

    @Activity
    @ContributesAndroidInjector
    abstract MainActivity bindMainActivity();

    @Activity
    @ContributesAndroidInjector
    abstract SplashActivity bindSplashActivity();


}
