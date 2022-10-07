package com.costardstudio.patterns.features.observer.controller;

import com.costardstudio.patterns.features.observer.services.CalculatorService;
import com.costardstudio.patterns.features.observer.view.InputScreen;
import com.costardstudio.patterns.features.observer.view.ResultScreen;

import javax.swing.*;
import java.awt.*;

public class SimpleCalculator {
    CalculatorService calculatorService = new CalculatorService();
    private final JPanel screenPanel;
    private final JPanel numericButtonsPanel;
    private final JPanel operatorButtonsPanel;
    private final JPanel calculatorPanel;

    //Constructor
    public SimpleCalculator() {
        calculatorPanel = new JPanel();
        screenPanel = new JPanel();
        numericButtonsPanel = new JPanel();
        operatorButtonsPanel = new JPanel();
        configureInterfaceCalculatorPanel();
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

    public void configureNumericButtonsPanel(){
        GridLayout numericScreenGridLayout = new GridLayout(4,3);

        for (int i = 0; i <= 9; i++) {
            NumericButtonController buttonController = new NumericButtonController(this.calculatorService,String.valueOf(i));
            numericButtonsPanel.add(buttonController.getActionView().getButton());
        }

        this.numericButtonsPanel.setLayout(numericScreenGridLayout);
    }

    public void configureOperatorButtonsPanel(){
        AdditionButtonController plusButton = new AdditionButtonController(this.calculatorService);
        ResultButtonController equalButton = new ResultButtonController(this.calculatorService);

        operatorButtonsPanel.add(plusButton.getActionView().getButton());
        operatorButtonsPanel.add(equalButton.getActionView().getButton());

    }

    public void configureInterfaceCalculatorPanel() {
        GridLayout interfaceGridLayout = new GridLayout(3, 1);
        configureScreenPanel();
        configureNumericButtonsPanel();
        configureOperatorButtonsPanel();
        calculatorPanel.add(screenPanel);
        calculatorPanel.add(numericButtonsPanel);
        calculatorPanel.add(operatorButtonsPanel);
        calculatorPanel.setLayout(interfaceGridLayout);
    }

    public JPanel getCalculatorPanel() {
        return calculatorPanel;
    }
}
