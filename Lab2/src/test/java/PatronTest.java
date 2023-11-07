import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class PatronTest {
    Patron patron;
    List<Item> borrowedItems;
    Book book;

    @BeforeEach
    void setUp(){
        borrowedItems = new ArrayList<>();
        patron = new Patron("Name 1", "1", borrowedItems);
        book = new Book("Book 1", "1", false, "Author 1");
    }

    @Test
    void borrowItemTest() {
        patron.borrowItem(book);
        assertEquals(1, patron.getBorrowedItems().size());
        assertTrue(book.isBorrowed());
    }

    @Test
    void returnItem() {
        patron.borrowItem(book);
        assertEquals(1, patron.getBorrowedItems().size());
        assertTrue(book.isBorrowed());

        patron.returnItem(book);
        assertEquals(0, patron.getBorrowedItems().size());
        assertFalse(book.isBorrowed());
    }
}