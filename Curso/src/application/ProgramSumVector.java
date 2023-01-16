package application;

import java.util.Locale;
import java.util.Scanner;

public class ProgramSumVector {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos numeros voce vai digitar? ");
        int num = sc.nextInt();
        // Limpa o buffer do teclado
        sc.nextLine();
        // Vetor de N posições
        double[] vect = new double[num];
        double sum = 0;

        for (int i = 0; i < vect.length; i++) {
            System.out.print("Digite um numero: ");
            vect[i] = sc.nextDouble();
            sum += vect[i];
        }
        System.out.print("VALORES = ");
        for (int j = 0; j < vect.length; j++) {
            System.out.printf("%.1f ", vect[j]);
        }

        System.out.printf("%nSOMA = %.2f%n", sum);
        System.out.printf("MEDIA = %.2f%n", sum / vect.length);
    }
}
