package com.northgeorgiadynamics.file_manager;

public class MainWindow extends javax.swing.JFrame {

    public MainWindow() {
        initComponents();
    }

    private void initComponents() {
        setTitle("File Manager");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));
        setLayout(new java.awt.BorderLayout());
        add(new MainPanel(), java.awt.BorderLayout.CENTER);
        pack();
    }
}
