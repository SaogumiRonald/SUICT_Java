import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DVDTest {
    DVD dvd;

    @BeforeEach
    void setUp(){
        dvd = new DVD("DVD 1", "1", false, 180);
    }

    @Test
    void borrowItem() {
        assertFalse(dvd.isBorrowed());
        dvd.setBorrowed(true);
        assertTrue(dvd.isBorrowed());
    }

    @Test
    void returnItem() {
        dvd.setBorrowed(true);
        assertTrue(dvd.isBorrowed());
        dvd.setBorrowed(false);
        assertFalse(dvd.isBorrowed());
    }
}