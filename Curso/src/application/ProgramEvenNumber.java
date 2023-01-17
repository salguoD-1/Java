package application;

import java.util.Locale;
import java.util.Scanner;

public class ProgramEvenNumber {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int num;
        int count = 0;
        System.out.print("Quantos números você vai digitar? ");
        num = sc.nextInt();
        int[] nums = new int[num];

        for (int i = 0; i < nums.length; i++) {
            System.out.print("Digite um número: ");
            nums[i] = sc.nextInt();
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] % 2 == 0) {
                System.out.printf("%d ", nums[j]);
                count++;
            }
        }

        System.out.printf("%nQUANTIDADE DE PARES = %d", count);
    }
}
