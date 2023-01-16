package application;

import entities.Employee;

import java.util.Locale;
import java.util.Scanner;

public class ProgramEmployee {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("en", "US"));
        Scanner sc = new Scanner(System.in);
        double percentage;
        Employee emp = new Employee();

        System.out.print("Name: ");
        emp.name = sc.nextLine();
        System.out.print("Gross salary: ");
        emp.grossSalary = sc.nextDouble();
        System.out.print("Tax: ");
        emp.tax = sc.nextDouble();

        System.out.printf("Employee: %s%n", emp);

        System.out.print("Which percentage to increase salary? ");
        // Armazena a porcentagem que o salário irá aumentar
        percentage = sc.nextDouble();
        // Chamamos o método increaseSalary passando percentage como argumento
        emp.increaseSalary(percentage);

        System.out.printf("Update data: %s%n", emp);

    }
}
