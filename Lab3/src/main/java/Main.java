public class Main {
    public static void main(String[] args) {
        Product product1 = new Product(1, "iPhone 13", 799.0);
        Product product2 = new Product(2, "iPhone 14 Pro", 1050.0);

        Cart cart = new Cart();
        cart.addProduct(product1);
        cart.addProduct(product2);

        cart.removeProduct(product1);

        Order order = new Order(1, cart.getProducts());

        Order.Status orderStatus = order.getStatus();
        System.out.println("Order status: " + orderStatus);
    }
}