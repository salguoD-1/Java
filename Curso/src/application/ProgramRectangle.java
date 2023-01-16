package application;

import entities.Rectangle;

import java.util.Locale;
import java.util.Scanner;

public class ProgramRectangle {
    public static void main(String[] args) {
        // Criamos duas instâncias de duas classes, Locale e Scanner
        Locale.setDefault(new Locale("en", "US"));
        Scanner sc = new Scanner(System.in);

        // Instanciamos a classe Rectangle que contém toda a lógica do nosso programa
        Rectangle rectangle = new Rectangle();

        System.out.println("Enter the rectangle width and height: ");
        rectangle.width = sc.nextDouble();
        rectangle.height = sc.nextDouble();

        System.out.printf("AREA = %.2f\nPERIMETER = %.2f\nDIAGONAL = %.2f\n", rectangle.area(), rectangle.perimeter(), rectangle.diagonal());
        sc.close();
    }
}
