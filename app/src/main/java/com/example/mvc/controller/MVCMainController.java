package com.example.mvc.controller;

import com.example.mvc.model.MVCModelImplementor;
import com.example.mvc.view.MainActivityViewImplementor;

public class MVCMainController implements MVCControllers {
    MVCModelImplementor mvcModel;
    MainActivityViewImplementor mvcView;

    public MVCMainController(MVCModelImplementor mvcModel, MainActivityViewImplementor mvcView) {
        this.mvcModel = mvcModel;
        this.mvcView = mvcView;
    }

    public void onViewLoaded() {
        mvcView.showitems(mvcModel.getlist());

    }

    public void onAddButtonClicked(String s) {
        mvcModel.addItem(s);
        //mvcView.showitems(mvcModel.getlist());

    }

    public void onToDoItemSelected(String toDoId) {
        mvcView.navigateToDataManipulationActivity(toDoId);
    }
}
