package com.costardstudio.patterns.features.observer.controller;

import com.costardstudio.patterns.features.observer.services.CalculatorService;
import com.costardstudio.patterns.features.observer.view.CalculatorView;

import java.util.ArrayList;
import java.util.List;

public class SimpleCalculator {
    CalculatorService calculatorService = new CalculatorService();
    private final CalculatorView calculatorView;

    // CONSTRUCTOR
    public SimpleCalculator() {
        calculatorView = new CalculatorView();
        configureInterfaceCalculatorPanel();
        addScreenObservers();
    }

    private void addScreenObservers() {
        calculatorService.addObserver(this.calculatorView.getInputScreen());
        calculatorService.addObserver(this.calculatorView.getResultScreen());
    }

    private List<NumericButtonController> configureNumericButtonsPanel() {
        List<NumericButtonController> numericButtonControllers = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            NumericButtonController buttonController = new NumericButtonController(this.calculatorService, String.valueOf(i));
            numericButtonControllers.add(buttonController);
        }
        return numericButtonControllers;
    }

    private void configureInterfaceCalculatorPanel() {
        List<NumericButtonController> numericButtonControllers = this.configureNumericButtonsPanel();
        AdditionButtonController plusButtonController = new AdditionButtonController(this.calculatorService);
        SubtractButtonController minusButtonController= new SubtractButtonController(this.calculatorService);
        MultiplicationButtonController multiplicationButtonController = new MultiplicationButtonController(this.calculatorService);
        DivisionButtonController divisionButtonController = new DivisionButtonController(this.calculatorService);
        ResultButtonController equalButtonController = new ResultButtonController(this.calculatorService);
        this.calculatorView.configureInterfaceCalculatorPanel(numericButtonControllers, plusButtonController, minusButtonController, multiplicationButtonController, divisionButtonController, equalButtonController);
    }

    // GETTERS / SETTERS
    public CalculatorView getCalculatorView() {
        return calculatorView;
    }
}
