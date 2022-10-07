package com.costardstudio.patterns.features.observer.controller;

import com.costardstudio.patterns.features.observer.services.CalculatorService;

import java.awt.event.ActionEvent;
import java.util.List;

public class NumericButtonController extends CalculatorButtonController {
    public NumericButtonController(CalculatorService calculatorService, String label) {
        super(calculatorService, label);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.calculatorService.addInput(this.getActionView().getButton().getText());
    }

    @Override
    public int computeOperation(List<String> inputs) {
        return 0;
    }
}
