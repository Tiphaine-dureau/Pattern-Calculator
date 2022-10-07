package com.costardstudio.patterns.features.observer.controller;

import com.costardstudio.patterns.features.observer.controller.CalculatorButtonController;
import com.costardstudio.patterns.features.observer.services.CalculatorService;

import java.awt.event.ActionEvent;
import java.util.List;

public class ResultButtonController extends CalculatorButtonController {
    public ResultButtonController(CalculatorService calculatorService) {
        super(calculatorService, "=");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.calculatorService.compute();
    }

    @Override
    public int computeOperation(List<String> inputs) {
        return 0;
    }
}
