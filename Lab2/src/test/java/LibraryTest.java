import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    Library library;
    List<Item> borrowedItems;
    List<Patron> patrons;
    Patron patron;
    Book book;
    List<Item> items;
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        borrowedItems = new ArrayList<>();
        patrons = new ArrayList<>();
        patron = new Patron("Alex", "1", borrowedItems);
        items = new ArrayList<>();
        book = new Book("Book 1", "1", false, "Author 1");
        library = new Library(items, patrons);
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testRegisterPatron() {
        library.registerPatron(patron);
        assertEquals(1, library.getPatrons().size());
    }

    @Test
    void testLendItem() {
        library.lendItem(patron, book);
        assertEquals(patron.getBorrowedItems().size(), 1);
        assertTrue(book.isBorrowed());
    }

    @Test
    void testReturnItem() {
        library.lendItem(patron, book);
        assertEquals(patron.getBorrowedItems().size(), 1);
        assertTrue(book.isBorrowed());

        library.returnItem(patron, book);
        assertEquals(patron.getBorrowedItems().size(), 0);
        assertFalse(book.isBorrowed());
    }

    @Test
    void testAdd() {
        library.add(book);
        assertEquals(library.getItems().size(), 1);
    }

    @Test
    void testRemove() {
        library.remove(book);
        assertEquals(library.getItems().size(), 0);
    }

    @Test
    public void testListAvailable() {
        library.add(book);
        String expected = "unique ID: " + book.getUniqueID() + ", title: " + book.getTitle() + ", isBorrowed: " + false + ", author: " + book.getAuthor() + ";";

        library.listAvailable();
        assertEquals(expected, outputStream.toString().trim().replace("\r", ""));
    }

    @Test
    public void testListBorrowed() {
        book.setBorrowed(true);
        library.add(book);
        String expected = "unique ID: " + book.getUniqueID() + ", title: " + book.getTitle() + ", isBorrowed: " + true + ", author: " + book.getAuthor() + ";";

        library.listBorrowed();
        assertEquals(expected, outputStream.toString().trim().replace("\r", ""));
    }
}