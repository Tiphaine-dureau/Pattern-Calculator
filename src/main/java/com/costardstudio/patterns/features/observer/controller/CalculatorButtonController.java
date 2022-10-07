package com.costardstudio.patterns.features.observer.controller;

import com.costardstudio.patterns.features.observer.services.CalculatorService;

import javax.swing.*;
import java.awt.event.ActionListener;

public abstract class CalculatorButtonController implements ActionListener, OperationPerform {

    protected final JButton button;
    protected CalculatorService calculatorService;

    public CalculatorButtonController(CalculatorService calculatorService, String buttonLabel) {
        this.calculatorService = calculatorService;
        this.button = new JButton();
        this.button.setText(buttonLabel);
        this.button.addActionListener(this::actionPerformed);
    }

    public JButton getButton() {
        return button;
    }
}
