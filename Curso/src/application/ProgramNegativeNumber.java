package application;

import java.util.Locale;
import java.util.Scanner;

public class ProgramNegativeNumber {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos numeros voce vai digitar? ");
        int maxValues = sc.nextInt();
        // Limpa o buffer do teclado
        sc.nextLine();
        // Array de números
        int[] numbers = new int[maxValues];

        // Armazena todos os valores digitados pelo usuário
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Digite um numero: ");
            numbers[i] = sc.nextInt();
        }

        System.out.println("NUMEROS NEGATIVOS: ");

        for (int i = 0; i < numbers.length; i++) {
            // Exibe apenas os números negativos
            if (numbers[i] < 0) {
                System.out.printf("%d%n", numbers[i]);
            }
        }
    }
}
