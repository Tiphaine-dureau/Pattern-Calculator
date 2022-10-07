package com.costardstudio.patterns.features.observer.controller;

import com.costardstudio.patterns.features.observer.controller.CalculatorButtonController;
import com.costardstudio.patterns.features.observer.services.CalculatorService;

import java.awt.event.ActionEvent;
import java.util.List;

public class NumericButtonController extends CalculatorButtonController {
    public NumericButtonController(CalculatorService calculatorService, String buttonLabel) {
        super(calculatorService, buttonLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.calculatorService.addInput(this.button.getText());
    }

    @Override
    public int computeOperation(List<String> inputs) {
        return 0;
    }
}
