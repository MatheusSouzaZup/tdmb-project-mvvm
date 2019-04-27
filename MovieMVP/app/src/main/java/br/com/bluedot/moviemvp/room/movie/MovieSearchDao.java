package br.com.bluedot.moviemvp.room.movie;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by rafaelneiva on 31/10/18.
 */
@Dao
public interface MovieSearchDao {

    @Query("SELECT * FROM moviesearch")
    LiveData<List<MovieSearch>> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertLocation(MovieSearch movieSearch);
}
