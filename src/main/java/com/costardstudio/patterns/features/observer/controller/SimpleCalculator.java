package com.costardstudio.patterns.features.observer.controller;

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
        calculatorPanel.add(oneButton.getActionView().getButton());
        calculatorPanel.add(twoButton.getActionView().getButton());
        calculatorPanel.add(plusButton.getActionView().getButton());
        calculatorPanel.add(equalButton.getActionView().getButton());
    }

    public JPanel getCalculatorPanel() {
        return calculatorPanel;
    }
}
