package com.costardstudio.patterns.features.observer.controller;

import com.costardstudio.patterns.features.observer.services.CalculatorService;

import java.awt.event.ActionEvent;
import java.util.List;

public class DivisionButtonController extends CalculatorButtonController {
    public DivisionButtonController(CalculatorService calculatorService) {
        super(calculatorService, "/");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.calculatorService.setOperation(this);
    }

    @Override
    public float computeOperation(List<String> inputs) {
        float divisionResult = Float.parseFloat(inputs.get(0));
        inputs.remove(0);
        for (String input : inputs) {
            divisionResult = divisionResult / Float.parseFloat(input);
        }
        return divisionResult;
    }
}

