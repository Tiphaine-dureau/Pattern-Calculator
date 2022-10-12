package com.costardstudio.patterns.features.observer.controller;

import com.costardstudio.patterns.features.observer.services.CalculatorService;

import java.awt.event.ActionEvent;
import java.util.List;

public class SubtractButtonController extends CalculatorButtonController {

    //CONSTRUCTOR
    public SubtractButtonController(CalculatorService calculatorService){
        super(calculatorService, "-");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.calculatorService.setOperation(this);
    }

    @Override
    public int computeOperation(List<String> inputs) {
        String a = inputs.get(0);
        String b = inputs.get(1);
        int subtraction = Integer.parseInt(a) - Integer.parseInt(b) ;
        return subtraction;
    }
}
