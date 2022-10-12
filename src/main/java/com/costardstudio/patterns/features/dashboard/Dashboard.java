package com.costardstudio.patterns.features.dashboard;

import com.costardstudio.patterns.features.observer.controller.SimpleCalculator;

import javax.swing.*;

public class Dashboard extends JFrame {

    public Dashboard() {
        setTitle("Patterns - Dashboard");
        System.out.println("Generating dashboard...");
        JPanel panel = new JPanel();
        setContentPane(panel);
        SimpleCalculator simpleCalculator = new SimpleCalculator();
        panel.add(simpleCalculator.getCalculatorView().getCalculatorPanel());
    }
}
