package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends  JPanel{

    private MainFrame mainFrame;

    private JButton addButton;

    private JButton addTeacherButton;

    private JButton listButton;

    private JButton exitButton;

    public MainMenu(MainFrame mainFrame){

        this.mainFrame = mainFrame;

        setSize(500,500);
        setLayout(null);

        addButton = new JButton("ADD");
        addButton.setSize(300,30);
        addButton.setLocation(100,100);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.getAddPage().setVisible(true);
                mainFrame.getMainMenuPage().setVisible(false);
            }
        });
        add(addButton);

        listButton = new JButton("LIST");
        listButton.setSize(300,30);
        listButton.setLocation(100,150);
        add(listButton);
        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.getListStudentPage().generateTable(mainFrame.getStudents());
                mainFrame.getListPage().setVisible(true);
                mainFrame.getMainMenuPage().setVisible(false);
            }
        });

        exitButton = new JButton("EXIT");
        exitButton.setSize(300,30);
        exitButton.setLocation(100,200);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(exitButton);

    }
}
