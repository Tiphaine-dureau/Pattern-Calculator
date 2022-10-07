package com.costardstudio.patterns.features.observer.controller;

import com.costardstudio.patterns.features.observer.services.CalculatorService;
import com.costardstudio.patterns.features.observer.view.InputScreen;
import com.costardstudio.patterns.features.observer.view.ResultScreen;

import javax.swing.*;
import java.awt.*;

public class SimpleCalculator {

    JPanel calculatorPanel;
    CalculatorService calculatorService = new CalculatorService();
    private final JPanel screenPanel;

    //Constructor
    public SimpleCalculator() {
        calculatorPanel = new JPanel();
        screenPanel = new JPanel();

        NumericButtonController oneButton = new NumericButtonController(this.calculatorService, "1");
        NumericButtonController twoButton = new NumericButtonController(this.calculatorService, "2");
        AdditionButtonController plusButton = new AdditionButtonController(this.calculatorService);
        ResultButtonController equalButton = new ResultButtonController(this.calculatorService);

        calculatorPanel.add(screenPanel);

        calculatorPanel.add(oneButton.getActionView().getButton());
        calculatorPanel.add(twoButton.getActionView().getButton());
        calculatorPanel.add(plusButton.getActionView().getButton());
        calculatorPanel.add(equalButton.getActionView().getButton());

        configureScreenPanel();

    }

    public JPanel getCalculatorPanel() {
        return calculatorPanel;
    }

    public void configureScreenPanel(){
        GridLayout screenGridLayout = new GridLayout( 2,1);
        configureInputScreen();
        configureResultScreen();
        this.screenPanel.setLayout(screenGridLayout);
    }

    public void configureResultScreen(){
        ResultScreen resultScreen = new ResultScreen();
        calculatorService.addObserver(resultScreen);
        screenPanel.add(resultScreen.getLabel());
    }

    public void configureInputScreen(){
        InputScreen inputScreen = new InputScreen();
        calculatorService.addObserver(inputScreen);
        screenPanel.add(inputScreen.getLabel());
    }
}
