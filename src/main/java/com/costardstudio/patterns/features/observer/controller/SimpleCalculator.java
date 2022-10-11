package com.costardstudio.patterns.features.observer.controller;

import com.costardstudio.patterns.features.observer.services.CalculatorService;
import com.costardstudio.patterns.features.observer.view.CalculatorView;
import com.costardstudio.patterns.features.observer.view.InputScreen;
import com.costardstudio.patterns.features.observer.view.ResultScreen;

import javax.swing.*;
import java.awt.*;

public class SimpleCalculator {
    CalculatorService calculatorService = new CalculatorService();
    private final JPanel screenPanel;

    private final JPanel calculatorPanel;
    private final CalculatorView calculatorView;

    //Constructor
    public SimpleCalculator() {
        calculatorPanel = new JPanel();
        screenPanel = new JPanel();
        calculatorView = new CalculatorView();
        configureInterfaceCalculatorPanel();
    }

    public void configureScreenPanel() {
        GridLayout screenGridLayout = new GridLayout(2, 1);
        configureInputScreen();
        configureResultScreen();
        this.screenPanel.setLayout(screenGridLayout);

    }

    public void configureResultScreen() {
        ResultScreen resultScreen = new ResultScreen();
        calculatorService.addObserver(resultScreen);
        screenPanel.add(resultScreen.getLabel());
    }

    public void configureInputScreen() {
        InputScreen inputScreen = new InputScreen();
        calculatorService.addObserver(inputScreen);
        screenPanel.add(inputScreen.getLabel());
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
        calculatorPanel.add(screenPanel);
        calculatorPanel.add(this.calculatorView.getNumericButtonsPanel());
        calculatorPanel.add(this.calculatorView.getOperatorButtonsPanel());
        calculatorPanel.setLayout(interfaceGridLayout);
    }

    public JPanel getCalculatorPanel() {
        return calculatorPanel;
    }
}
