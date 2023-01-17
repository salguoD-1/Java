package application;

import java.util.Locale;
import java.util.Scanner;

public class ProgramBelowAverage {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int num;
        System.out.print("Quantos elementos vai ter o vetor? ");
        num = sc.nextInt();

        double[] nums = new double[num];
        double average = 0;

        for (int i = 0; i < nums.length; i++) {
            System.out.print("Digite um número: ");
            nums[i] = sc.nextDouble();
        }

        for (int j = 0; j < nums.length; j++) {
            average += nums[j];
        }
        average /= nums.length;
        System.out.printf("%nMEDIA DO VETOR: %.3f%n", average);
        System.out.println("ELEMENTOS ABAIXO DA MÉDIA: ");
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] < average) {
                System.out.printf("%.1f%n", nums[k]);
            }
        }
    }
}
