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
