
import java.util.*;

public class EmployeeManager {
    private HashMap<Integer, Employee> employees = new HashMap<>();

    public HashMap<Integer, Employee> getEmployees(){
        return employees;
    }
    public void setEmployees(HashMap<Integer, Employee> employees){
         this.employees=employees;
    } 

    // Calculate Total Salary Expenditure
    public void calculateTotalSalaryExpenditure() {
        double totalExpenditure = employees.values().stream()
                .mapToDouble(Employee::getSalary)
                .sum();
        System.out.println("Total Salary Expenditure: " + totalExpenditure);
    }

    // Find Employees with Highest and Lowest Salary
    public void findHighestAndLowestSalary() {
        if (employees.isEmpty()) {
            System.out.println("No employees available.");
            return;
        }

        Employee highestSalaryEmployee = Collections.max(employees.values(), Comparator.comparingDouble(Employee::getSalary));
        Employee lowestSalaryEmployee = Collections.min(employees.values(), Comparator.comparingDouble(Employee::getSalary));

        System.out.println("Employee with Highest Salary: " + highestSalaryEmployee);
        System.out.println("Employee with Lowest Salary: " + lowestSalaryEmployee);
    }

    // Calculate Average Salary by Department
    public void calculateAverageSalaryByDepartment() {
        Map<String, List<Employee>> employeesByDepartment = new HashMap<>();
        for (Employee employee : employees.values()) {
            employeesByDepartment
                    .computeIfAbsent(employee.getDepartment(), k -> new ArrayList<>())
                    .add(employee);
        }

        for (Map.Entry<String, List<Employee>> entry : employeesByDepartment.entrySet()) {
            String department = entry.getKey();
            List<Employee> departmentEmployees = entry.getValue();
            double averageSalary = departmentEmployees.stream()
                    .mapToDouble(Employee::getSalary)
                    .average()
                    .orElse(0);
            System.out.println("Average Salary for Department " + department + ": " + averageSalary);
        }
    }

    // Calculate Employee Tenure
    public void calculateEmployeeTenure() {
        for (Employee employee : employees.values()) {
            int tenure = employee.getTenure();
            System.out.println(employee.getName() + " has a tenure of " + tenure + " years.");
            if (tenure >= 10) {
                System.out.println(employee.getName() + " is eligible for a long service award.");
            }
        }
    }

   
    
    
}
