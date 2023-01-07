# Construtores, this, sobrecarga e encapsulamento

## Construtor

1. É uma operação especial da classe, que `executa no momento da instaciação do objeto`
2. Usos comuns:
    1. **Iniciar valores dos atributos**
   2. **Permitir ou obrigar que o objeto receba dados/dependências no momento de sua instaciação(injeção de 
      dependência)**
3. **Se um construtor customizado não for especificado, a classe disponibiliza o construtor padrão:**
    - Product p = new Product();
4. **É possível especificar mais de um construtor na mesma classe(sobrecarga)**

Problema Exemplo:
Enter product data:
Name: TV
Price: 900.00
Quantity in stock: 10

Product data: TV, $ 900.00, 10 units, Total: $ 900.00

Enter the number of products to be added in stock: 5

Update data: TV, $ 900.00, 15 units, Total: $ 13500.00

Enter the number of products to be removed from stock: 3

Update data: TV, $ 900.00, 12 units, Total: $ 10800.00

Fizemos esse exemplo no README anterior. Podemos melhorar esse código, veremos como.

### Proposta de melhoria
Quando rodamos o nosso código, é criado automaticamente um construtor que inicializa os membros da nossa classe, 
nesse caso como não criamos nenhum construtor temos que os valores serão "vazios".

````java
Product product = new Product();
````

temos que product terá seus atributos/métodos vazios. Os valores são:
1. String: null
2. double: 0.0
3. int: 0

A pergunta agora é: Faz sentido um produto que não possui nome/preço/quantidade? Para evitar isso podemos usar 
construtores para inicializar esses valores.

Em java, nós geralmente usamos o construtor após os atributos e antes dos métodos.

Classe Product
````java
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
````

Classe Program
````java
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
````

Dessa forma temos que a instaciação será realizada quando tivermos os dados a serem passados como argumento para o 
construtor da classe. Dessa forma evitamos erros.

## Palavra this



[Voltar](../README.md)