package newapplication;

import newentities.Account;
import newentities.BusinessAccount;
import newentities.SavingsAccount;

public class Program {
    public static void main(String[] args) {
        Account acc = new Account(1001, "Douglas", 0.0);
        BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.0);

        // UPCASTING

        // Uma BusinessAccount é uma Account, logo podemos atribuir a subclasse à superclasse.
        Account acc1 = bacc;

        // Outro exemplo
        // Como uma BusinessAccount é uma Account, podemos realizar um upcasting na BusinessAccount.
        Account acc2 = new BusinessAccount(1003, "Bob", 0.0, 200.0);
        Account acc3 = new SavingsAccount(1004, "Anna", 0.0, 0.01);

        // DOWNCASTING

        // É necessário fazer o casting para realizar o downcasting.
        BusinessAccount acc4 = (BusinessAccount) acc2;

        // Analisa se o objeto acc3 é uma instância da classe BusinessAccount
        // Como acc3 não é uma instância de BusinessAccount, não será executado.
        if (acc3 instanceof BusinessAccount) {
            BusinessAccount acc5 = (BusinessAccount) acc3;
            acc5.loan(200.0);
            System.out.println("Loan!");
        }

        // acc3 é uma instância de SavingsAccount, logo será executado.
        if (acc3 instanceof SavingsAccount) {
            SavingsAccount acc5 = (SavingsAccount) acc3;
            acc5.updateBalance();
            System.out.println("Update!");
        }
    }
}
