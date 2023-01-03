package application;

import entities.Product;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        // Criamos dois objetos, sc e product
        Scanner sc = new Scanner(System.in);
        Product product = new Product();
        int productQuantity;

        // Solicitação de dados
        System.out.println("Enter product Data: ");
        System.out.print("Name: ");
        product.name = sc.next();
        System.out.print("Price: ");
        product.price = sc.nextDouble();
        System.out.print("Quantity in stock: ");
        product.quantity = sc.nextInt();

        System.out.printf("Product data: %s%n", product);

        System.out.print("Enter the number of products to be added in stock: ");
        productQuantity = sc.nextInt();
        product.addProducts(productQuantity);

        System.out.printf("Update data: %s%n", product);
        System.out.print("Enter the number of products to be removed from stock: ");
        productQuantity = sc.nextInt();
        product.removeProducts(productQuantity);

        System.out.printf("Update data: %s%n", product);
    }
}