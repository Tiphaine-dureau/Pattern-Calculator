package com.costardstudio.patterns.features.observer.view;

import com.costardstudio.patterns.features.observer.controller.AdditionButtonController;
import com.costardstudio.patterns.features.observer.controller.NumericButtonController;
import com.costardstudio.patterns.features.observer.controller.ResultButtonController;

import javax.swing.*;
import java.awt.*;


public class CalculatorView {
    private final JPanel screenPanel;
    private final JPanel numericButtonsPanel;
    private final JPanel operatorButtonsPanel;
    private final InputScreen inputScreen;
    private final ResultScreen resultScreen;


    public CalculatorView() {
        screenPanel = new JPanel();
        inputScreen = new InputScreen();
        resultScreen = new ResultScreen();
        numericButtonsPanel = new JPanel();
        numericButtonsPanel.setLayout(new GridLayout(4, 3));
        operatorButtonsPanel = new JPanel();
        configureScreenPanel();
    }

    public void addResultScreen() {
        screenPanel.add(this.resultScreen.getLabel());
    }

    public void addInputScreen() {
        screenPanel.add(this.inputScreen.getLabel());
    }

    public void configureScreenPanel() {
        GridLayout screenGridLayout = new GridLayout(2, 1);
        addInputScreen();
        addResultScreen();
        this.screenPanel.setLayout(screenGridLayout);

    }

    public void addNumericButtonToButtonsPanel(NumericButtonController numericButtonControllers) {
        numericButtonsPanel.add(numericButtonControllers.getActionView().getButton());
    }

    public void addOperationsViewToButtonsPanel(AdditionButtonController plusButton,
                                                ResultButtonController equalButton) {
        operatorButtonsPanel.add(plusButton.getActionView().getButton());
        operatorButtonsPanel.add(equalButton.getActionView().getButton());
    }

    public JPanel getOperatorButtonsPanel() {
        return operatorButtonsPanel;
    }

    public JPanel getNumericButtonsPanel() {
        return numericButtonsPanel;
    }

    public InputScreen getInputScreen() {
        return inputScreen;
    }

    public ResultScreen getResultScreen() {
        return resultScreen;
    }

    public JPanel getScreenPanel() {
        return screenPanel;
    }
}
