package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddTeacher extends JPanel {

    MainFrame mainFrame;

    JLabel name;
    JLabel surname;
    JLabel age;
    JLabel subjects;
    JButton math;
    JButton chemistry;
    JButton art;
    JButton add;
    JButton back;
    JTextField nametf;
    JTextField surnametf;
    JComboBox agescb;
    Integer[] ages = new Integer[50];
    int sizeOfSubjects = 0;
    String[] subjectsArray = new String[3];
    int sizeOfTeachers = 0;
    Teacher[] teachersArray = new Teacher[sizeOfTeachers];
    Teacher[] newTeachersArray = new Teacher[sizeOfTeachers];
    int count = 0;
    JButton magicb;


    public AddTeacher(MainFrame mainFrame){

        this.mainFrame = mainFrame;

        for (int i = 0; i < ages.length; i++){
            ages[i] = i+21;
        }

        setSize(500,500);
        setLayout(null);

        agescb = new JComboBox(ages);
        agescb.setLocation(200,180);
        agescb.setSize(200,25);
        add(agescb);

        name = new JLabel("NAME: ");
        name.setLocation(90, 80);
        name.setSize(100, 25);
        add(name);

        surname = new JLabel("SURNAME: ");
        surname.setLocation(90, 130);
        surname.setSize(100, 25);
        add(surname);

        age = new JLabel("AGE: ");
        age.setLocation(90, 180);
        age.setSize(100, 25);
        add(age);

        subjects = new JLabel("PLEASE CHOOSE SUBJECTS: ", JLabel.CENTER);
        subjects.setLocation(100, 250);
        subjects.setSize(300, 25);
        add(subjects);

        JLabel labelSos = new JLabel("! FILL ALL THE FIELDS !",JLabel.CENTER);
        labelSos.setForeground(Color.red);
        labelSos.setLocation(100,35);
        labelSos.setSize(300,40);
        labelSos.setVisible(false);
        add(labelSos);

        JLabel magic = new JLabel("! I LOVE YOU ALL !",JLabel.CENTER);
        magic.setForeground(Color.red);
        magic.setLocation(100,35);
        magic.setSize(300,40);
        magic.setVisible(false);
        add(magic);

        magicb = new JButton("+");
        magicb.setLocation(440,450);
        magicb.setSize(20,20);
        magicb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                if (nametf.getText().equals("Mayson") && surnametf.getText().equals("Lalbekova") && count == 3){
                    labelSos.setVisible(false);
                    magic.setVisible(true);
                }
            }
        });
        add(magicb);

        nametf = new JTextField();
        nametf.setLocation(200, 80);
        nametf.setSize(200, 25);
        add(nametf);

        surnametf = new JTextField();
        surnametf.setLocation(200, 130);
        surnametf.setSize(200, 25);
        add(surnametf);

        math = new JButton("MATH");
        math.setLocation(80,280);
        math.setSize(100,35);
        math.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                math.setVisible(false);
                subjectsArray[sizeOfSubjects] = "MATH";
                sizeOfSubjects++;
            }
        });
        add(math);
        chemistry = new JButton("CHEMISTRY");
        chemistry.setLocation(200,280);
        chemistry.setSize(100,35);
        chemistry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chemistry.setVisible(false);
                subjectsArray[sizeOfSubjects] = "CHEMISTRY";
                sizeOfSubjects++;
            }
        });
        add(chemistry);
        art = new JButton("ART");
        art.setSize(100,35);
        art.setLocation(320,280);
        art.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                art.setVisible(false);
                subjectsArray[sizeOfSubjects] = "ART";
                sizeOfSubjects++;
            }
        });
        add(art);

        back = new JButton("BACK");
        back.setLocation(80, 335);
        back.setSize(160, 35);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.getaddTeacherPage().setVisible(false);
                mainFrame.getAddPage().setVisible(true);
                nametf.setText("");
                surnametf.setText("");
                agescb.setSelectedIndex(0);
                math.setVisible(true);
                chemistry.setVisible(true);
                art.setVisible(true);
                sizeOfSubjects=0;
                labelSos.setVisible(false);

            }
        });
        add(back);


        add = new JButton("ADD");
        add.setLocation(260,335);
        add.setSize(160,35);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(sizeOfSubjects > 0 && !nametf.getText().equals("") && !surnametf.getText().equals("")) {
                    sizeOfTeachers++;
                    newTeachersArray = new Teacher[sizeOfTeachers];

                    System.arraycopy(teachersArray, 0, newTeachersArray, 0, teachersArray.length);

                    String[] newSubjectsArray = new String[sizeOfSubjects];
                    for (int i = 0; i < sizeOfSubjects; i++) {
                        newSubjectsArray[i] = subjectsArray[i];
                    }

                    newTeachersArray[sizeOfTeachers - 1] = new Teacher(nametf.getText(), surnametf.getText(), (int) agescb.getSelectedItem(), newSubjectsArray);

                    teachersArray = new Teacher[sizeOfTeachers];

                    System.arraycopy(newTeachersArray, 0, teachersArray, 0, newTeachersArray.length);
                    mainFrame.getaddTeacherPage().setVisible(false);
                    mainFrame.getAddPage().setVisible(true);
                    nametf.setText("");
                    surnametf.setText("");
                    agescb.setSelectedIndex(0);
                    math.setVisible(true);
                    chemistry.setVisible(true);
                    art.setVisible(true);
                    sizeOfSubjects = 0;
                    labelSos.setVisible(false);
                }
                else{
                    labelSos.setVisible(true);
                    magic.setVisible(false);
                }
            }
        });
        add(add);
    }
}

