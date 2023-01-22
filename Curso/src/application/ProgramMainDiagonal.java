package application;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class ProgramMainDiagonal {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int matrixSize;
        int countNegativeNumbers = 0;
        System.out.print("Enter matrix size: ");
        matrixSize = sc.nextInt();

        // Matriz de dados inteiros
        int[][] matrix = new int[matrixSize][matrixSize];

        for (int i = 0; i < matrixSize; i++) {
            System.out.print("Enter elements: ");
            for (int j = 0; j < matrixSize; j++) {
                // Adiciona os elementos na matriz
                matrix[i][j] = sc.nextInt();
                // Analisa se o valor digitado é negativo
                if (matrix[i][j] < 0) {
                    // Incrementa uma unidade caso o elemento seja negativo
                    countNegativeNumbers++;
                }
            }
        }

        // Percorre a matriz e exibe a diagonal principal
        System.out.println("Main diagonal:");
        for (int x = 0; x < matrixSize; x++) {
            System.out.print(matrix[x][x] + " ");
        }

        System.out.printf("%nNegative numbers = %d%n", countNegativeNumbers);
    }
}
