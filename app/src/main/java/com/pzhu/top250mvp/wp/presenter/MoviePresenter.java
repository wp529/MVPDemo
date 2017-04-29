package com.pzhu.top250mvp.wp.presenter;

import com.pzhu.top250mvp.wp.model.IMovie;
import com.pzhu.top250mvp.wp.model.MovieImpl;
import com.pzhu.top250mvp.wp.view.IMAin;

public class MoviePresenter implements MovieImpl.MovieListener{
    private IMAin iMain;
    private IMovie iMovie;

    public MoviePresenter(IMAin iMain){
        this.iMain = iMain;
        iMovie = new MovieImpl(this);
    }

    public void getMovieData(){
        iMain.showDialog();
        iMovie.getMovieData();
    }

    @Override
    public void success(String s) {
        iMain.hideDialog();
        iMain.loadMovieData(s);
    }

    @Override
    public void fali() {
        iMain.fail();
    }
}
