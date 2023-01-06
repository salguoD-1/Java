package application;

import util.Calculator;
import util.CurrencyConverter;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        // Permite utilizar ponto no lugar de vírgula.
        Locale.setDefault(new Locale("en", "US"));
        // Criamos dois objetos, sc e product
        Scanner sc = new Scanner(System.in);

        double dolarPrice;
        double dolarBought;
        System.out.print("What is the dollar price? ");
        dolarPrice = sc.nextDouble();
        System.out.print("How many dollars will be bought? ");
        dolarBought = sc.nextDouble();

        System.out.printf("Amount to be paid in reais = %.2f%n", CurrencyConverter.currencyConverter(dolarPrice, dolarBought));
    }
}