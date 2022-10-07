package com.costardstudio.patterns.features.observer.view;

import com.costardstudio.patterns.features.observer.controller.CalculatorButtonController;

import java.util.List;
import java.util.Objects;

public class ResultScreen extends CalculatorScreen {
    public ResultScreen() {
        super("");
    }

    @Override
    public void update(List<String> inputs, String buffer, CalculatorButtonController operation) {
        if (!Objects.equals(buffer, "")) {
            label.setText(buffer);
        } else {
            label.setText(inputs.get(0));
        }

    }
}
