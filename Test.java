package EmployeeCRUD;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

class Employee_Managemnet {
    //add Employee
    public static void addEmp(Map<Integer, Employee> map, Scanner sc) {
        System.out.println("Enter Employee ID: ");
        int id = 0;
            id = sc.nextInt();
            if (map.containsKey(id)) {
                System.out.println("This ID Already Exists.");
                return;
            }
        System.out.println("Enter Employee Name: ");
        String name = sc.next();
        System.out.println("Enter Employee Department: ");
        String department = sc.next();
        System.out.println("Enter Employee Salary: ");
        double salary = sc.nextDouble();

        map.put(id, new Employee(id, name, department, salary));
        System.out.println("Employee Added Successfully.");
        map.get(id).display_info();
    }

    //view all
    public static void displayEmp(Map<Integer, Employee> map) {
        if (map.isEmpty()) {
            System.out.println("No Records Yet...!");
        } else {
            for (Employee e : map.values()) {
                e.display_info();
            }
        }

    }

    //update Employee
    public static void updateEmp(Map<Integer, Employee> map, Scanner sc) {
        System.out.println("Enter Employee ID: ");
        
        int id = sc.nextInt();
            if (map.containsKey(id)) {
                Employee emp = map.get(id);
                System.out.print("Enter new Name: ");
                emp.setName(sc.next());
                System.out.print("Enter new Department: ");
                emp.setDepartment(sc.next());
                System.out.print("Enter new Salary: ");
                emp.setSalary(sc.nextDouble());

                System.out.println("Employee updated successfully.");
            } else {
                System.out.println("Employee ID not found.");
            }
    }

    //delete Employee
    public static void deleteEmp(Map<Integer, Employee> map, Scanner sc) {
        System.out.print("Enter Employee ID to delete: ");
        try {
            int id = sc.nextInt();
            if (map.containsKey(id)) {
                map.remove(id);
                System.out.println("Employee deleted successfully.");
            } else {
                System.out.println("Employee ID not found.");
            }
        } catch (Exception e) {
            System.out.println("Enter id in digits...!");
        }

    }
    }

public class Test {
    public static void main(String[] args)   {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Employee> employeeMap = new HashMap<>();

        int choice=0;
        do {
            System.out.println("\n=== Employee Management System ===");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            try {
                choice = sc.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Enter number between 1-5");
            }
            sc.nextLine(); // consume newline

            if (choice==5){
                System.out.println("Existing...");
            }
            switch (choice) {
                case 1:
                    Employee_Managemnet.addEmp(employeeMap, sc);
                    break;
                case 2:
                    Employee_Managemnet.displayEmp(employeeMap);
                    break;
                case 3:
                    Employee_Managemnet.updateEmp(employeeMap, sc);
                    break;
                case 4:
                    Employee_Managemnet.deleteEmp(employeeMap, sc);
                    break;

            }
        } while (choice != 5);

        sc.close();
    }
}

