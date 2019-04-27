package br.com.bluedot.moviemvp.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import br.com.bluedot.moviemvp.room.movie.MovieSearch;
import br.com.bluedot.moviemvp.room.movie.MovieSearchDao;


@Database(entities = {MovieSearch.class}, version = 2, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract MovieSearchDao movieSearchDao();
}
