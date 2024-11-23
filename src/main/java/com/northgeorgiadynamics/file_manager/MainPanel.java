package com.northgeorgiadynamics.file_manager;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.SpringLayout;
import java.awt.Button;

public class MainPanel extends javax.swing.JPanel {

    //constructor
    public MainPanel() {
        initComponents();
    }

    //split pane
    private JSplitPane splitPane;

    //initialize components
    private void initComponents() {
        //setup spring layout
        SpringLayout layout = new SpringLayout();
        setLayout(layout);

        //add menu bar
        JMenuBar menuBar = new JMenuBar();

        //add menu bar to panel
        add(menuBar);

        //glue menu bar to top, left and right of MainPanel
        SpringLayout.Constraints menuBarCons = new SpringLayout.Constraints(menuBar);

        //add file menu
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        //add to file menu preferences menu item
        fileMenu.add("Preferences");

        //add to file menu exit menu item
        fileMenu.add("Exit");

        //add help menu
        JMenu helpMenu = new JMenu("Help");
        menuBar.add(helpMenu);

        //add to help menu about menu item
        helpMenu.add("About");

        //add constraints to layout
        layout.putConstraint(SpringLayout.NORTH, menuBar, 0, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.WEST, menuBar, 0, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, menuBar, 0, SpringLayout.EAST, this);

        //add toolbar
        JToolBar toolBar = new JToolBar();
        add(toolBar);

        //glue toolbar below menu bar, and left
        SpringLayout.Constraints toolBarCons = new SpringLayout.Constraints(toolBar);
        layout.putConstraint(SpringLayout.NORTH, toolBar, 0, SpringLayout.SOUTH, menuBar);
        layout.putConstraint(SpringLayout.WEST, toolBar, 0, SpringLayout.WEST, this);

        //add toolbar buttons
        Button listButton = new Button("List");
        toolBar.add(listButton);

        Button detailsButton = new Button("Details");
        toolBar.add(detailsButton);

        //add toolbar for bottom
        JToolBar bottomToolBar = new JToolBar();
        add(bottomToolBar);

        //glue bottom toolbar to bottom of MainPanel
        SpringLayout.Constraints bottomToolBarCons = new SpringLayout.Constraints(bottomToolBar);
        layout.putConstraint(SpringLayout.SOUTH, bottomToolBar, 0, SpringLayout.SOUTH, this);
        layout.putConstraint(SpringLayout.WEST, bottomToolBar, 0, SpringLayout.WEST, this);

        //add bottom toolbar buttons
        Button copyButton = new Button("Copy");
        bottomToolBar.add(copyButton);
        Button moveButton = new Button("Move");
        bottomToolBar.add(moveButton);
        Button deleteButton = new Button("Delete");
        bottomToolBar.add(deleteButton);

        //add split pane between upper and bottom toolbars
        splitPane = new javax.swing.JSplitPane();
        add(splitPane);
        SpringLayout.Constraints splitPaneCons = new SpringLayout.Constraints(splitPane);
        layout.putConstraint(SpringLayout.NORTH, splitPane, 0, SpringLayout.SOUTH, toolBar);
        layout.putConstraint(SpringLayout.SOUTH, splitPane, 0, SpringLayout.NORTH, bottomToolBar);
        layout.putConstraint(SpringLayout.WEST, splitPane, 0, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, splitPane, 0, SpringLayout.EAST, this);

        //add left panel to split pane
        javax.swing.JPanel leftPanel = new javax.swing.JPanel();

        //set green background color
        leftPanel.setBackground(java.awt.Color.GREEN);

        //add left panel to split pane
        splitPane.setLeftComponent(leftPanel);


        //add right panel to split pane
        javax.swing.JPanel rightPanel = new javax.swing.JPanel();

        //set blue background color
        rightPanel.setBackground(java.awt.Color.BLUE);

        //add right panel to split pane
        splitPane.setRightComponent(rightPanel);

        //add MainPanel resize event
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

    }

    //MainPanel resize event
    private void formComponentResized(java.awt.event.ComponentEvent evt) {
        splitPane.setDividerLocation(0.5);
    }



}
