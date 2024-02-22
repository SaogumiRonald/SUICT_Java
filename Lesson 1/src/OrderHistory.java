import java.util.ArrayList;
import java.util.List;

class OrderHistory {
    private List<Order> orders;

    public OrderHistory() {
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void printOrderHistory() {
        System.out.println("Історія замовлень:");
        for (Order order : orders) {
            for (Product product : order.getProducts()) {
                System.out.println("Id замовлення: " + order.getId() + ", товари: " + order.getProducts() + ", вартість: " + order.getTotalPrice());
            }
        }
    }
}