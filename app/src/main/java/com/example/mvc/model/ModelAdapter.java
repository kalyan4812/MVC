package com.example.mvc.model;

import java.util.ArrayList;
import java.util.List;

public class ModelAdapter {
    List<String> toDoList = new ArrayList<String>();
    public List<String> getAllToDos() {




        return toDoList;
    }
    public void addItem(String s){
        toDoList.add(s);
    }

}
