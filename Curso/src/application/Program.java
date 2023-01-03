package application;
// Importamos o pacote entities e a classe que queremos usar
import entities.Triangle;

import java.util.Scanner;
// Exemplo de problema "sem" utilizar POO
public class Program {
    public static void main(String[] args) {
        // Declaramos 6 variáveis do tipo double
//        double x.a, x.b, x.c, y.a, y.b, y.c;

        // Duas variáveis x e y do tipo Triangle
        Triangle x, y;
        // Criando objetos(instâncias) da classe Triangle
        x = new Triangle();
        y = new Triangle();

        double areaX, areaY, pX, pY;
        // Criamos um objeto(instância) da classe Scanner
        Scanner sc = new Scanner(System.in);
        // Solicitamos os lados do triângulo X
        System.out.println("Enter the measures of triangle X: ");
        x.a = sc.nextDouble();
        x.b = sc.nextDouble();
        x.c = sc.nextDouble();
        // Solicitamos os lados do triângulo Y
        System.out.println("Enter the measure of triangle Y: ");
        y.a = sc.nextDouble();
        y.b = sc.nextDouble();
        y.c = sc.nextDouble();

        // Calcula o valor de p para X e Y
        pX = (x.a + x.b + x.c) / 2;
        pY = (y.a + y.b + y.c) / 2;

        // Calcula a área de cada triângulo
        areaX = Math.sqrt(pX * (pX - x.a) * (pX - x.b) * (pX - x.c));
        areaY = Math.sqrt(pY * (pY - y.a) * (pY - y.b) * (pY - y.c));

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
