import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();
        Scanner scanner = new Scanner(System.in);

        // Sample interaction with the system
        try {
            while (true) {
                System.out.println("\nEmployee Management System Menu:");
                System.out.println("1. Add Employee");
                System.out.println("2. Calculate Total Salary Expenditure");
                System.out.println("3. Find Highest and Lowest Salary");
                System.out.println("4. Calculate Average Salary by Department");
                System.out.println("5. Calculate Employee Tenure");
                System.out.println("6. Exit");
                System.out.print("Choose an option: ");

                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter Employee ID: ");
                        int employeeId = scanner.nextInt();
                        scanner.nextLine();  // Consume newline
                        System.out.print("Enter Employee Name: ");
                        String employeeName = scanner.nextLine();
                        System.out.print("Enter Designation: ");
                        String designation = scanner.nextLine();
                        System.out.print("Enter Salary: ");
                        double salary = scanner.nextDouble();
                        scanner.nextLine();  // Consume newline
                        System.out.print("Enter Department: ");
                        String department = scanner.nextLine();
                        System.out.print("Enter Joining Date (YYYY-MM-DD): ");
                        String joiningDate = scanner.nextLine();
                        
                        try {
                            LocalDate joiningDateParsed = LocalDate.parse(joiningDate);
                            Employee employee = new Employee(employeeId, employeeName, designation, salary, department, joiningDateParsed);
                            manager.getEmployees().put(employeeId, employee);
                            System.out.println("Employee added successfully.");
                        } catch (DateTimeParseException e) {
                            System.out.println("Invalid date format. Please enter the date in YYYY-MM-DD format.");
                        }
                        break;

                    case 2:
                        manager.calculateTotalSalaryExpenditure();
                        break;

                    case 3:
                        manager.findHighestAndLowestSalary();
                        break;

                    case 4:
                        manager.calculateAverageSalaryByDepartment();
                        break;

                    case 5:
                        manager.calculateEmployeeTenure();
                        break;

                    case 6:
                        System.out.println("Exiting the system. Goodbye!");
                        return;

                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter correct data types.");
            scanner.nextLine();  // Clear the invalid input
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
