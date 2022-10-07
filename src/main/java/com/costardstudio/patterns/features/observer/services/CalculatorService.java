package com.costardstudio.patterns.features.observer.services;

import com.costardstudio.patterns.features.observer.controller.CalculatorButtonController;
import com.costardstudio.patterns.features.observer.view.CalculatorScreen;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CalculatorService {

    private final List<String> inputs = new ArrayList<>();
    private String buffer = "";

    private final List<CalculatorScreen> screens = new ArrayList<>();

    private CalculatorButtonController operation;

    public CalculatorService() {
    }

    public void addObserver(CalculatorScreen screen) {
        this.screens.add(screen);
    }

    public void addInput(String input) {
        this.buffer = this.buffer + input;
        if (this.operation == null) {
            this.inputs.clear();
        }
        this.setResultScreen();
    }

    public void setOperation(CalculatorButtonController operation) {
        if (!Objects.equals(this.buffer, "") && this.inputs.size() == 0) {
            this.inputs.add(this.buffer);
            this.buffer = "";
            this.operation = operation;
        } else if (this.operation != null) {
            this.inputs.add(this.buffer);
            this.buffer = "";
            String currentOperationResult = String.valueOf(this.operation.computeOperation(this.inputs));
            this.inputs.clear();
            this.inputs.add(currentOperationResult);
            this.operation = operation;
        } else {
            this.operation = operation;
        }
        this.setResultScreen();
    }

    public void compute() {
        this.inputs.add(this.buffer);
        this.buffer = "";
        String currentOperationResult = String.valueOf(this.operation.computeOperation(this.inputs));
        this.inputs.clear();
        this.inputs.add(currentOperationResult);
        this.operation = null;
        this.setResultScreen();
    }

    private void setResultScreen() {
        for (CalculatorScreen screen : this.screens) {
            screen.update(this.inputs, this.buffer, this.operation);
        }
    }
}
