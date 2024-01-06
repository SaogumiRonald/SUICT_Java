import java.util.List;

class Order {
    public enum Status{
        CREATED,
        PROCESSED,
        COMPLETED,
        CANCELED
    }

    private int orderId;
    private List<Product> products;
    private Status status;

    public Order(int orderId, List<Product> products) {
        this.orderId = orderId;
        this.products = products;
        this.status = Status.CREATED;
    }

    public int getOrderId() {
        return orderId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}