package application;

import java.util.Locale;
import java.util.Scanner;

public class ProgramSumOfVectors {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int num;
        System.out.print("Quantos valores vai ter cada vetor? ");
        num = sc.nextInt();

        int[] vect1 = new int[num];
        int[] vect2 = new int[num];
        int[] vect3 = new int[num];

        System.out.println("Digite os valores do vetor A: ");
        for (int i = 0; i < vect1.length; i++) {
            vect1[i] = sc.nextInt();
        }

        System.out.println("Digite os valores do vetor B: ");
        for (int j = 0; j < vect2.length; j++) {
            vect2[j] = sc.nextInt();
        }

        // Soma os valores dos vetores A e B
        for (int k = 0; k < num; k++) {
            vect3[k] = vect1[k] + vect2[k];
        }

        System.out.println("VETOR RESULTANTE: ");
        for (int x = 0; x < vect3.length; x++) {
            System.out.printf("%d%n", vect3[x]);
        }

    }
}
