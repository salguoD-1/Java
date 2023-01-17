package application;

import entities.Person2;

import java.util.Locale;
import java.util.Scanner;

public class ProgramOlderPerson {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int num;
        System.out.print("Quantas pessoas você vai digitar? ");
        num = sc.nextInt();
        // Limpa o buffer do teclado
        sc.nextLine();
        // Criamos n instâncias da classe Person2
        Person2[] person = new Person2[num];
        String name;
        int age;
        int olderPerson;
        String older = "";

        for (int i = 0; i < num; i++) {
            System.out.printf("Dados da %da pessoa: ", i + 1);
            System.out.print("Nome: ");
            name = sc.next();
            System.out.print("Idade: ");
            age = sc.nextInt();
            // Passamos os dados para o construtor da classe Person2
            person[i] = new Person2(name, age);
        }

        olderPerson = person[0].getAge();

        for (int j = 0; j < num; j++) {
            if (person[j].getAge() > olderPerson) {
                olderPerson = person[j].getAge();
                older = person[j].getName();
            }
        }

        System.out.printf("PESSOA MAIS VELHA: %s%n", older);
    }
}
