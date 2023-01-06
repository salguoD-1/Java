package util;

public class CurrencyConverter {
    // Membro estático pois o resultado só depende do valor passado.
    public static double currencyConverter(double dolarPrice, double bought) {
        return dolarPrice * bought * 1.06;
    }
}
