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
        // Usando o método setName para alterar o valor do atributo
        product.setName("Computer");
        // Usando o método getName para acessar o valor do atrbiuto
        System.out.println("Update name: " + product.getName());
        // Usando o método setPrice para alterar o valor do produto
        product.setPrice(1200.00);
        // Usando o método getPrice para acessar o valor do atrbiuto
        System.out.println("Update price: " + product.getPrice());
        // Usando o método getQuantity para saber o total em estoque
        System.out.println("Quantity: " + product.getQuantity());

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