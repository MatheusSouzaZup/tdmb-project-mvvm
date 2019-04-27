package br.com.bluedot.moviemvp.service;

import android.support.annotation.NonNull;

import com.google.gson.GsonBuilder;


import java.util.concurrent.TimeUnit;

import br.com.bluedot.moviemvp.MyApplication;
import br.com.bluedot.moviemvp.util.Utils;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class APIClient {
    private static APIClient mInstance;

    public synchronized static APIClient getInstance() {
        return mInstance;
    }

    private Retrofit mRetrofit;
    private OkHttpClient mClient;

    public APIClient(@NonNull String baseUrl) {
        mInstance = this;
        mClient = getClient(baseUrl);

        GsonBuilder builder = new GsonBuilder();

        mRetrofit = new Retrofit
                .Builder()
                .baseUrl(baseUrl)
                .client(mClient)
                .addConverterFactory(GsonConverterFactory.create(builder.create()))
                .build();
    }

    private OkHttpClient getClient(String baseUrl) {
        return new OkHttpClient()
                .newBuilder()
                .addInterceptor(checkConnectionInterceptor)
                .addInterceptor(requestIntercept)
                .addInterceptor(getLoggingCapableHttpClient())
                .connectTimeout(90, TimeUnit.SECONDS)
                .readTimeout(90, TimeUnit.SECONDS)
                .build();
    }

    private final Interceptor checkConnectionInterceptor = chain -> {
        if (!Utils.isOnline(MyApplication.getInstance())) {
            throw new NoConnectionException();
        }
        return chain.proceed(chain.request());
    };

    private HttpLoggingInterceptor getLoggingCapableHttpClient() {
        HttpLoggingInterceptor mLogging = new HttpLoggingInterceptor();
        mLogging.setLevel(HttpLoggingInterceptor.Level.BODY);

        return mLogging;
    }

    private final Interceptor requestIntercept = chain -> {

        Request request = chain.request();
        HttpUrl url = request.url().newBuilder()
                .addQueryParameter("api_key", "80b3f05a58b05cf305a2a1adedc7e7f1")
                .addQueryParameter("language", "pt-BR").build();
        request = request.newBuilder().url(url).build();

        return chain.proceed(request);
    };

    public void cancelAllRequests() {
        getInstance().mClient.dispatcher().cancelAll();
    }

    public Retrofit getRetrofit() {
        return mRetrofit;
    }

    public OkHttpClient getOkHttpClient() {
        return mClient;
    }

}


