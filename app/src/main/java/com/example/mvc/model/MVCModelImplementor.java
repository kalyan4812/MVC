package com.example.mvc.model;

import java.util.ArrayList;
import java.util.List;

public class MVCModelImplementor implements MVCModel {
    ModelAdapter modelAdapter;
    List<String> names;
    List<Observer> observers;

    public MVCModelImplementor(ModelAdapter modelAdapter) {
        this.modelAdapter = modelAdapter;
        this.names = modelAdapter.getAllToDos();
        observers = new ArrayList<>();
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    @Override
    public List<String> getlist() {
        return names;
    }

    @Override
    public void addItem(String s) {
        modelAdapter.addItem(s);
        notifyObservers();
    }
}
