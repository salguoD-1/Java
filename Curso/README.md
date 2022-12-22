# Entrada de dados em Java

## Classe Scanner
Para realizar a entrada de dados(input) é necessário criar um objeto(instância) do tipo Scanner, vejamos:

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.close();
    }
}
```

Note que criamos uma instância(objeto) da classe Scanner e passamos System.in como argumento, isso significa dizer 
que queremos a entrada de dados. Além disso, note que importamos a API java.util.Scanner para poder usar a classs 
Scanner. Por fim, usamos o método .close() para "desalocar" o uso do objeto.

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String text;
        Scanner sc = new Scanner(System.in);
        text = sc.next();
        System.out.println(text);
        sc.close();
    }
}
```

No exemplo acima usamos o método .next() que lê a primeira coisa digitada no terminal. Por fim fechamos a conexão com o 
objeto.

Java disponibiliza alguns métodos para leitura, vejamos:

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int age;
        float weight;
        double height;
        String name;

        Scanner sc = new Scanner(System.in);

        // Lê um número inteiro
        System.out.print("Digite a sua idade: ");
        age = sc.nextInt();

        // Lê um número decimal
        System.out.print("Digite o seu peso: ");
        weight = sc.nextFloat();

        // Lê um número decimal de dupla precisão
        System.out.print("Digite a sua altura: ");
        height = sc.nextDouble();

        // Lê qualquer coisa digitada no terminal
        System.out.print("Digite o seu nome: ");
        name = sc.next();

        // Exibe o resultado na tela
        System.out.printf("\nName: %s\nAge: %d\nHeight: %.1f\nWeight: %.1f\n", name, age, height,weight);
        // Fecha a conexão com o objeto
        sc.close();
    }
}
```

NOTA: O tipo double pega a assinatura do sistema, ou seja, se seu sistema está em PT-BR isso significa dizer que ele 
vai receber dados usando vírgula, caso contrário ele recebe usando ponto. 

Podemos usar o método .nextLine() que armazena um valor como string, vejamos:

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Cria um objeto do tipo Scanner
        Scanner sc = new Scanner(System.in);

        String name, age, weight, height;

        // O método .nextLine() lê uma string
        System.out.print("Digite o seu nome: ");
        name = sc.nextLine();
        System.out.print("Digite a sua idade: ");
        age = sc.nextLine();
        System.out.print("Digite o seu peso: ");
        weight = sc.nextLine();
        System.out.print("Digite a sua altura: ");
        height = sc.nextLine();
        // Exibe os resultados
        System.out.printf("Name: %s\nAge: %s\nWeight: %s\nHeight: %s\n", name, age, weight, height);
        // Fecha a conexão com o objeto
        sc.close();
    }
}
```

Todos os valores digitados e armazenados nas variáveis são do tipo String.

A diferença entre os métodos next() e nextLine() é que o método next() lê apenas a primeira coisa digitada no 
terminal, ja o método nextLine() lê tudo que for digitado.


[Voltar](../README.md)