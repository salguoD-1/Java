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