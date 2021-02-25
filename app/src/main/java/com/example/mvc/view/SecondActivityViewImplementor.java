package com.example.mvc.view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvc.R;
import com.example.mvc.controller.MVCMainController;
import com.example.mvc.controller.MVCSecondController;
import com.example.mvc.model.MVCModelImplementor;
import com.example.mvc.model.ModelAdapter;
import com.example.mvc.model.Observer;

public class SecondActivityViewImplementor implements MVCView, Observer {

    View rootview;
    MVCSecondController mvcController;
    MVCModelImplementor mvcModelImplementor;
    String string;
    TextView textView;

    public SecondActivityViewImplementor(Context context, ViewGroup viewGroup, Intent intent) {
        this.rootview = LayoutInflater.from(context).inflate(R.layout.activity_second, null);
        mvcModelImplementor = new MVCModelImplementor(new ModelAdapter());
        mvcController = new MVCSecondController(mvcModelImplementor, this);
        string = intent.getStringExtra("todoId");
        mvcModelImplementor.registerObserver(this);


    }


    @Override
    public View getRootView() {
        return rootview;
    }

    @Override
    public void initviews() {

        textView = (TextView) rootview.findViewById(R.id.textView);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(rootview.getContext(), textView.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void showitem() {
        textView.setText(string);
    }

    @Override
    public void bindDataToView() {
        // textView.setText(string);
        mvcController.onViewLoaded();
    }

    @Override
    public void update() {

    }
}
