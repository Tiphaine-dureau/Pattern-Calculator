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
    public int computeOperation(List<String> inputs) {
        return inputs.stream().mapToInt(Integer::parseInt).sum();
    }
}
