# Entrada de dados em Java

## Classe Scanner
Para realizar a entrada de dados(input) é necessário criar um objeto(instância) do tipo Scanner, vejamos:

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    }
}
```

Note que criamos uma instância(objeto) da classe Scanner e passamos System.in como argumento, isso significa dizer que queremos a entrada de dados.
