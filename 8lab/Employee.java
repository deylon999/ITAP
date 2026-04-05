public class Employee {
    private String employeeId;
    private String position;
    private double salary;
    private int experience;

    public Employee(String employeeId, String position, double salary, int experience) {
        this.employeeId = employeeId;
        this.position = position;
        this.salary = salary;
        this.experience = experience;
    }

    public String getEmployeeId() { return employeeId; }
    public String getPosition() { return position; }
    public double getSalary() { return salary; }
    public int getExperience() { return experience; }

    public void setPosition(String position) { this.position = position; }
    public void setSalary(double salary) { this.salary = salary; }

    @Override
    public String toString() {
        return employeeId + "," + position + "," + salary + "," + experience;
    }
}