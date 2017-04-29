package com.pzhu.top250mvp.wp.view;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.pzhu.top250mvp.R;
import com.pzhu.top250mvp.wp.presenter.MoviePresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements IMAin{
    @Bind(R.id.tv_movies)
    TextView tv;
    private ProgressDialog myDialog;
    private MoviePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new MoviePresenter(this);
    }

    @Override
    public void showDialog() {
        myDialog = new ProgressDialog(this);
        myDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        myDialog.setMessage("加载中……");
        myDialog.setIndeterminate(false);
        myDialog.setCancelable(false);
        myDialog.show();
    }

    @Override
    public void fail() {
        Toast.makeText(this,"服务器异常",Toast.LENGTH_SHORT).show();
        myDialog.dismiss();
    }

    @Override
    public void loadMovieData(String s) {
        tv.setText(s);
    }

    @Override
    public void hideDialog() {
        myDialog.dismiss();
    }

    @OnClick(R.id.btn_click)
    public void getData(View view){
        presenter.getMovieData();
    }
}
