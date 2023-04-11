package newentities;

// A classe BusinessAccount herda todos os dados e comportamentos da classe Account
public class BusinessAccount extends Account {
    private Double loanLimit;

    public BusinessAccount() {

    }

    // Reaproveitamos o construtor da classe Account
    public BusinessAccount(Integer number, String holder, Double balance, Double loanLimit) {
        // Super serve para "chamar" o construtor da super classe(Account)
        super(number, holder, balance);
        this.loanLimit = loanLimit;
    }

    public Double getLoanLimit() {
        return loanLimit;
    }

    public void setLoanLimit(Double loanLimit) {
        this.loanLimit = loanLimit;
    }

    public void loan(double amount) {
        if (amount <= loanLimit) {
            // balance tem visibilidade protected
            balance += amount - 10.0;
        }
    }
}
