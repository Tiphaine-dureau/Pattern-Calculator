package com.costardstudio.patterns.features.observer.controller;

import com.costardstudio.patterns.features.observer.services.CalculatorService;

import java.awt.event.ActionEvent;
import java.util.List;

public class AdditionButtonController extends CalculatorButtonController {
    public AdditionButtonController(CalculatorService calculatorService) {
        super(calculatorService, "+");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.calculatorService.setOperation(this);
    }

    @Override
    public float computeOperation(List<String> inputs) {
        float additionResult = Float.parseFloat(inputs.get(0));
        inputs.remove(0);
        for (String input : inputs) {
            additionResult = additionResult + Float.parseFloat(input);
        }
        return additionResult;
    }
}
