package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LIST extends JPanel {

    private MainFrame mainframe;

    private JButton listStudentsButton;
    private JButton listTeachersButton;
    private JButton backButton;

    public LIST(MainFrame mainFrame){

        setSize(500,500);
        setLayout(null);

        this.mainframe = mainFrame;

        listStudentsButton = new JButton("LIST STUDENTS");
        listStudentsButton.setSize(300, 35);
        listStudentsButton.setLocation(100,120);
        add(listStudentsButton);
        listStudentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.getListStudentPage().generateTable(mainFrame.getStudents());
                mainFrame.getListStudentPage().setVisible(true);
                mainFrame.getListPage().setVisible(false);
            }
        });
        add(listStudentsButton);

        listTeachersButton = new JButton("LIST TEACHERS");
        listTeachersButton.setLocation(100, 190);
        listTeachersButton.setSize(300, 35);
        listTeachersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.getListTeachers().generateTable(mainFrame.getaddTeacherPage().teachersArray);
                mainFrame.getListTeachers().setVisible(true);
                mainFrame.getListPage().setVisible(false);
            }
        });
        add(listTeachersButton);

        backButton = new JButton("BACK");
        backButton.setLocation(100, 260);
        backButton .setSize(300, 35);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.getMainMenuPage().setVisible(true);
                mainFrame.getListPage().setVisible(false);
            }
        });
        add(backButton );
    }
}
