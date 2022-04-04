package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListTeachers extends JPanel{

    private MainFrame mainFrame;
    private JButton backButton;
    private JLabel headLabel;
    private String[] tableHead = {"NAME", "SURNAME", "AGE", "SUBJECTS"};
    private JTable teachersTable;
    private JScrollPane scrollPane;

    ListTeachers(MainFrame mainFrame){
        this.mainFrame = mainFrame;

        setLayout(null);
        setSize(500,500);

        headLabel = new JLabel("LIST OF THE TEACHERS", JLabel.CENTER);
        headLabel.setSize(300, 30);
        headLabel.setLocation(100, 115);
        add(headLabel);

        teachersTable = new JTable();
        teachersTable.setFont(new Font("Calibri", Font.PLAIN, 12));
        teachersTable.setLocation(80,110);
        teachersTable.setSize(340,200);
        add(teachersTable);

        scrollPane = new JScrollPane(teachersTable);
        scrollPane.setSize(340, 200);
        scrollPane.setLocation(80, 150);
        add(scrollPane);


        backButton = new JButton("BACK");
        backButton.setSize(360,30);
        backButton.setLocation(70,370);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mainFrame.getListTeachers().setVisible(false);
                mainFrame.getListPage().setVisible(true);
            }
        });
        add(backButton);
    }
    public void generateTable(Teacher[] teachers){
        Object[][] data = new Object[teachers.length][4];
        for (int i = 0; i < teachers.length; i++){
            data[i][0] = teachers[i].getName();
            data[i][1] = teachers[i].getSurname();
            data[i][2] = teachers[i].getAge();
            String subjects = "";
            String temp = "";
            for(int j = 0; j < teachers[i].getSubjects().length; j++){
                temp = subjects;
                subjects = teachers[i].getSubjects()[j] + temp;
            }
            data[i][3] = subjects;
        }
        DefaultTableModel model = new DefaultTableModel(data, tableHead);
        teachersTable.setModel(model);
    }
}
