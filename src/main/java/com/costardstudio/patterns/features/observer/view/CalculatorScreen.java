package com.costardstudio.patterns.features.observer.view;

import com.costardstudio.patterns.features.observer.controller.ActionButton;

import javax.swing.*;

public abstract class CalculatorScreen implements ActionButton {
    protected final JLabel label;

    public CalculatorScreen(String label) {
        this.label = new JLabel();
        this.label.setText(label);
    }

    public JLabel getLabel() {
        return label;
    }
}
