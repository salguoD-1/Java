package entities;
public class Product {
    public String name;
    public double price;
    public int quantity;

    // Construtor que recebe como argumento os seus atributos
    public Product(String name, double price, int quantity) {
        // Quando usamos this estámos nos referindo ao atributo name da classe.
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Construtor que inicializa os atributos name e price.
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double totalValueInStock() {
        return quantity * price;
    }

    public void addProducts(int quantity) {
        // this = faz autoreferenciamento a variável quantity da classe Product
        this.quantity += quantity;
    }

    public void removeProducts(int quantity) {
        this.quantity -= quantity;
    }

    public String toString() {
        return name
                + ", "
                + "$ "
                + String.format("%.2f", price)
                + ", "
                + quantity
                + " units, "
                + "$ "
                + String.format("%.2f", totalValueInStock());
    }
}
