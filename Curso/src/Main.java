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