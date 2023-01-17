package application;

import java.util.Locale;
import java.util.Scanner;

public class ProgramBiggestNumber {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int num;
        int index;
        System.out.print("Quantos números você vai digitar? ");
        num = sc.nextInt();

        double[] nums = new double[num];
        double biggestNumber;

        for (int i = 0; i < nums.length; i++) {
            System.out.print("Digite um número: ");
            nums[i] = sc.nextDouble();
        }

        // Pré-definimos os valores
        biggestNumber = nums[0];
        index = 0;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] > biggestNumber) {
                biggestNumber = nums[j];
                index = j;
            }
        }

        System.out.printf("%nMAIOR VALOR: %.1f%n", biggestNumber);
        System.out.printf("POSIÇÃO DO MAIOR VALOR = %d%n", index);

    }
}
