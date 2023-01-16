package application;

import entities.Product2;

import java.util.Locale;
import java.util.Scanner;

public class ProgramAveragePrice {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        // Limpa o buffer do teclado
        sc.nextLine();
        String productName;
        double productPrice;
        double averagePrice = 0;
        Product2[] vect = new Product2[number];

        for (int i = 0; i < number; i++) {
            System.out.print("Product name: ");
            productName = sc.next();
            System.out.print("Product price: ");
            productPrice = sc.nextDouble();
            // Instanciamos a classe Product2 passando os dois argumentos para o construtor
            vect[i] = new Product2(productName, productPrice);
        }

        for (int i = 0; i < number; i++) {
            // Para cada objeto da classe nós acessamos o seu valor e armazenamos
            // na variável abaixo.
            averagePrice += vect[i].getPrice();
        }

        System.out.printf("AVERAGE PRICE = %.2f%n", averagePrice / number);

    }
}
