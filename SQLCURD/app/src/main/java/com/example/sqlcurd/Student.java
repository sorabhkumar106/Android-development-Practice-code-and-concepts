package com.example.sqlcurd;

public class Student {
    int rollNo;
    String name;
    String courseName;
    int age;

    public Student( String name, String courseName, int age) {
        this.name = name;
        this.courseName = courseName;
        this.age = age;
    }

    public Student(int rollNo, String name, String courseName, int age) {
        this.rollNo = rollNo;
        this.name = name;
        this.courseName = courseName;
        this.age = age;
    }

    public Student() {
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                ", courseName='" + courseName + '\'' +
                ", age=" + age +
                '}';
    }
}
