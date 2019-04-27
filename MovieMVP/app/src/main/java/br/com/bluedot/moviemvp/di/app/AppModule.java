package br.com.bluedot.moviemvp.di.app;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import br.com.bluedot.moviemvp.MyApplication;
import br.com.bluedot.moviemvp.R;
import br.com.bluedot.moviemvp.room.AppDatabase;
import br.com.bluedot.moviemvp.service.APIClient;
import br.com.bluedot.moviemvp.service.TMDBApi;
import dagger.Module;
import dagger.Provides;


@Module
public class AppModule {

    @Provides
    @Singleton
    APIClient provideApiClient() {
        return new APIClient("https://api.themoviedb.org/3/");
    }

    @Provides
    @Singleton
    Context provideContext(Application app) {
        return app.getApplicationContext();
    }

    @Singleton
    @Provides
    TMDBApi provideFeedRepository(APIClient apiClient) {
        return apiClient.getRetrofit().create(TMDBApi.class);
    }

    @Provides
    @Singleton
    SharedPreferences providesSharedPreferences(Application application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    @Provides
    @Singleton
    AppDatabase providesRoomDb(Application app) {
        return ((MyApplication) app).getAppDb();
    }

}
