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

1. É uma referência para o próprio objeto
2. Usos comuns:
   1. **Diferenciar atributos de variáveis locais**
   2. **Passar o próprio objeto como argumento na chamada de um método ou construtor**

Usando o exemplo aterior temos que:
````java
Product product = new Product("TV", 1500.00, 0);
````

````java
public Product(String name, double price, int quantity) {
    this.name = name;
    this.price = price;
    this.quantity = quantity;
        }
````

Quando passamos os valores para o construtor temos que esses valores serão armazenados nos atributos name, price e 
quantity, para isso fazemos o uso da palavra-chave this.

## Sobrecarga

1. É um recurso que uma classe possui de **oferecer mais de uma operação com o mesmo nome, porém com diferentes listas 
   de parâmetros.**

Proposta de melhoria:
1. Vamos criar um construtor opcional, o qual recebe apenas nome e preço do produto. A quantidade em estoque deste 
   novo produto, por padrão, deverá então ser iniciada com valor zero.
2. Nota: É possível também incluir um construtor padrão

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
````

Ou seja, quando passamos apenas dois argumentos para o construtor da classe Product, temos que apenas o segundo 
construtor será utilizado. Ou seja, disponbilizamos mais de uma versão da mesma operação diferenciando apenas a 
quantidade de parâmetros.

Por fim, podemos adicionar o construtor padrão passando apenas:
````java
public Product() {
    
        }
````

Dessa forma temos três versões de construtores que podemos utilizar.

## Encapsulamento

1. É um princípio que consiste em **esconder detalhes de implementação de uma classe, expondo apenas operações 
   seguras e que mantenham os objetos em um estado consistente.**
2. Regra de ouro: O objeto deve sempre estar em um estado consistente, e a própria classe deve garantir isso.
3. Regra geral básica:
   1. Um objeto **não** deve expor nenhum atributo(modificador de acesso **private**)
   2. **Os atributos devem ser acessados por meio de métodos get e set.**

### Padrão para implementação de getters e setters
````java
private String name;
private double price;

public String getName() {
    return name;
        }
public void setName(String name) {
    this.name = name;
        }
        
public double getPrice() {
    return price;
        }
        
public void setPrice(double price) {
    this.price = price;
        }
````

No exemplo acima temos dois atributos que utilizam o **modificador de acesso private. Isso significa dizer que esses 
atributos não podem ser acessador por outras classes.**

A nomenclatura do método para obter os valores dos atributos deve começar com get seguido do nome do atributo em 
camel case.

Já a nomenclatura para alterar o valor do atributo deve começar com set seguido do nome do atributo em camel case. 
Como estamos alterando o atributo temos que usar a palavra-chave this para acessar o atributo do objeto.

Por fim, os métodos set e get devem ser declarados após a declaração dos contrutores.

Exemplo de getters e setters:
````java
package entities;
public class Product {
   private String name;
   private double price;
   private int quantity;

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


   public void setName(String name) {
      this.name = name;
   }

   public String getName() {
      return name;
   }

   public double getPrice() {
      return price;
   }

   public void setPrice(double price) {
      this.price = price;
   }

   // Não queremos alterar a quantidade em estoque, apenas saber o total
   public int getQuantity() {
      return quantity;
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


[Voltar](../README.md)