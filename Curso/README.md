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

NOTA: Em java temos um problema relacionado a entrada de dados como é o caso em C, quando usamos um método diferente 
do nextLine(), temos que o caractere de quebra de linha `\n` irá ser armazenado na variável seguinte, ou seja, na 
seguinte entrada de dados, vejamos:

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int num;
        String str1, str2, str3;

        Scanner sc = new Scanner(System.in);
        
        // Recebe um valor inteiro
        num = sc.nextInt();
        
        // Recebe valores do tipo string
        str1 = sc.nextLine();
        str2 = sc.nextLine();
        str3 = sc.nextLine();
    }
}
```

Ou seja, quando digitarmos o primeiro valor que é um inteiro temos que a segunda variável irá armazenar o caractere 
de quebra de linha `\n`, isso acaba gerando um problema onde a variável str1 não irá armazenar o valor desejado. 
Para resolver isso basta `limpar o buffer do teclado` usando o método sc.nextLine(). Vejamos:

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int num;
        String str1, str2, str3;

        Scanner sc = new Scanner(System.in);
        
        // Recebe um valor inteiro
        num = sc.nextInt();
        
        // Limpando o buffer do teclado
        sc.nextLine();
        
        // Recebe valores do tipo string
        str1 = sc.nextLine();
        str2 = sc.nextLine();
        str3 = sc.nextLine();

        System.out.println(num);
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
    }
}
```
## Funções Matemáticas

Usamos a API Math do java, vejamos algumas funções matemáticas:

```java
public class Main {
    public static void main(String[] args) {
        double x = 3.0;
        double y = 4.0;
        double z = -5.0;

        System.out.printf("O quadrado de %f é: %f\n", Math.pow(x, 2));
        System.out.printf("A raiz quadrada de %f é: %f\n", Math.sqrt(y));
        System.out.printf("O valor absoluto de %f é: %f\n", Math.abs(z));
    }
}
```
## Outros tópicos básicos sobre Java

### Conveções para nomes

Em java, nós usamos o padrão camelCase para declarar:
- pacotes
- atributos
- métodos
- variáveis e parâmetros

Já para o caso de classes, nós usamos o padrão PascalCase:
```java
class NomeDaClasse {
    // faz algo
}
```

Vejamos um exemplo de código que contém esses dois padrões:

```java
// Pacote
package entities;

// Classe
public class Account {
    // Variáveis
    private String holder;
    private Double balance;
    
    // Métodos
    public Account(String holder, Double balance) {
        this.holder = holder;
        this.balance = balance;
    }
    
    public String getHolder() {
        return holder;
    }
    
    public void deposit(Double amount) {
        balance += amount;
    }
    
    public void withdraw(Double amount) {
        balance -= amount;
    }
}
```

### Funções interessantes para Strings

Java disponibiliza algumas funções bem interessantes para o manuseio de strings:

- Formatar: toLowerCase(), toUpperCase() e trim()
- Recortar: substring(inicio), substring(inicio, fim)
- Substituir: Replace(char, char), Replace(string, string)
- Buscar: IndexOf, LastIndexOf
- str.Split("")

Vejamos alguns exemplos

```java
package course;

public class Program {
    public static void main(String[] args) {
        String original1 = "OI, EU ESTOU EM MAIÚSCULO!";

        // Exibe o resultado convertido para minúsculo
        System.out.println(original1.toLowerCase());

        String original2 = "oi, eu estou em minúsculo!";

        // Exibe o resultado convertido para maiúsculo
        System.out.println(original2.toUpperCase());

        String original3 = "   Oi, eu tenho espaços em branco nas laterais!  ";

        // Exibe o resultado sem os espaços em branco
        System.out.println(original3.trim());

        // Cria uma substring começando no caractere de índice 4
        String original4 = original1.substring(4);
        System.out.println(original4);

        // Cria uma substring começando no índice 4 e terminando no índice 12
        String original5 = original1.substring(4, 12);
        System.out.println(original5);

        // Substituir os caracteres E por X
        String original6 = original1.replace('E', 'X');
        System.out.println(original6);

        // Armazena a posição de determinada frase e exibe o resultado
        int original7 = original1.indexOf("ESTOU");
        System.out.println(original7);

        // A função split() separa uma string em substrings que são armazeandas em arrays
        String s = "Potato Apple Lemon";
        // Armazenamos os três valores no array usando a função split que
        // separa por espaços em branco
        String[] arr = s.split(" ");

        // Exibindo os valores
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
    }
}
```
[Voltar](../README.md)