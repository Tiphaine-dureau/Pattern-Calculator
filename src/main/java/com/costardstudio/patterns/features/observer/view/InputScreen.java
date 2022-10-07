package com.costardstudio.patterns.features.observer.view;

import com.costardstudio.patterns.features.observer.controller.CalculatorButtonController;

import java.util.List;

public class InputScreen extends CalculatorScreen {
    public InputScreen() {
        super("");
    }

    @Override
    public void update(List<String> inputs, String buffer, CalculatorButtonController operation) {
        if (operation != null) {
            label.setText(inputs.get(0) + operation.getActionView().getButton().getText());
        } else {
            label.setText("");
        }
    }
}
