package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class AddStudent extends JPanel {
    private MainFrame mainFrame;

    private JLabel labelName;
    private JTextField textFieldName;

    private JLabel labelSurname;
    private JTextField textFieldSurname;

    private JLabel labelGroup;
    private JTextField textFieldGroup;

    private JLabel labelFaculty;
    private JComboBox boxFaculties;
    private String[] facultiesChoosingList = {"tap here to choose", "Math", "Chemistry", " Information Technologies", "Engineering"};

    private JButton back_button;

    private JButton add_button;

    int sizeOfStudents = 0;
    public Student[] studentsList;


    public AddStudent(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setSize(500, 500);
        setLayout(null);

        labelName = new JLabel("NAME: ");
        labelName.setLocation(90, 100);
        labelName.setSize(100, 25);
        add(labelName);

        labelSurname = new JLabel("SURNAME: ");
        labelSurname.setLocation(90, 150);
        labelSurname.setSize(100, 25);
        add(labelSurname);

        labelFaculty = new JLabel("FACULTY: ");
        labelFaculty.setLocation(90, 200);
        labelFaculty.setSize(100, 25);
        add(labelFaculty);

        labelGroup = new JLabel("GROUP: ");
        labelGroup.setLocation(90, 250);
        labelGroup.setSize(100, 25);
        add(labelGroup);

        JLabel labelSos = new JLabel("! FILL ALL THE FIELDS !",JLabel.CENTER);
        labelSos.setForeground(Color.red);
        labelSos.setLocation(100,50);
        labelSos.setSize(300,40);
        labelSos.setVisible(false);
        add(labelSos);

        textFieldName = new JTextField();
        textFieldName.setLocation(200, 100);
        textFieldName.setSize(200, 25);
        add(textFieldName);

        textFieldSurname = new JTextField();
        textFieldSurname.setLocation(200, 150);
        textFieldSurname.setSize(200, 25);
        add(textFieldSurname);

        boxFaculties = new JComboBox(facultiesChoosingList);
        boxFaculties.setLocation(200, 200);
        boxFaculties.setSize(200, 25);
        add(boxFaculties);

        textFieldGroup = new JTextField();
        textFieldGroup.setLocation(200, 250);
        textFieldGroup.setSize(200, 25);
        add(textFieldGroup);

        back_button = new JButton("BACK");
        back_button.setSize(150, 35);
        back_button.setLocation(90, 295);
        back_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.getAddStudent_page().setVisible(false);
                mainFrame.getAddPage().setVisible(true);
                textFieldName.setText("");
                textFieldSurname.setText("");
                textFieldGroup.setText("");
                boxFaculties.setSelectedIndex(0);

            }
        });
        add(back_button);

        studentsList = new Student[sizeOfStudents];

        add_button = new JButton("ADD");
        add_button.setSize(150, 35);
        add_button.setLocation(250, 295);
        add_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int facultyInfo = boxFaculties.getSelectedIndex();
                if (!textFieldName.getText().equals("") && !textFieldSurname.getText().equals("") && !textFieldGroup.getText().equals("") && facultyInfo != 0) {

                    sizeOfStudents++;

                    Student[] newStudentsList = new Student[sizeOfStudents];

                    System.arraycopy(studentsList, 0, newStudentsList, 0, studentsList.length);

                    newStudentsList[sizeOfStudents-1] = new Student(textFieldName.getText(), textFieldSurname.getText(), (String) boxFaculties.getSelectedItem(), textFieldGroup.getText());

                    studentsList = new Student[sizeOfStudents];

                    System.arraycopy(newStudentsList, 0, studentsList, 0, newStudentsList.length);

                    textFieldName.setText("");
                    textFieldSurname.setText("");
                    textFieldGroup.setText("");
                    boxFaculties.setSelectedIndex(0);

                    labelSos.setVisible(false);

                    mainFrame.getMainMenuPage().setVisible(true);
                    mainFrame.getAddStudent_page().setVisible(false);
                }
                else{
                    labelSos.setVisible(true);

                }
            }
        });
        add(add_button);
    }
}
