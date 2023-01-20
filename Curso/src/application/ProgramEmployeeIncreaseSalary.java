package application;

import entities.Employee2;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ProgramEmployeeIncreaseSalary {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee2> employee = new ArrayList<>();
        int totalOfEmployees;
        int employeeId;
        int employeeIdIncreaseSalary;
        String employeeName;
        double employeeSalary;
        double percentage;

        System.out.print("How many employees will be registered? ");
        totalOfEmployees = sc.nextInt();

        for (int i = 0; i < totalOfEmployees; i++) {
            sc.nextLine();
            System.out.printf("Employee #%d: %n", i + 1);
            System.out.print("Id: ");
            employeeId = sc.nextInt();
            while (hasId(employee, employeeId)) {
                System.out.print("Id already taken. Try again: ");
                employeeId = sc.nextInt();
            }

            System.out.print("Name: ");
            sc.nextLine();
            employeeName = sc.nextLine();
            System.out.print("Salary: ");
            employeeSalary = sc.nextDouble();
            // Criamos uma instância da classe Employee2 inicializando o construtor.
            employee.add(new Employee2(employeeId, employeeName, employeeSalary));
        }

        System.out.printf("%nEnter the employee id that will have salary increase: ");
        employeeIdIncreaseSalary = sc.nextInt();
        Employee2 emp = employee.stream().filter(id -> id.getId() == employeeIdIncreaseSalary).findFirst().orElse(null);

        if (emp == null) {
            System.out.println("This id does not exist!");
        } else {
            System.out.print("Enter the percentage: ");
            percentage = sc.nextDouble();
            emp.increaseSalary(percentage);
        }

        System.out.printf("%nList of employees:%n");
        for (Employee2 obj : employee) {
            System.out.println(obj);
        }

    }

    public static boolean hasId(List<Employee2> employee, int employeeId) {
        Employee2 emp = employee.stream().filter(empId -> empId.getId() == employeeId).findFirst().orElse(null);
        return emp != null;
    }
}
