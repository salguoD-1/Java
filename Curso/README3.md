# Comportamento de memória, arrays e listas


## Classes são tipos referência
Variáveis cujo tipo são **classes não devem ser entedidas como caixas, mas sim "tentáculos"(ponteiros) para caixas.**

Suponhamos que temos uma classe chamada Product com duas variáveis, p1 e p2.

````java
Product p1, p2;
````

**Essas variáveis(p1 e p2) estarão alocadas na memória stack. No entanto, quando fazemos a variável receber um novo 
produto, ou seja, criamos uma instância dessa classe e passamos os valores abaixo temos que:**
````java
p1 = new Product("TV", 900.00, 0);
````

**Será alocado um objeto na memória Heap, que é uma alocação dinâmica pois os objetos são alocados em tempo de 
execução. Além disso, a variável p1 não irá guardar o product em sí, mas o endereço de memória onde o objeto foi 
alocado.** **Ou seja, a variável p1 que está alocada na memória stack irá armazenar um ponteiro que aponta para o 
objeto na memória heap.**

![](images/memoria.PNG)

**No exemplo acima temos que a variável p1 que está alocada na memória stack armazena um endereço que representa a 
posição em que o objeto instânciado com os valores passados está armazenado na memória heap. Chamamos isso de 
ponteiro.**

**Por fim, é possível atribuir os valores da variável p1 para a variável p2, quando fazemos isso temos que a variável 
p2 irá apontar para o objeto instânciado pela variável p1, ou seja, mantendo os seus valores.**

## Valor "null"
**Tipos referência aceitam o valor "null", que indica que a `variável aponta para ninguém`.**

````java
Product p1, p2;

p1 = new Product("TV", 900. 0);
````

Nesse caso temos que p1 aponta para o objeto instânciado na memória heap, já a variável p2 não aponta ninguém, ou 
seja, ela é null.

## Tipos primitivos são tipos valor

**Em java, tipos primitivos são tipos valor. Tipos valor são caixas e não ponteiros.**

````java
double x, y;
````

**As variáveis x, y são do tipo primitivo double que são variáveis armazenadas na memória stack.**

````java
double x, y;

y = x;
````

**Se fizermos y = x, ou seja, passamos uma cópia do valor de x para y.**

O exemplo abaixo é uma representação das variáveis primitivas e a memória stack. 

![](images/memoria-stack.PNG)

## Tipos primitivos e inicialização

- Demo
````java
int p;
// Error: Variável não inicializada
System.out.println(p)

p = 10;
System.out.println(p)
````

Não é possível imprimir algo que não existe, ou seja, que não foi inicializado.

### Valores padrão

1. Quando alocamos (new) qualquer tipo estruturado (classe ou array) são atribuídos valores padrão aos seus elementos
   1. números: 0
   2. boolean: false
   3. char: caractere código 0
   4. objeto: null

````java
Product p = new Product();
````

Quando alocamos (instânciamos uma classe) temos que os valores dos atributos serão padrão, como descritos acima.

![](images/valores-padrao.PNG)

## Tipos referência vs tipos valor

Vantagens e desvantagens de cada tipo

![](images/tipos-referencia-valor.PNG)

## Garbage Collector
1. É um processo que automatiza o gerenciamento de memória de um programa em execução.
2. O garbage collector monitora os objetos alocados dinamicamente pelo programa (no heap), desalocando aqueles que 
   não estão mais sendo utilizados.

Exemplo do garbage collector em ação
![](images/garbage-collector.PNG)

Note que quando fazemos p1 receber p2, temos que o valor de p1 ficará sem uso, nesse caso o garbage collector irá 
desalocar os recursos anteriormente armazenados na variável p1.

Por fim, variáveis locais(exemplo: variáveis em estruturas if, while etc) serão desalocadas imediatamente assim que 
seu escopo local sair de execução.

## Vetores

1. Vetores são basicamente um array unidimensional que possui elementos e cada elemento possui um índice, sempre 
começando no índice 0.
2. Array é um estrutura de dados:
   1. Homogênea(dados do mesmo tipo)
   2. Ordenada(elementos acessados por meio de posições)
   3. Alocada de uma vez só, em um bloco contíguo de memória
3. Vantagens:
   1. Acesso imediato aos elementos pela sua posição
4. Desvantagens:
   1. Tamanho fixo
   2. Dificuldade para se realizar inserções e deleções

Problema exemplo 1:
Fazer um programa para ler um número inteiro N e a altura de N pessoas. Armazene as N alturas em um vetor. Em 
seguida, mostrar a altura média dessas pessoas.

Input:
3
1.72
1.56
1.80

Output:
AVERAGE HEIGHT = 1.69

Resultado do programa:
````java
package application;

import java.util.Locale;
import java.util.Scanner;

public class ProgramAverageHeight {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("en", "US"));
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter an array size: ");
        int number = sc.nextInt();
        double averageHeight = 0;
        double[] arr = new double[number];

        for (int i = 0; i < number; i++) {
            System.out.print("Enter your height: ");
            arr[i] = sc.nextDouble();
            averageHeight += arr[i];
        }
        // Divide a soma dos elementos pela quantidade de elementos presentes no array.
        averageHeight /= number;

        System.out.printf("AVERAGE HEIGHT = %.2f%n", averageHeight);

        sc.close();
    }
}
````

Problema exemplo 2:
Fazer um programa para ler um número inteiro N e os dados (nome e preço) de N produtos. Armazene os N produtos em um 
vetor. Em seguida, mostrar o preço médio dos produtos.

Classe Product2
```java
package entities;

public class Product2 {
    private String name;
    private double price;

    // Construtor com dois parâmetros
    public Product2(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return  name;
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
}
```

Classe ProgramAveragePrice
```java
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
```

No exemplo acima nós criamos um "array de classe" onde passamos um valor n como quantidade de elementos que esse 
array irá armazenar. Note que criamos uma variável chamada vect que é um vetor e essa variável será armazenada na 
memória stack que irá apontar a referência para os n slots de memória na memória heap. Porém, esses valores do vetor 
são nulos, para isso é necessário instanciar esse objeto atribuindo valores para ele como vemos no exemplo a direita.
![](images/array-de-classe.png)

Ou seja, de forma resumida, criamos três instâncias da classe Product2 passando o nome e o preço do produto, depois 
acessamos o valor de cada produto usando o método getPrice.

### Desafio sobre vetores
A dona de um pensionato possui dez quartos para alugar para estudantes, sendo esses quartos identificados pelos 
números 0 a 9.

Fazer um programa que inicie com todos os dez quartos vazios, e depois leia uma quantidade N representando o número 
de estudantes que vão alugar quartos (N pode ser de 1 a 10). Em seguida, registre o aluguel dos N estudantes. Para 
cada registro de aluguel, informaro nome e email do estudante, bem como qual dos quartos ele escolheu (de 0 a 9). 
Suponha que seja escolhido um quarto vago. Ao final, seu programa deve imprimir um relatório de todas ocupações do 
pensionato, por ordem de quarto, conforme exemplo:

Input:
How many rooms will be rented? 3

Rent #1:
Name: Maria Green
Email: maria@gmail.com
Room: 5

Rent #2:
Name: Marco Antonio
Email: marco@gmail.com
Room: 1

Rent #3:
Name: Alex Brown
Email: alex@gmail.com
Room: 8

Busy rooms:
1: Marco Antonio, marco@gmail.com
5: Maria Green, maria@gmail.com
8: Alex Brown, alex@gmail.com

Solução:
Classe Room
```java
package entities;

public class Room {
    private String name;
    private String email;
    private int room;

    public Room(String name, String email, int room) {
        this.name = name;
        this.email = email;
        this.room = room;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getRoom() {
        return room;
    }

    public String toString() {
        return String.format("%d: %s, %s", room, name, email);
    }
}
```

Classe ProgramRoomRent
```java
package application;

import entities.Room;

import java.util.Locale;
import java.util.Scanner;

public class ProgramRoomRent {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        String clientName;
        String clientEmail;
        int clientRoom;
        int totalOfRooms;

        int[] room = new int[10];
        Room[] rentRoom = new Room[10];

        System.out.print("How many rooms will be rented? ");
        totalOfRooms = sc.nextInt();
        // Limpa o buffer do teclado
        sc.nextLine();

        for (int i = 0; i < totalOfRooms; i++) {
            System.out.printf("%nRent #%d%n", i + 1);
            System.out.print("Name: ");
            clientName = sc.nextLine();
            System.out.print("Email: ");
            clientEmail = sc.nextLine();
            System.out.print("Room: ");
            clientRoom = sc.nextInt();
            sc.nextLine();
            // Criamos uma instância da classe Room e inicializamos o contrutor
            rentRoom[clientRoom] = new Room(clientName, clientEmail, clientRoom);
        }

        // Analisa se a instância na posição j está vazia
        System.out.printf("%nBusy rooms:%n");
        for (int j = 0; j < 10; j++) {
            if (rentRoom[j] != null) {
                System.out.println(rentRoom[j]);
            }
        }
    }
}
```

## Boxing
1. É o processo de conversão de um objeto tipo valor para um objeto tipo referência compartível

![](images/boxing.png)

No exemplo acima passamos um valor x do tipo primitivo para um objeto, esse objeto irá apontar para esse valor na 
memória heap.

## Unboxing
1. É o processo de conversão de um objeto tipo referência para um objeto tipo valor compatível

![](images/unboxing.png)

No exemplo acima nós pegamos uma variável do tipo objeto e fazemos o casting, transformando o valor dela para um 
tipo primitivo. Esse processo faz y receber 20 direto na memória stack.

## Wrapper Classes
1. São classes equivalentes aos tipos primitivos
2. Boxing e Unboxing é natural na linguagem
3. Uso comum:
   1. Campos de entidades em sistemas de informação (IMPORTANTE!)
      1. Pois tem tipos referência (classes) aceitam valor null e usufruem dos recursos OO.

Exemplo:
```java
public class Product {
    public String name;
    public Double price;
    public Integer quantity;
}
```

Note que usamos as wrapper classes, é recomendado pois caso o valor não seja passado, teremos um valor null.

## Laço `for each`

O laço for each possui uma sintaxe opcional e simplificada para percorrer coleções.

Sintaxe:
```java
for (Tipo apelido: coleção){
   <comando 1>
   <comando 2>
}
```

Exemplo real:
```java
package application;

public class ProgramForEach {
    public static void main(String[] args) {
        // Instânciamos um array de Strings e inicializamos com 3 valores
        String[] vect = new String[] {"Maria", "Bob", "Alex"};

        // Tipo de dado dos elementos - Nome(Apelido) : nome da coleção(vect)
        for (String nome : vect) {
            System.out.println(nome);
        }
    }
}
```

Podemos ler o programa acima da seguinte forma: Para cada objeto nome(apelido) contido em vect(tipo da coleção) faça 
algo...

## Listas

[Voltar](../README.md)