package com.example.mvc.view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.mvc.R;
import com.example.mvc.SecondActivity;
import com.example.mvc.controller.MVCMainController;
import com.example.mvc.model.MVCModelImplementor;
import com.example.mvc.model.ModelAdapter;
import com.example.mvc.model.Observer;

import java.util.List;

public class MainActivityViewImplementor implements MVCMainActivityView, Observer {
    View rootview;
    MVCMainController mvcController;
    MVCModelImplementor mvcModelImplementor;
    Button button;
    EditText editText;
    ListView listView;

    public MainActivityViewImplementor(Context context, ViewGroup viewGroup) {
        this.rootview = LayoutInflater.from(context).inflate(R.layout.activity_main, viewGroup);
        mvcModelImplementor = new MVCModelImplementor(new ModelAdapter());
        mvcController = new MVCMainController(mvcModelImplementor, this);
        mvcModelImplementor.registerObserver(this);
    }

    @Override
    public View getRootView() {
        return rootview;
    }

    @Override
    public void initviews() {
        editText=(EditText)rootview.findViewById(R.id.editText);
        button = (Button) rootview.findViewById(R.id.button);
        listView=(ListView)rootview.findViewById(R.id.listview);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              mvcController.onAddButtonClicked(editText.getText().toString());
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    mvcController.onToDoItemSelected(parent.getItemAtPosition(position)+"");

            }
        });
    }
    public  void navigateToDataManipulationActivity(String s){
        Intent intent = new Intent(rootview.getContext(), SecondActivity.class);
        intent.putExtra("todoId", s);
        rootview.getContext().startActivity(intent);
    }
    @Override
    public void bindDataToView() {
        mvcController.onViewLoaded();
    }

    @Override
    public void showitems(List<String> strings) {

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(rootview.getContext(), android.R.layout.simple_dropdown_item_1line, strings);
        listView.setAdapter(arrayAdapter);
    }

    @Override
    public void update() {
       try {
           ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(rootview.getContext(), android.R.layout.simple_dropdown_item_1line,mvcModelImplementor.getlist());
           listView.setAdapter(arrayAdapter);
       }
       catch (Exception e){

       }
    }
}
