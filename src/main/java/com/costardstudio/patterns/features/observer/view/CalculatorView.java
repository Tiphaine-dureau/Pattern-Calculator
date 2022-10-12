package com.costardstudio.patterns.features.observer.view;

import com.costardstudio.patterns.features.observer.controller.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class CalculatorView {
    private final JPanel screenPanel;
    private final JPanel numericButtonsPanel;
    private final JPanel operatorButtonsPanel;
    private final InputScreen inputScreen;
    private final ResultScreen resultScreen;
    private final JPanel calculatorPanel;


    // CONSTRUCTOR
    public CalculatorView() {
        screenPanel = new JPanel();
        inputScreen = new InputScreen();
        resultScreen = new ResultScreen();
        numericButtonsPanel = new JPanel();
        numericButtonsPanel.setLayout(new GridLayout(4, 3));
        operatorButtonsPanel = new JPanel();
        calculatorPanel = new JPanel();
    }

    public void configureInterfaceCalculatorPanel(List<NumericButtonController> numericButtonControllers,
                                                  AdditionButtonController plusButtonController,
                                                  SubtractButtonController minusButtonController,
                                                  ResultButtonController equalButtonController) {
        GridLayout interfaceGridLayout = new GridLayout(3, 1);
        configureScreenPanel();
        configureNumericPanel(numericButtonControllers);
        configureOperationsPanel(plusButtonController, minusButtonController, equalButtonController);
        calculatorPanel.add(this.screenPanel);
        calculatorPanel.add(this.numericButtonsPanel);
        calculatorPanel.add(this.operatorButtonsPanel);
        calculatorPanel.setLayout(interfaceGridLayout);
    }

    private void configureScreenPanel() {
        GridLayout screenGridLayout = new GridLayout(2, 1);
        this.screenPanel.add(this.inputScreen.getLabel());
        this.screenPanel.add(this.resultScreen.getLabel());
        this.screenPanel.setLayout(screenGridLayout);
    }

    private void configureNumericPanel(List<NumericButtonController> numericButtonControllers) {
        // TODO utiliser la méthode addButtonToPanel
        numericButtonControllers.forEach((NumericButtonController buttonController) -> numericButtonsPanel.add(buttonController.getActionView().getButton()));
    }

    private void configureOperationsPanel(AdditionButtonController plusButtonController,
                                          SubtractButtonController minusButtonController,
                                          ResultButtonController equalButtonController) {
        // TODO utiliser la méthode addButtonToPanel
        operatorButtonsPanel.add(plusButtonController.getActionView().getButton());
        operatorButtonsPanel.add(minusButtonController.getActionView().getButton());
        operatorButtonsPanel.add(equalButtonController.getActionView().getButton());
    }

    private void addButtonToPanel(JPanel panel, CalculatorButtonController controller) {
        // TODO
    }

    // GETTERS / SETTERS

    public InputScreen getInputScreen() {
        return inputScreen;
    }

    public ResultScreen getResultScreen() {
        return resultScreen;
    }

    public JPanel getCalculatorPanel() {
        return calculatorPanel;
    }
}
