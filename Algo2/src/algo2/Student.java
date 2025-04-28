/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algo2;

/**
 *
 * @author asus
 */
public class Student {
    private int studentID;
    private String name;
    private String surname;
    private static int counter = 0; // Ortalama hesaplamalarında kullanılmak üzere statik sınıf sayacı

    public Student(int studentID, String name, String surname) {
        this.studentID = studentID;
        this.name = name;
        this.surname = surname;
        this.counter++;
    }
    public Student() {
        this.studentID = 0;
        this.name = null;
        this.surname = null;
        this.counter++;
    }
    public Student(Student student){
        this.studentID = student.studentID;
        this.name = student.name;
        this.surname = student.surname;
        this.counter++;
    }
    @Override
    public String toString(){
        return "StudentID: " + studentID + " Name: " + name + " Surname: " + surname;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Student.counter = counter;
    }
}

