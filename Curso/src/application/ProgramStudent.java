package application;

import entities.Student;

import java.util.Locale;
import java.util.Scanner;

public class ProgramStudent {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("en", "US"));
        Scanner sc = new Scanner(System.in);

        Student student = new Student();

        student.name = sc.nextLine();
        student.notaUm = sc.nextDouble();
        student.notaDois = sc.nextDouble();
        student.notaTres = sc.nextDouble();

        System.out.printf("FINAL GRADE = %.2f%n", student.finalGrade());
        System.out.printf("%s%n", student.passOrFailed());
        sc.close();
    }
}
