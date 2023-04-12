package newapplication;

import newentities.ImportedProduct;
import newentities.Product;
import newentities.UsedProduct;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ProgramProduct {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        List<Product> listProduct = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int totalProducts = sc.nextInt();

        for (int i = 1; i <= totalProducts; i++) {
            System.out.println("Product #" + i + " data:");
            // c/u/i = comum, usado e importado
            System.out.print("Common, used or imported (c/u/i)? ");
            char ch = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Price: ");
            double price = sc.nextDouble();

            if (ch == 'i') {
                System.out.print("Custom fee: ");
                double customFee = sc.nextDouble();
                Product product = new ImportedProduct(name, price, customFee);
                listProduct.add(product);
            } else if (ch == 'u') {
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                Product product = new UsedProduct(name, price, date);
                listProduct.add(product);
            } else if (ch == 'c') {
                Product product = new Product(name, price);
                listProduct.add(product);
            }
        }

        System.out.println();
        System.out.println("PRICE TAGS: ");
        for (Product product : listProduct) {
            System.out.println(product.priceTag());
        }

        sc.close();
    }
}
