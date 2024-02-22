import java.util.ArrayList;
import java.util.List;

public class DBProduct {
    private List<Product> products;

    void addProduct(Product product) {
        products.add(product);
    }

    void removeProduct(Product product) {
        products.remove(product);
    }

    Product getProductByName(String name){
        for (Product product : products){
            if (product.getName().equals(name)){
                return product;
            }
        }
        return null;
    }

    public List<Product> searchByItemName(String itemName) {
        List<Product> foundProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(itemName)) {
                foundProducts.add(product);
            }
        }
        return foundProducts;
    }

    public List<Product> searchByCategory(String category) {
        List<Product> foundProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().getName().equalsIgnoreCase(category)) {
                foundProducts.add(product);
            }

        }
        return foundProducts;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public DBProduct(List<Product> products) {
        this.products = products;
    }
}
