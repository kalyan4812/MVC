package com.example.mvc.controller;

import com.example.mvc.model.MVCModelImplementor;
import com.example.mvc.view.SecondActivityViewImplementor;

public class MVCSecondController implements MVCControllers {
    MVCModelImplementor mvcModel;
    SecondActivityViewImplementor secondActivityViewImplementor;
    public MVCSecondController(MVCModelImplementor mvcModelImplementor,SecondActivityViewImplementor secondActivityViewImplementor){
        this.mvcModel=mvcModelImplementor;
        this.secondActivityViewImplementor=secondActivityViewImplementor;
    }
    @Override
    public void onViewLoaded() {
      secondActivityViewImplementor.showitem();
    }
}
