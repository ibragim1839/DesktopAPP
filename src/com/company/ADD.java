package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ADD extends JPanel{

    private MainFrame mainFrame;

    private JButton addStudent;
    private JButton addTeacher;
    private JButton backButton;

    public ADD(MainFrame mainFrame){
        this.mainFrame = mainFrame;

        setSize(500, 500);
        setLayout(null);

        addStudent = new JButton("ADD STUDENT");
        addStudent.setLocation(100, 120);
        addStudent.setSize(300, 35);
        addStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.getAddStudent_page().setVisible(true);
                mainFrame.getAddPage().setVisible(false);
            }
        });
        add(addStudent);

        addTeacher = new JButton("ADD TEACHER");
        addTeacher.setLocation(100, 190);
        addTeacher.setSize(300, 35);
        addTeacher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.getaddTeacherPage().setVisible(true);
                mainFrame.getAddPage().setVisible(false);
            }
        });
        add(addTeacher );

        backButton = new JButton("BACK");
        backButton.setLocation(100, 260);
        backButton .setSize(300, 35);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.getMainMenuPage().setVisible(true);
                mainFrame.getAddPage().setVisible(false);
            }
        });
        add(backButton );
    }
}
