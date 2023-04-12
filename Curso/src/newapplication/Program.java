package newapplication;

import newentities.Account;
import newentities.BusinessAccount;
import newentities.SavingsAccount;

public class Program {
    public static void main(String[] args) {
        Account acc1 = new Account(1001, "Alex", 1000.0);
        acc1.withdraw(200.0);
        // Retorna 795
        System.out.println(acc1.getBalance());

        // upcasting
        Account acc2 = new SavingsAccount(1002, "Maria", 1000.0, 0.01);
        acc2.withdraw(200.0);
        // Retorna 800
        System.out.println(acc2.getBalance());

        // Usando a palavra super
        Account acc3 = new BusinessAccount(1003, "Douglas", 1000.0, 200.0);
        acc3.withdraw(200.0);
        System.out.println(acc3.getBalance());
    }
}
