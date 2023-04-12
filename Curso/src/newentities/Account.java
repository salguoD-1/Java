package newentities;

public class Account {
    private Integer number;
    private String holder;
    // protected permite o uso em subclasses de packages diferentes
    protected Double balance;

    public Account() {

    }

    public Account(Integer number, String holder, Double balance) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    // Proibido fazer o setBalance manualmente
//    public void setBalance(Double balance) {
//        this.balance = balance;
//    }

    // Saque
    public void withdraw(Double amount) {
        balance -= amount + 5;
    }

    // Deposito
    public void deposit(Double amount) {
        balance += amount;
    }
}
