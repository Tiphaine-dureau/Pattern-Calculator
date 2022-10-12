package com.costardstudio.patterns.features.observer.controller;

import com.costardstudio.patterns.features.observer.services.CalculatorService;

import java.awt.event.ActionEvent;
import java.util.List;

public class MultiplicationButtonController extends CalculatorButtonController {
    public MultiplicationButtonController(CalculatorService calculatorService) {
        super(calculatorService, "x");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.calculatorService.setOperation(this);
    }

    @Override
    public int computeOperation(List<String> inputs) {
        int multiplicationResult = Integer.parseInt(inputs.get(0));
        inputs.remove(0);
        for (String input : inputs) {
            multiplicationResult = multiplicationResult * Integer.parseInt(input);
        }
        return multiplicationResult;
    }
}
