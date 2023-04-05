# Enumerações e Composição

1. É um tipo especial que serve para especificar de forma literal um conjunto de constantes relacionadas
2. Palavra chave em Java: enum
3. Vantagem: melhor semântica, código mais legíviel e auxiliado pelo compilador

## Exemplo de uso de Enum

1. Pacote entities.enums que possui um enum chamado OrderStatus

````java
// Pacote
package entities.enums;

// Tipo enum
public enum OrderStatus {
    // Constantes relacionadas
    PENDING_PAYMENT,
    PROCESSING,
    SHIPPED,
    DELIVERED
}
````

2. Classe Order que é responsável pelo pedido
````java
// Pacote raiz
package entities;
// Pacote onde o enum se encontra
import entities.enums.OrderStatus;
// Necessário para usar a classe Date
import java.util.Date;

public class Order {
    // Atributos
    private Integer id;
    private Date moment;
    // "Instanciamos" o enum e colocamos a referência na variável status
    private OrderStatus status;

    // Construtor vazio
    public Order() {

    }
    
    // Construtor que inicializa todos os atributos
    public Order(Integer id, Date moment, OrderStatus status) {
        this.id = id;
        this.moment = moment;
        this.status = status;
    }

    // getters e setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    // Retorna o resultado dos atributos
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", moment=" + moment +
                ", status=" + status +
                '}';
    }
}
````

3. Classe AppOrder que instancia um objeto da classe Order

````java
package application;

import entities.Order;
import entities.enums.OrderStatus;

import java.util.Date;

public class AppOrder {
    public static void main(String[] args) {
        // Instaciamos um objeto da classe Order e inicializamos usando o construtor
        Order order = new Order(1080, new Date(), OrderStatus.PENDING_PAYMENT);
        
        // Exibe o resultado formatado
        System.out.println(order);
    }
}
````

## Conversão de String para enum

````java
package application;

import entities.Order;
import entities.enums.OrderStatus;

import java.util.Date;

public class AppOrder {
    public static void main(String[] args) {
        Order order = new Order(1080, new Date(), OrderStatus.PENDING_PAYMENT);

        System.out.println(order);

        // Instancia de um objeto do tipo OrderStatus com valor DELIVERED setado
        OrderStatus os1 = OrderStatus.DELIVERED;
        // O método valueOf transforma uma String em um enum
        OrderStatus os2 = OrderStatus.valueOf("DELIVERED");

        System.out.println(os1);
        System.out.println(os2);
    }
}
````

## Notação UML

1. Cada constante do tipo enum é enumerada a partir do 0

![](images/enum.PNG)