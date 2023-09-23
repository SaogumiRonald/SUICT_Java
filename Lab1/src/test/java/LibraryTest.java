import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    private Library library;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();


    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        library = new Library();
        System.setOut(new PrintStream(outputStream));
    }

    @org.junit.jupiter.api.Test
    void testAddBook() {
        Book book1 = new Book("Book 1", "Author 1", "5394896315483", 2016);
        Book book2 = new Book("Book 2", "Author 2", "1489637524183", 2017);

        library.addBook(book1);
        assertEquals(1, library.getBookList().size());
        library.addBook(book2);
        assertEquals(2, library.getBookList().size());
    }

    @org.junit.jupiter.api.Test
    void testShowBookList() {
        Book book1 = new Book("Book 1", "Author 1", "5394896315483", 2016);
        Book book2 = new Book("Book 2", "Author 2", "1489637524183", 2017);

        library.addBook(book1);
        library.addBook(book2);

        library.showBookList();
        String expected = "Title: " + book1.getTitle() + ", author: " + book1.getAuthor() + ", isbn: " + book1.getIsbn() + ", year of publication: " + book1.getYearOfPublication() + "\n" +
                           "Title: " + book2.getTitle() + ", author: " + book2.getAuthor() + ", isbn: " + book2.getIsbn() + ", year of publication: " + book2.getYearOfPublication();
        assertEquals(expected, outputStream.toString().trim().replace("\r", ""));
    }

    @org.junit.jupiter.api.Test
    void findBook() {
        Book book1 = new Book("Book 1", "Author 1", "5394896315483", 2016);

        library.addBook(book1);

        Book expected1 =  library.findBook("Book 1");
        assertEquals(expected1, book1);

        Book expected2 =  library.findBook("book 1");
        assertEquals(expected2, book1);

        Book expected3 =  library.findBook("Nothing");
        assertEquals(expected3, null);
    }

    @org.junit.jupiter.api.Test
    void deleteBook() {
        Book book1 = new Book("book1", "author1", "5394896315483", 2016);
        Book book2 = new Book("book2", "author2", "1489637524183", 2017);

        library.addBook(book1);
        library.addBook(book2);
        assertEquals(2, library.getBookList().size());

        library.deleteBook(book1);
        assertEquals(1, library.getBookList().size());

        library.deleteBook(book1);
        assertEquals(1, library.getBookList().size());
    }
}