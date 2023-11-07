import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    Book book;

    @BeforeEach
    void setUp(){
        book = new Book("Book 1", "1", false, "Author 1");
    }

    @Test
    void borrowItemTest() {
        assertFalse(book.isBorrowed());
        book.setBorrowed(true);
        assertTrue(book.isBorrowed());
    }

    @Test
    void returnItemTest() {
        book.setBorrowed(true);
        assertTrue(book.isBorrowed());
        book.setBorrowed(false);
        assertFalse(book.isBorrowed());
    }
}