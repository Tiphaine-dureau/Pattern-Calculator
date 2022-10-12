package com.costardstudio.patterns.features.observer.controller;

import com.costardstudio.patterns.features.observer.services.CalculatorService;

import java.awt.event.ActionEvent;
import java.util.List;

public class SubtractButtonController extends CalculatorButtonController {

    //CONSTRUCTOR
    public SubtractButtonController(CalculatorService calculatorService) {
        super(calculatorService, "-");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.calculatorService.setOperation(this);
    }

    @Override
    public int computeOperation(List<String> inputs) {
        int subtractResult = Integer.parseInt(inputs.get(0));
        inputs.remove(0);
        for (String input : inputs) {
            subtractResult = subtractResult - Integer.parseInt(input);
        }
        return subtractResult;
    }
}
