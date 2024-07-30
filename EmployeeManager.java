import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Employee {
    private int employeeId;
    private String name;
    private String position;
    private double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    // Getter for employeeId
    public int getEmployeeId() {
        return employeeId;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for position
    public String getPosition() {
        return position;
    }

    // Getter for salary
    public double getSalary() {
        return salary;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee ID: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: " + salary;
    }
}
public class EmployeeManager {
    private List<Employee> employeeList;

    public EmployeeManager() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public Employee searchEmployee(int employeeId) {
        for (Employee employee : employeeList) {
            if (employee.getEmployeeId() == employeeId) {
                return employee;
            }
        }
        return null;
    }
    public void traverseEmployees() {
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    public boolean deleteEmployee(int employeeId) {
        Iterator<Employee> iterator = employeeList.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.getEmployeeId() == employeeId) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();

        manager.addEmployee(new Employee(1, "John Doe", "Manager", 75000));
        manager.addEmployee(new Employee(2, "Jane Smith", "Developer", 60000));
        manager.addEmployee(new Employee(3, "Emily Davis", "Designer", 55000));

        System.out.println("All Employees:");
        manager.traverseEmployees();

        System.out.println("\nSearching for Employee with ID 2:");
        Employee emp = manager.searchEmployee(2);
        if (emp != null) {
            System.out.println("Found: " + emp);
        } else {
            System.out.println("Employee not found.");
        }
        System.out.println("\nDeleting Employee with ID 3:");
        boolean isDeleted = manager.deleteEmployee(3);
        if (isDeleted) {
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee not found.");
        }
        System.out.println("\nAll Employees after deletion:");
        manager.traverseEmployees();
    }
}
