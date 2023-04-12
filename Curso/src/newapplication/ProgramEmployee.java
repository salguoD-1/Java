package newapplication;

import newentities.Employee;
import newentities.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ProgramEmployee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        List<Employee> listEmp = new ArrayList<>();

        System.out.print("Enter the number of employees: ");
        int numEmp = sc.nextInt();;


        for (int i = 1; i <= numEmp; i++) {
            System.out.println("Employee #" + i + " data");
            System.out.print("Outsorced (y/n)? ");
            // Pega apenas o primeiro caractere
            char ch = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Hours: ");
            int hours = sc.nextInt();
            System.out.print("Value per hour: ");
            double vph = sc.nextDouble();

            if (ch == 'y') {
                System.out.print("Additional charge: ");
                double ac = sc.nextDouble();
                // Instância de um funcionário terceirizado
                Employee emp = new OutsourcedEmployee(name, hours, vph, ac);
                listEmp.add(emp);
            } else {
                Employee emp = new Employee(name, hours, vph);
                listEmp.add(emp);
            }

        }

        System.out.println();
        System.out.println("PAYMENTS:");

        // Percorre a lista
        for (Employee emp : listEmp) {
            System.out.println(emp.getName() + " - $ " + String.format("%.2f", emp.payment()));
        }

        sc.close();
    }
}
