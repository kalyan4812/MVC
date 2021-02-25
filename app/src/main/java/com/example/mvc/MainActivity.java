package com.example.mvc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.mvc.view.MVCMainActivityView;
import com.example.mvc.view.MainActivityViewImplementor;

import java.util.List;

public class MainActivity extends AppCompatActivity {
MainActivityViewImplementor mainActivityViewImplementor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivityViewImplementor=new MainActivityViewImplementor(MainActivity.this,null);

        setContentView(mainActivityViewImplementor.getRootView());
        mainActivityViewImplementor.initviews();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainActivityViewImplementor.bindDataToView();
    }
}
