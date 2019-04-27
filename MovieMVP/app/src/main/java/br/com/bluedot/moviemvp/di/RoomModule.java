package br.com.bluedot.moviemvp.di;



import javax.inject.Singleton;

import br.com.bluedot.moviemvp.room.AppDatabase;
import br.com.bluedot.moviemvp.room.movie.MovieSearchDao;
import dagger.Module;
import dagger.Provides;

/**
 * Created by rafaelneiva on 31/10/18.
 */
@Module
public class RoomModule {

    @Provides
    @Singleton
    MovieSearchDao providesRoomDb(AppDatabase appDb) {
        return appDb.movieSearchDao();
    }
}
