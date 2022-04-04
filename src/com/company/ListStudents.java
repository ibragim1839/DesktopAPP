package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListStudents extends JPanel {
    private MainFrame mainFrame;
    private JButton backButton;
    private JLabel headLabel;
    private String[] tableHead = {"NAME", "SURNAME", "FACULTY", "GROUP"};
    private JTable studentsTable;
    private JScrollPane scrollPane;

    public ListStudents(MainFrame mainFrame) {

        this.mainFrame = mainFrame;

        setSize(500, 500);
        setLayout(null);

        headLabel = new JLabel("LIST OF THE STUDENTS", JLabel.CENTER);
        headLabel.setSize(300, 30);
        headLabel.setLocation(100, 100);
        add(headLabel);

        studentsTable = new JTable();
        studentsTable.setFont(new Font("Calibri", Font.PLAIN, 12));
        studentsTable.setLocation(100,150);
        studentsTable.setSize(300,200);

        scrollPane = new JScrollPane(studentsTable);
        scrollPane.setSize(300, 200);
        scrollPane.setLocation(100, 200);
        add(scrollPane);

        backButton = new JButton("BACK");
        backButton.setSize(300,30);
        backButton.setLocation(100,150);
        add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mainFrame.getListStudentPage().setVisible(false);
                mainFrame.getListPage().setVisible(true);
            }
        });
    }

    public void generateTable(Student[] students) {
            Object data[][] = new Object[students.length][4];

        for(int i =0;i<students.length;i++) {
            data[i][0] = students[i].getName();
            data[i][1] = students[i].getSurname();
            data[i][2] = students[i].getFaculty();
            data[i][3] = students[i].getGroup();
        }
        DefaultTableModel model = new DefaultTableModel(data, tableHead);
        studentsTable.setModel(model);
    }
}

