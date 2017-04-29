package com.pzhu.top250mvp.wp.api;


import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface MovieService {

    @GET("v2/movie/top250")
    Observable<String> getMovie(@Query("start") int start, @Query("count") int count);
}
