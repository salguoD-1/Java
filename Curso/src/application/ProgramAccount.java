package application;

import entities.Account;

import java.util.Locale;
import java.util.Scanner;

public class ProgramAccount {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("en", "US"));
        Scanner sc = new Scanner(System.in);
        Account account;
        int accountNumber;
        String accountHolder;
        char initialDeposity;
        double accountBalance;

        System.out.print("Enter account number: ");;
        accountNumber = sc.nextInt();

        // limpa o buffer do teclado
        sc.nextLine();

        System.out.print("Enter account holder: ");
        accountHolder = sc.nextLine();

        System.out.print("Is there an initial deposity (y/n): ");
        initialDeposity = sc.next().toLowerCase().charAt(0);

        // Analisa se o usuário quer fazer um depósito opcional
        if (initialDeposity == 'y') {
            System.out.print("Enter initial deposit value: ");
            accountBalance = sc.nextDouble();
            // Instânciamos a classe usando o construtor de três argumentos
            account = new Account(accountNumber, accountHolder, accountBalance);
        } else {
            // Instânciamos a classe usando o construtor de dois argumentos
            account = new Account(accountNumber, accountHolder);
        }

        System.out.println("\nAccount data: ");
        System.out.println(account);

        System.out.print("\nEnter a deposit value: ");
        accountBalance = sc.nextDouble();
        account.deposit(accountBalance);
        System.out.println("Updated account data: ");
        System.out.println(account);

        System.out.print("\nEnter a withdraw value: ");
        accountBalance = sc.nextDouble();
        account.withdraw(accountBalance);
        System.out.println("\nUpdated account data: ");
        System.out.println(account);

        sc.close();
    }
}
