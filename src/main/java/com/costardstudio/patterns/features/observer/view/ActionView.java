package com.costardstudio.patterns.features.observer.view;

import javax.swing.*;

public class ActionView {
    private final JButton button;

    //Constructor
    public ActionView(String label){
        this.button = new JButton(label);
    }

    public JButton getButton(){
        return button;
    }
}
