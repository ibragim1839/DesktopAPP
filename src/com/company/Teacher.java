package com.company;
public class Teacher {
    String name;
    String surname;
    int age;
    String[] subjects;

    public Teacher(){

    }
    public Teacher(String name, String surname, int age, String[] subjects){
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.subjects = subjects;
    }


    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String[] getSubjects() {
        return subjects;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSubjects(String[] subjects) {
        this.subjects = subjects;
    }


}

