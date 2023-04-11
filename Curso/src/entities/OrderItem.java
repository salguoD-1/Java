package entities;

public class OrderItem {
    private Integer quantity;
    private Double price;
    // Composição da classe Product3 com a classe OrderItem
    private Product3 product3;

    public OrderItem() {

    }

    public OrderItem(Integer quantity, Double price, Product3 product3) {
        this.quantity = quantity;
        this.price = price;
        this.product3 = product3;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public double subTotal() {
        return quantity * price;
    }

    public Product3 getProduct3() {
        return product3;
    }

    public void setProduct3(Product3 product3) {
        this.product3 = product3;
    }

    // Retorna os dados formatados
    @Override
    public String toString() {
        return getProduct3().getName()
                + ", $" + String.format("%.2f", getPrice())
                + ", Quantity " + getQuantity()
                + ", Subtotal: $" + String.format("%.2f", subTotal());
    }
}
