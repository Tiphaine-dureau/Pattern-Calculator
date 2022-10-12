package com.costardstudio.patterns.features.observer.controller;

import com.costardstudio.patterns.features.observer.services.CalculatorService;
import com.costardstudio.patterns.features.observer.view.CalculatorView;
import com.costardstudio.patterns.features.observer.view.InputScreen;
import com.costardstudio.patterns.features.observer.view.ResultScreen;

import javax.swing.*;
import java.awt.*;

public class SimpleCalculator {
    CalculatorService calculatorService = new CalculatorService();
    private final JPanel calculatorPanel;
    private final CalculatorView calculatorView;

    //Constructor
    public SimpleCalculator() {
        calculatorPanel = new JPanel();
        calculatorView = new CalculatorView();
        configureInterfaceCalculatorPanel();
    }

    public void configureResultScreen(ResultScreen resultScreen) {
        calculatorService.addObserver(resultScreen);
    }

    public void configureInputScreen(InputScreen inputScreen) {
        calculatorService.addObserver(inputScreen);
    }

    public void configureScreenPanel() {
        configureInputScreen(this.calculatorView.getInputScreen());
        configureResultScreen(this.calculatorView.getResultScreen());
    }

    public void configureNumericButtonsPanel() {
        for (int i = 0; i <= 9; i++) {
            NumericButtonController buttonController = new NumericButtonController(this.calculatorService, String.valueOf(i));
            this.calculatorView.addNumericButtonToButtonsPanel(buttonController);
        }
    }

    public void configureOperatorButtonsPanel() {
        AdditionButtonController plusButton = new AdditionButtonController(this.calculatorService);
        ResultButtonController equalButton = new ResultButtonController(this.calculatorService);
        this.calculatorView.addOperationsViewToButtonsPanel(plusButton, equalButton);
    }

    public void configureInterfaceCalculatorPanel() {
        GridLayout interfaceGridLayout = new GridLayout(3, 1);
        configureScreenPanel();
        configureNumericButtonsPanel();
        configureOperatorButtonsPanel();
        calculatorPanel.add(this.calculatorView.getScreenPanel());
        calculatorPanel.add(this.calculatorView.getNumericButtonsPanel());
        calculatorPanel.add(this.calculatorView.getOperatorButtonsPanel());
        calculatorPanel.setLayout(interfaceGridLayout);
    }

    public JPanel getCalculatorPanel() {
        return calculatorPanel;
    }
}
