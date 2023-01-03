package application;

import java.util.Scanner;
// Exemplo de problema "sem" utilizar POO
public class Program {
    public static void main(String[] args) {
        // Declaramos 6 variáveis do tipo double
        double xA, xB, xC, yA, yB, yC;
        double areaX, areaY, pX, pY;
        // Criamos um objeto(instância) da classe Scanner
        Scanner sc = new Scanner(System.in);
        // Solicitamos os lados do triângulo X
        System.out.println("Enter the measures of triangle X: ");
        xA = sc.nextDouble();
        xB = sc.nextDouble();
        xC = sc.nextDouble();
        // Solicitamos os lados do triângulo Y
        System.out.println("Enter the measure of triangle Y: ");
        yA = sc.nextDouble();
        yB = sc.nextDouble();
        yC = sc.nextDouble();

        // Calcula o valor de p para X e Y
        pX = (xA + xB + xC) / 2;
        pY = (yA + yB + yC) / 2;

        // Calcula a área de cada triângulo
        areaX = Math.sqrt(pX * (pX - xA) * (pX - xB) * (pX - xC));
        areaY = Math.sqrt(pY * (pY - yA) * (pY - yB) * (pY - yC));

        // Exibe o resultado da area de cada triângulo
        System.out.printf("Area do triângulo x é: %.1f%n", areaX);
        System.out.printf("Area do triângulo y é: %.1f%n", areaY);

        // Compara as áreas e retorna algo
        if (areaX > areaY) {
            System.out.println("Area do triângulo X é maior!");
        } else {
            System.out.println("Area do triângulo Y é maior!");
        }

        // Encerra o uso da classe Scanner
        sc.close();
    }
}
