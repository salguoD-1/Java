package application;

import java.util.Locale;
import java.util.Scanner;

public class ProgramAverageEvenNumber {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int num;
        int count = 0;
        boolean flag = false;
        System.out.print("Quantos elementos vai ter o vetor? ");
        num = sc.nextInt();
        double average = 0;

        int[] nums = new int[num];

        for (int i = 0; i < nums.length; i++) {
            System.out.print("Digite um número: ");
            nums[i] = sc.nextInt();
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] % 2 == 0) {
                average += (double) nums[j];
                flag = true;
                count++;
            }
        }

        average /= count;

        if (flag) {
            System.out.printf("MÉDIA DOS PARES = %.1f%n", average);
        } else {
            System.out.println("NENHUM NÚMERO PAR");
        }


    }
}
