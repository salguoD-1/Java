package entities;

import entities.enums.OrderStatus1;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order1 {
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private Date moment = new Date();
    private OrderStatus1 status;
    private Client client;
    private List<OrderItem> items = new ArrayList<>();


    public Order1() {

    }

    public Order1(Date moment, OrderStatus1 status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus1 getStatus() {
        return status;
    }

    public void setStatus(OrderStatus1 status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    // Não se usa!
//    public List<OrderItem> getItems() {
//        return items;
//    }

    // Não se usa!
//    public void setItems(List<OrderItem> items) {
//        this.items = items;
//    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void removeItem(OrderItem item) {
        items.remove(item);
    }

    public double total() {
        double sum = 0;

        // Delegamos o cálculo para o método subTotal()
        for (OrderItem it : items) {
            sum += it.subTotal();
        }

        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order moment: ");
        sb.append(sdf.format(moment) + "\n");
        sb.append("Order status: ");
        sb.append(status + "\n");
        sb.append("Client: ");
        sb.append(client + "\n");
        sb.append("Order items: ");
        for (OrderItem item: items) {
            sb.append(item + "\n");
        }
        sb.append("Total price: $");
        sb.append(String.format("%.2f", total()));
        return sb.toString();
    }
}
