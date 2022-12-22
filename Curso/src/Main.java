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