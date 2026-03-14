package org.example;

public class Student {
    private String name;
    private String surname;
    private int age;
    private double gpa;

    public Student() {}

    public Student(String name, String surname, int age, double gpa) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gpa = gpa;
    }

    public String getName() { return name; }
    public String getSurname() { return surname; }
    public int getAge() { return age; }
    public double getGpa() { return gpa; }

    @Override
    public String toString() {
        return name + " " + surname + " (возраст: " + age + ", ср. балл: " + gpa + ")";
    }
}