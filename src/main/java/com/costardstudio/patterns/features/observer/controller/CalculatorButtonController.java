package com.costardstudio.patterns.features.observer.controller;

import com.costardstudio.patterns.features.observer.services.CalculatorService;
import com.costardstudio.patterns.features.observer.view.ActionView;

import java.awt.event.ActionListener;

public abstract class CalculatorButtonController implements ActionListener, OperationPerform {

    protected CalculatorService calculatorService;
    private final ActionView actionView;

    public CalculatorButtonController(CalculatorService calculatorService, String label) {
        this.calculatorService = calculatorService;
        this.actionView = new ActionView(label);
        this.actionView.getButton().addActionListener(this);
    }

    public ActionView getActionView() {
        return actionView;
    }
}
