package application;

import entities.Person;

import java.util.Locale;
import java.util.Scanner;

public class ProgramAverageHeightPerson {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.print("Quantas pessoas serão digitadas? ");
        int num = sc.nextInt();
        // Limpa o buffer do teclado
        sc.nextLine();
        // Cria n instâncias da classe Person
        Person[] person = new Person[num];
        String namePerson;
        int agePerson;
        double sumHeight = 0;
        double heightPerson;
        double percentage = 0;

        for (int i = 0; i < person.length; i++) {
            System.out.printf("Dados da %da pessoa: ", i + 1);
            System.out.print("Nome: ");
            namePerson = sc.next();
            System.out.print("Idade: ");
            agePerson = sc.nextInt();
            System.out.print("Altura: ");
            heightPerson = sc.nextDouble();
            // Armazena os valores em cada instância da classe, passando os valores
            // para o construtor declarado
            person[i] = new Person(namePerson, agePerson, heightPerson);
        }

        for (int j = 0; j < person.length; j++) {
            sumHeight += person[j].getHeight();
        }

        System.out.printf("Altura média: %.2f%n", sumHeight / person.length);

        for (int k = 0; k < person.length; k++) {
            if (person[k].getAge() < 16) {
                percentage++;
            }
        }

        System.out.printf("Pessoas com menos de 16 anos: %.1f%%%n", (percentage / person.length) * 100);
        for (int x = 0; x < person.length; x ++) {
            if (person[x].getAge() < 16) {
                System.out.printf("%s%n", person[x].getName());
            }
        }


    }
}
