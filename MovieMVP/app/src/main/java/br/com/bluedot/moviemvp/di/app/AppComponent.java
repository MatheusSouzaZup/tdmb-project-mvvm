package br.com.bluedot.moviemvp.di.app;

import android.app.Application;


import javax.inject.Singleton;

import br.com.bluedot.moviemvp.MyApplication;
import br.com.bluedot.moviemvp.di.builder.ActivityBuilder;
import br.com.bluedot.moviemvp.di.builder.FragmentBuilder;
import br.com.bluedot.moviemvp.di.builder.ViewModelBuilder;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AppModule.class,
        AndroidSupportInjectionModule.class,
        ActivityBuilder.class,
        FragmentBuilder.class,
        ViewModelBuilder.class})
public interface AppComponent {

    void inject(MyApplication application);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();

    }

}
