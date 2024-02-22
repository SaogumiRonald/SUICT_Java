import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        DBProduct dbProduct = new DBProduct(new ArrayList<>());
        Cart cart = new Cart();
        OrderHistory orderHistory = new OrderHistory();

        Category category1 = new Category(1, "Category 1");
        Category category2 = new Category(3, "Category 2");
        Category category3 = new Category(3, "Category 3");

        Product product1 = new Product(1, "Product 1", 99.99, "Description 1", category1);
        Product product2 = new Product(2, "Product 2", 69.99, "Description 2", category2);
        Product product3 = new Product(3, "Product 3", 19.99, "Description 3", category3);
        Product product4 = new Product(4, "Product 3", 19.99, "Description 4", category3);
        Product product5 = new Product(5, "Product 3", 19.99, "Description 5", category3);

        dbProduct.addProduct(product1);
        dbProduct.addProduct(product2);
        dbProduct.addProduct(product3);
        dbProduct.addProduct(product4);
        dbProduct.addProduct(product5);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nВиберіть опцію:");
            System.out.println("1 - Переглянути список товарів;");
            System.out.println("2 - Додати товар до кошика;");
            System.out.println("3 - Видалити товар з кошика;");
            System.out.println("4 - Переглянути кошик;");
            System.out.println("5 - Зробити замовлення;");
            System.out.println("6 - Пошук товару;");
            System.out.println("7 - Переглянути історію замовлень;");
            System.out.println("0 - Вийти.");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    for (Product product : dbProduct.getProducts()){
                        System.out.println(product);
                    }
                    break;
                case 2:
                    System.out.println("Введіть ID товару для додавання до кошика:");
                    int id = scanner.nextInt();
                    boolean isAdded = false;
                    for (Product product : dbProduct.getProducts()){
                        if (product.getId() == id){
                            cart.addProduct(product);
                            isAdded = true;
                            break;
                        }
                    }
                    if (!isAdded) {
                        System.out.println("Товар з таким ID не знайдено");
                    }
                    break;
                case 3:
                    System.out.println("Введіть ID товару для видалення з кошика:");
                    int removeId = scanner.nextInt();
                    boolean isRemoved = false;
                    for (Product product : dbProduct.getProducts()){
                        if (product.getId() == removeId){
                            cart.removeProduct(product);
                            isRemoved = true;
                            break;
                        }
                    }
                    if (!isRemoved) {
                        System.out.println("Товар з таким ID не знайдено");
                    }
                    break;
                case 4:
                    System.out.println(cart);
                    break;
                case 5:
                    if (cart.getProducts().isEmpty()) {
                        System.out.println("Кошик порожній. Додайте товари перед оформленням замовлення.");
                    } else {
                        Order order = new Order(cart);
                        orderHistory.addOrder(order);
                        System.out.println("Замовлення № " + Order.getId() + " оформлено:");
                        System.out.println(order);
                        cart.clear();
                    }
                    break;
                case 6:
                    System.out.println("Оберіть пошук за назвою товару (1) або категорії (2): ");
                    int searchType;
                    boolean isSearchTypeCorrect = false;
                    do {
                        searchType = scanner.nextInt();
                        if (searchType == 1 || searchType == 2){
                            isSearchTypeCorrect = true;
                        } else {
                            System.out.println("Невідома опція. Спробуйте ще раз.");
                        }
                    } while (!isSearchTypeCorrect);

                    if (searchType == 1){
                        boolean isItemNameCorrect = false;
                        System.out.println("Введіть назву товару: ");
                        do {
                            String itemName = scanner.nextLine();
                            if (!itemName.isEmpty()){
                                System.out.println(dbProduct.searchByItemName(itemName));
                                isItemNameCorrect = true;
                            }
                        } while (!isItemNameCorrect);

                        if (isItemNameCorrect) {
                            System.out.println("Товару з даною назвою не знайдено");
                        }
                    } else if (searchType == 2) {
                        boolean isCategoryCorrect = false;
                        System.out.println("Введіть категорію товару: ");
                        do {
                            String categoryName = scanner.nextLine();
                            if (!categoryName.isEmpty()){
                                System.out.println(dbProduct.searchByCategory(categoryName));
                                isCategoryCorrect = true;
                            }
                        } while (!isCategoryCorrect);

                        if (isCategoryCorrect) {
                            System.out.println("Товарів даної категорії не знайдено");
                        }
                    } else {
                        System.out.println("Невідома опція. Спробуйте ще раз.");
                    }
                    break;
                case 7:
                    orderHistory.printOrderHistory();
                    break;
                case 0:
                    System.out.println("Дякуємо, що використовували наш магазин!");
                    return;
                default:
                    System.out.println("Невідома опція. Спробуйте ще раз.");
            }
        }
    }
}