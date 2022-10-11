package com.costardstudio.patterns.features.observer.view;

import com.costardstudio.patterns.features.observer.controller.AdditionButtonController;
import com.costardstudio.patterns.features.observer.controller.NumericButtonController;
import com.costardstudio.patterns.features.observer.controller.ResultButtonController;

import javax.swing.*;
import java.awt.*;


public class CalculatorView {
    private final JPanel numericButtonsPanel;
    private final JPanel operatorButtonsPanel;

    public CalculatorView() {
        numericButtonsPanel = new JPanel();
        numericButtonsPanel.setLayout(new GridLayout(4, 3));
        operatorButtonsPanel = new JPanel();
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
}
