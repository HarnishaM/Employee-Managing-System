import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Employee {
    private int id;
    private String name;
    private String designation;
    private double salary;
    private String department;
    private LocalDate joiningDate;

    // Constructors
    public Employee(int id, String name, String designation, double salary, String department, LocalDate joiningDate) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
        this.department = department;
        this.joiningDate = joiningDate;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    // Method to calculate tenure
    public int getTenure() {
        return Period.between(joiningDate, LocalDate.now()).getYears();
    }

    // toString Method
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", designation='" + designation + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                ", joiningDate=" + joiningDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
