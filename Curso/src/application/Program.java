package application;
import java.util.Locale;
import java.util.Scanner;
import entities.Product;
public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        String name;
        double price;
        int quantity;
        int newQuantity;
        System.out.println("Enter product data: ");
        System.out.print("Name: ");
        name = sc.nextLine();

        System.out.print("Price: ");
        price = sc.nextDouble();

        System.out.print("Quantity in stock: ");
        quantity = sc.nextInt();

        // Instanciamos a classe passando name, price e quantity como argumento
        // para o construtor da classe.
        Product product = new Product(name, price, quantity);

        System.out.println();
        System.out.println("Product data: " + product);
        System.out.println();
        System.out.print("Enter the number of products to be added in stock: ");
        newQuantity = sc.nextInt();

        product.addProducts(newQuantity);
        System.out.println();
        System.out.println("Updated data: " + product);
        System.out.println();
        System.out.print("Enter the number of products to be removed from stock: ");
        newQuantity = sc.nextInt();
        product.removeProducts(newQuantity);
        System.out.println();
        System.out.println("Updated data: " + product);
        sc.close();
    }
}