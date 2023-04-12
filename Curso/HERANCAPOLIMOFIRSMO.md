# Herança e Polimorfismo

## Herança

1. É um tipo de associação que permite que uma classe herde todos dados e comportamentos de outra
2. Definições importantes
3. Vantagens
    1. Reuso
   2. Polimorfismo
4. Sintaxe
    1. class A extends B

    
#### Exemplo

Suponha um negócio de banco que possui uma conta comum e uma conta para
empresas, sendo que a conta para empresa possui todos membros da conta
comum, mais um limite de empréstimo e uma operação de realizar empréstimo.

![](images/exheranca.PNG)

#### A herança é representada da seguinte forma na UML

![](images/herancauml.PNG)

A seta que liga a classe BusinessAccount herda todos os dados e comportamentos da classe Account. Além disso, a 
classe BusinessAccount possui seus próprios métodos e atributos.

#### Classe Account

````java
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
        balance -= amount;
    }

    // Deposito
    public void deposit(Double amount) {
        balance += amount;
    }
}
````

#### Classe BusinessAccount

````java
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
````

No exemplo acima usamos o modificador de acesso protected na classe Account com o atributo balance, dessa forma 
permitimos que o atributo balance seja acessado por subclasses do mesmo pacote ou em pacotes diferentes.

## Definições importantes
![](images/herancadefinicoes.PNG)

1. Relação "é-um"
   1. Significa dizer que a classe BusinessAccount é uma Account pois tem tudo que a classe Account tem só que com 
      algumas modificações.
2. Generalização/Especialização
   1. A classe Account é chamada de Generalização, pois é o tipo mais generico que temos. A classe BusinessAccount é 
      uma especialização da classe Account.
3. Superclasse(classe base ou classe mãe) Subclasse(classe derivada ou classe filha)
4. Herança é uma associação entre classes(e não entre objetos).

## Upcasting e Downcasting

![](images/upcastingdowncasting.PNG)

### Exemplo do uso de Upcasting e Downcasting
![](images/updownex.PNG)

````java
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
````

Acima temos a aplicação do upcasting e downcasting. Note que no upcasting nós atribuimos um objeto ao outro, ou 
atribuimos uma instância de outra classe(subclasse) a um objeto de uma superclasse.

Já no downcasting, é necessário atribuir o tipo que queremos "converter", como foi o caso do objeto acc2 que foi 
convertido para o tipo BusinessAccount. Para analisar se um objeto é uma instância de uma classe qualquer, podemos 
utilizar a palavra-chave `instaceof` dentro de um if, e analisar se o objeto é uma instância de determinada classe.

## Sobreposição, palavra super, anotação @Override

[Voltar](../README.md)

