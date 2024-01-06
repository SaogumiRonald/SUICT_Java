import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    Product product1;
    Product product2;
    Cart cart;

    @BeforeEach
    public void setUp(){
        product1 = new Product(1, "iPhone 13", 799.0);
        product2 = new Product(2, "iPhone 14 Pro", 1050.0);
        cart = new Cart();
    }

    @Test
    public void testAddProductToCart() {
        cart.addProduct(product1);
        cart.addProduct(product2);

        assertEquals(2, cart.getProducts().size());
    }

    @Test
    public void testRemoveProductFromCart() {
        cart.addProduct(product1);
        cart.addProduct(product2);

        cart.removeProduct(product1);

        assertEquals(1, cart.getProducts().size());
        assertFalse(cart.getProducts().contains(product1));
        assertTrue(cart.getProducts().contains(product2));
    }

    @Test
    public void testCreateOrder() {
        cart.addProduct(product1);
        cart.addProduct(product2);

        Order order = new Order(1, cart.getProducts());
        assertNotNull(order);
    }

    @Test
    public void testGetStatus() {
        cart.addProduct(product1);
        cart.addProduct(product2);

        Order order = new Order(1, cart.getProducts());

        assertNotNull(order);
        assertEquals(Order.Status.CREATED, order.getStatus());
    }
}