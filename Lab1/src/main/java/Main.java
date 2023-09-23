public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Book 1", "Author 1", "5394896315483", 2016);
        Book book2 = new Book("Book 2", "Author 2", "1489637524183", 2017);
        Book book3 = new Book("Book 3", "Author 3", "9715486329745", 2018);

        Library library = new Library();
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        library.showBookList();

        library.findBook("Book 1");
        library.deleteBook(book2);
        library.findBook("Book 2");
        library.deleteBook(book2);
    }
}
