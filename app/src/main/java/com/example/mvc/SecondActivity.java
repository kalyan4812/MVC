package com.example.mvc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mvc.view.SecondActivityViewImplementor;

public class SecondActivity extends AppCompatActivity {
SecondActivityViewImplementor secondActivityViewImplementor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        secondActivityViewImplementor=new SecondActivityViewImplementor(SecondActivity.this,null,getIntent());

        setContentView(secondActivityViewImplementor.getRootView());
        secondActivityViewImplementor.initviews();
    }

    @Override
    protected void onResume() {
        super.onResume();
        secondActivityViewImplementor.bindDataToView();
    }
}
