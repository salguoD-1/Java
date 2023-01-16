package application;

import java.util.Locale;
import java.util.Scanner;

public class ProgramAverageHeight {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("en", "US"));
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter an array size: ");
        int number = sc.nextInt();
        double averageHeight = 0;
        double[] arr = new double[number];

        for (int i = 0; i < number; i++) {
            System.out.print("Enter your height: ");
            arr[i] = sc.nextDouble();
            averageHeight += arr[i];
        }
        // Divide a soma dos elementos pela quantidade de elementos presentes no array.
        averageHeight /= number;

        System.out.printf("AVERAGE HEIGHT = %.2f%n", averageHeight);

        sc.close();
    }
}
