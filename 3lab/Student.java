public class Student {
    private String name;
    private String surname;
    private int age;
    private double gpa;

    public Student(String name, String surname, int age, double gpa) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return name + " " + surname + " (возраст: " + age + ", ср. балл: " + gpa + ")";
    }
}
