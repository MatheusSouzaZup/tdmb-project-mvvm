package br.com.bluedot.moviemvp.service;

import br.com.bluedot.moviemvp.model.MovieResponse;
import br.com.bluedot.moviemvp.repository.BaseData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TMDBApi {

    @GET("search/movie")
    Call<MovieResponse> getSearch(@Query("query") String query,
                                  @Query("page") String page);

    @GET("movie/popular")
    Call<MovieResponse> getPopular();

    @GET("movie/now_playing")
    Call<MovieResponse> getNowPlaying();

    @GET("movie/upcoming")
    Call<MovieResponse> getUpComing();
}
