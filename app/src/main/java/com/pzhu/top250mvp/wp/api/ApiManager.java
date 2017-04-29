package com.pzhu.top250mvp.wp.api;

import com.pzhu.top250mvp.wp.ToStringConverterFactory;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

public class ApiManager {
    private static final String BASE_URL = "http://api.douban.com/";

    private static Retrofit retrofit = new Retrofit.Builder().
            baseUrl(BASE_URL)
            .addConverterFactory(new ToStringConverterFactory())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build();

    private static final MovieService movieService = retrofit.create(MovieService.class);

    public static Observable<String> getMovieData(int start, int count) {
        return movieService.getMovie(start, count);
    }
}
