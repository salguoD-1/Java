package application;

import entities.PersonData;

import java.util.Locale;
import java.util.Scanner;

public class ProgramPersonData {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int num;
        System.out.print("Quantas pessoas serao digitadas? ");
        num = sc.nextInt();
        // Limpa o buffer do teclado
        sc.nextLine();
        double heightPerson;
        double lowerHeight = 0;
        double highHeight = 0;
        double averageHeightWoman = 0;
        int count = 0;
        int totalOfMens = 0;
        char sexPerson;

        PersonData[] person = new PersonData[num];

        for (int i = 0; i < num; i++) {
            System.out.printf("Altura da %da pessoa: ", i + 1);
            heightPerson = sc.nextDouble();
            System.out.printf("Gênero da %da perssoa: ", i + 1);
            sexPerson = sc.next().toLowerCase().charAt(0);
            person[i] = new PersonData(heightPerson, sexPerson);
        }
        // Valores padrão
        lowerHeight = person[0].getHeight();
        highHeight = person[0].getHeight();

        for (int j = 0; j < num; j++) {
            if (person[j].getSex() == 'f') {
                averageHeightWoman += person[j].getHeight();
                count++;
            }  else {
                if (person[j].getHeight() < lowerHeight) {
                    lowerHeight = person[j].getHeight();
                } if (person[j].getHeight() > highHeight) {
                    highHeight = person[j].getHeight();
                }
                totalOfMens++;
            }
        }

        averageHeightWoman /= count;


        System.out.printf("Menor altura = %.2f%n", lowerHeight);
        System.out.printf("Maior altura = %.2f%n", highHeight);
        System.out.printf("Média das alturas das mulheres = %.2f%n", averageHeightWoman);
        System.out.printf("Número de homens = %d%n", totalOfMens);
    }
}
