import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Book 1", "1", false, "Author 1");
        Book book2 = new Book("Book 2", "2", false, "Author 2");
        Book book3 = new Book("Book 3", "3", false, "Author 3");

        DVD dvd1 = new DVD("DVD 1", "4", false, 60);
        DVD dvd2 = new DVD("DVD 2", "5", false, 90);
        DVD dvd3 = new DVD("DVD 3", "6", false, 120);

        List<Item> items = new ArrayList<Item>();
        List<Patron> patrons = new ArrayList<Patron>();

        Library library = new Library(items, patrons);

        library.add(book1);
        library.add(book2);
        library.add(book3);

        library.add(dvd1);
        library.add(dvd2);
        library.add(dvd3);

        System.out.println(library.getItems());

        System.out.println("\n=========================\n");

        library.listAvailable();

        System.out.println("\n=========================\n");

        List<Item> patrons1BorrowedItems = new ArrayList<Item>();
        Patron patron1 = new Patron("Patron 1", "1", patrons1BorrowedItems);
        List<Item> patrons2BorrowedItems = new ArrayList<Item>();
        Patron patron2 = new Patron("Patron 2", "2", patrons2BorrowedItems);
        List<Item> patrons3BorrowedItems = new ArrayList<Item>();
        Patron patron3 = new Patron("Patron 3", "3", patrons3BorrowedItems);

        library.registerPatron(patron1);
        library.registerPatron(patron2);
        library.registerPatron(patron3);

        System.out.println(library.getPatrons());

        System.out.println("\n=========================\n");

        library.lendItem(patron1, book1);
        library.lendItem(patron2, book2);
        library.lendItem(patron3, book3);

        patron1.borrowItem(dvd1);
        patron2.borrowItem(dvd2);
        patron3.borrowItem(dvd3);

        System.out.println(patron1.getBorrowedItems());
        System.out.println(patron2.getBorrowedItems());
        System.out.println(patron3.getBorrowedItems());

        System.out.println("\n=========================\n");

        library.listBorrowed();

        System.out.println("\n=========================\n");

        library.returnItem(patron1, book1);
        library.returnItem(patron2, book2);
        library.returnItem(patron3, book3);

        patron1.returnItem(dvd1);
        patron2.returnItem(dvd2);
        patron3.returnItem(dvd3);

        library.listAvailable();

        System.out.println("\n=========================\n");

        library.remove(book1);
        library.remove(book2);
        library.remove(book3);

        System.out.println(library.getItems());
    }
}
