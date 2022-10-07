package com.costardstudio.patterns;

import com.costardstudio.patterns.features.dashboard.Dashboard;

public class Main {
    public static void main(String[] args) {
        Dashboard dialog = new Dashboard();
        dialog.pack();
        dialog.setVisible(true);
    }
}
