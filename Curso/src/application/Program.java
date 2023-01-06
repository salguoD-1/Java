package application;

import util.Calculator;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    // Membro estático
    // Final = valor constante(inalterável)
    public static final double PI = 3.14159;
    public static void main(String[] args) {
        // Permite utilizar ponto no lugar de vírgula.
        Locale.setDefault(new Locale("en", "US"));
        // Criamos dois objetos, sc e product
        Scanner sc = new Scanner(System.in);
        double radius;
        double circum;
        double vol;

        System.out.println("Enter radius: ");
        radius = sc.nextDouble();
        // Método circumference calcula a cirfunferência dado um raio
        circum = Calculator.circumference(radius);
        // Método volume calcula o volume dado o raio
        vol = Calculator.volume(radius);

        System.out.printf("Circumference: %.2f%n", circum);
        System.out.printf("Volume: %.2f%n", vol);
        System.out.printf("PI value: %.2f%n", Calculator.PI);
    }
}