package com.pzhu.top250mvp.wp.model;


import android.text.TextUtils;

import com.pzhu.top250mvp.wp.api.ApiManager;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MovieImpl implements IMovie{
    private MovieListener listener;

    public MovieImpl(MovieListener listener){
        this.listener = listener;
    }
    @Override
    public void getMovieData() {
        Observable<String> observable = ApiManager.getMovieData(0, 10);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        if(listener != null && !TextUtils.isEmpty(s)){
                            listener.success(s);
                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        listener.fali();
                        System.out.println(throwable.getMessage());
                    }
                });
    }

    public interface MovieListener{
        void success(String s);
        void fali();
    }
}
