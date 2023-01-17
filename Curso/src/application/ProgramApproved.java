package application;

import entities.StudentApproved;

import java.util.Locale;
import java.util.Scanner;

public class ProgramApproved {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int num;
        System.out.print("Quantos alunos serão digitados? ");
        num = sc.nextInt();
        String name;
        double grade1;
        double grade2;

        StudentApproved[] student = new StudentApproved[num];

        for (int i = 0; i < num; i++) {
            System.out.printf("Digite nome, primeira nota e a segunda nota do %da aluno: %n", i + 1);
            // Limpa o buffer do teclado
            sc.nextLine();
            name = sc.nextLine();
            grade1 = sc.nextDouble();
            grade2 = sc.nextDouble();

            student[i] = new StudentApproved(name, grade1, grade2);
        }

        System.out.println("Alunos aprovados: ");
        for (int j = 0; j < num; j++) {
            if ((student[j].getGrade1() + student[j].getGrade2()) / 2 >= 6) {
                System.out.printf("%s%n", student[j].getName());
            }
        }
    }
}
