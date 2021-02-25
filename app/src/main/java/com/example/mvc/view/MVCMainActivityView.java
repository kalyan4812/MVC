package com.example.mvc.view;

import android.view.View;

import java.util.List;

public interface MVCMainActivityView  extends MVCView{
    @Override
    View getRootView();

    @Override
    void initviews();


    @Override
    void bindDataToView();

    public void showitems(List<String> strings );
}
