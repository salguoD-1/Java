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

#### Sobreposição ou sobrescrita

1. É a implementação de um método de uma superclasse na subclasse
2. É fortemente recomendável usar a
   anotação @Override em um método
   sobrescrito
   1. Facilita a leitura e compreensão do
      código
   2. Avisamos ao compilador (boa prática)

![](images/sobreposicao.PNG)

Na foto acima temos que a subclasse(SavingsAccount) sobrepõe o método withdraw.

Exemplo:

Suponha que a operação de
saque possui uma taxa no valor
de 5.0. Entretanto, se a conta
for do tipo poupança, esta taxa
não deve ser cobrada.
Como resolver isso?

Resposta: sobrescrevendo o
método withdraw na subclasse
SavingsAccount

#### Classe SavingsAccount

````java
package newentities;

public class SavingsAccount extends Account {
    private Double interestRate;

    public SavingsAccount() {
        super();
    }

    public SavingsAccount(Integer number, String holder, Double balance, Double interestRate) {
        super(number, holder, balance);
        this.interestRate = interestRate;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public void updateBalance() {
        balance += balance * interestRate;
    }

    // Sobreposição do método withdraw da classe Account
    @Override
    public void withdraw(Double amount) {
        balance -= amount;
    }
}

````

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
        balance -= amount + 5;
    }

    // Deposito
    public void deposit(Double amount) {
        balance += amount;
    }
}
````

#### Classe Program

````java
package newapplication;

import newentities.Account;
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

    }
}
````

Note que na classe SavingsAccount nós realizamos a sobreposição do método withdraw, que nesse caso não desconta 5 
reais. Para isso usamos a anotação @Override.

### Palavra super

1. É possível chamar a implementação da superclasse usando a palavra super.

Exemplo: suponha que, na classe BusinessAccount, a regra para saque seja realizar o
saque normalmente da superclasse, e descontar mais 2.0.

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

    // Reutiliza o código da superclasse
    @Override
    public void withdraw(Double amount) {
        // Faz uso do método withdraw da superclasse Account
        super.withdraw(amount);
        // Desconto mais dois (5 + 2) = 7
        balance -= 2.0;
    }
}
````

No exemplo acima usamos a palavra-chave super que acessa o método withdraw da superclasse Account para realizar a 
aplicação original do método e em seguida, atribuimos uma taxa de 2.0 a mais no método da superclasse.

## Classes e métodos final

1. Classe: evita que a classe seja herdada
````java
public final class SavingsAccount {}
````
2. Método: evita que o método seja sobreposto

Exemplo - Classe final:

Suponha que você queira evitar que
sejam criadas subclasses de
SavingsAccount

````java
public final class SavingsAccount {}
````

![](images/finalclass.PNG)

Dessa forma não é possível criar uma subclasse de SavingsAccount como é o caso da SavingsAccountPlus

Exemplo - Método final:

Suponha que você não queira que o método Withdraw de
SavingsAccount seja sobreposto

````java
@Override
public final void withdraw(Double amount) {
    balance -= amount;
}
````

### Mas pra que usar a palavra-chave final?

1. Suponha que você não queira que o método Withdraw de
   SavingsAccount seja sobreposto
   1. Geralmente convém acrescentar final em métodos sobrepostos, pois
      sobreposições múltiplas podem ser uma porta de entrada para
      inconsistências
2. Performance: atributos de tipo de uma classe final são analisados de
   forma mais rápida em tempo de execução.
   1. Exemplo clássico: String

## Introdução ao Polimorfismo

#### Pilares da OOP

1. Encapsulamento
2. Herança
3. Polimorfismo

Em Programação Orientada a Objetos, polimorfismo é recurso que
permite que variáveis de um mesmo tipo mais genérico possam
apontar para objetos de tipos específicos diferentes, tendo assim
comportamentos diferentes conforme cada tipo específico.

![](images/poliex.PNG)

No exemplo acima temos que a variável x irá armazenar a referência para o objeto Account, ja a variável y irá 
armazenar uma referência para o objeto SavingsAccount

NOTA:
1. A associação do tipo específico com o tipo genérico é feita em tempo de
   execução (upcasting).
````java
Account x = new Account(1020, "Alex", 1000.0);
// Upcasting
Account y = new SavingsAccount(1023, "Maria", 1000.0, 0.01);
x.withdraw(50.0);
// O compilador só saberá qual 
// método usar durante o tempo de execução
y.withdraw(50.0);
````
2. O compilador não sabe para qual tipo específico a chamada do método
   Withdraw está sendo feita (ele só sabe que são duas variáveis tipo Account):

[Voltar](../README.md)

