package com.costardstudio.patterns.features.observer.controller;

import java.util.List;

public interface ActionButton {
    void update(List<String> inputs, String buffer, CalculatorButtonController operation);
}
