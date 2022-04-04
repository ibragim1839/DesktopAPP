package com.company;
import javax.swing.*;
public class MainFrame extends JFrame {

    private MainMenu mainMenuPage;
    private AddStudent addStudentPage;
    private ListStudents listStudentsPage;
    private AddTeacher addTeacherPage;
    private ListTeachers listTeachers;
    private ADD addPage;
    private LIST listPage;

    public MainFrame(){

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("BITLAB APP");
        setSize(500,500);
        setLayout(null);

        addPage = new ADD(this);
        addPage.setVisible(false);
        add(addPage);

        addTeacherPage = new AddTeacher(this);
        addTeacherPage.setVisible(false);
        add(addTeacherPage);


        mainMenuPage = new MainMenu(this);
        mainMenuPage.setVisible(true);
        add(mainMenuPage);

        addStudentPage = new AddStudent(this);
        addStudentPage.setVisible(false);
        add(addStudentPage);

        listStudentsPage = new ListStudents(this);
        listStudentsPage.setVisible(false);
        add(listStudentsPage);

        listTeachers = new ListTeachers(this);
        listTeachers.setVisible(false);
        add(listTeachers);

        listPage = new LIST(this);
        listPage.setVisible(false);
        add(listPage);
    }

    public ADD getAddPage() {
        return addPage;
    }

    public MainMenu getMainMenuPage() {
        return mainMenuPage;
    }

    public AddTeacher getaddTeacherPage(){
        return addTeacherPage;
    }

    public AddStudent getAddStudent_page() {
        return addStudentPage;
    }

    public ListStudents getListStudentPage(){
        return listStudentsPage;
    }

    public Student[] getStudents() {
        return addStudentPage.studentsList;
    }

    public Teacher[] getTeachers(){
        return addTeacherPage.teachersArray;
    }

    public ListTeachers getListTeachers(){
        return listTeachers;
    }
    public LIST getListPage(){
        return listPage;
    }

    public void setStudents(Student[] students) {
        addStudentPage.studentsList = students;
    }
}

