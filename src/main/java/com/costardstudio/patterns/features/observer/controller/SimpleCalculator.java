package com.costardstudio.patterns.features.observer.controller;

import com.costardstudio.patterns.features.observer.controller.AdditionButtonController;
import com.costardstudio.patterns.features.observer.controller.NumericButtonController;
import com.costardstudio.patterns.features.observer.controller.ResultButtonController;
import com.costardstudio.patterns.features.observer.services.CalculatorService;
import com.costardstudio.patterns.features.observer.view.InputScreen;
import com.costardstudio.patterns.features.observer.view.ResultScreen;

import javax.swing.*;

public class SimpleCalculator {

    JPanel calculatorPanel;
    CalculatorService calculatorService = new CalculatorService();

    public SimpleCalculator() {
        calculatorPanel = new JPanel();
        NumericButtonController oneButton = new NumericButtonController(this.calculatorService, "1");
        NumericButtonController twoButton = new NumericButtonController(this.calculatorService, "2");
        AdditionButtonController plusButton = new AdditionButtonController(this.calculatorService);
        ResultButtonController equalButton = new ResultButtonController(this.calculatorService);

        InputScreen currentInputLabel = new InputScreen();
        ResultScreen resultLabel = new ResultScreen();
        calculatorService.addObserver(currentInputLabel);
        calculatorService.addObserver(resultLabel);

        calculatorPanel.add(currentInputLabel.getLabel());
        calculatorPanel.add(resultLabel.getLabel());
        calculatorPanel.add(oneButton.getButton());
        calculatorPanel.add(twoButton.getButton());
        calculatorPanel.add(plusButton.getButton());
        calculatorPanel.add(equalButton.getButton());
    }

    public JPanel getCalculatorPanel() {
        return calculatorPanel;
    }
}
