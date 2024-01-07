import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CinemaTest {
    Cinema cinema;

    @BeforeEach
    void setUp() {
        cinema = new Cinema(5, 10, 20);
    }

    @Test
    void bookSeats_availableSeats() {
        cinema.bookSeats(1, 3, new int[] {1, 2});

        assertTrue(cinema.isSeatBooked(1, 3, 1));
        assertTrue(cinema.isSeatBooked(1, 3, 2));
        assertFalse(cinema.isSeatBooked(1, 3, 3));
    }

    @Test
    void bookSeats_notAvailableSeats() {
        assertThrows(Exception.class, () -> cinema.bookSeats(1000, 1000, new int[] {1000}));
    }

    @Test
    void cancelBooking_bookedSeats() {
        cinema.bookSeats(1, 1, new int[] {1});
        assertTrue(cinema.isSeatBooked(1,1, 1));

        cinema.cancelBooking(1, 1, new int[] {1});
        assertFalse(cinema.isSeatBooked(1, 1, 1));
    }

    @Test
    void CheckAvailability_AvailableSeats() {
        int hallNumber = 0;
        int row = 1;
        int numSeats = 5;
        cinema.bookSeats(hallNumber, row, new int[]{0, 10});

        var actual = cinema.checkAvailability(hallNumber, row, numSeats);

        assertTrue(actual);
    }

    @Test
    void CheckAvailability_UnavailableSeats() {
        int hallNumber = 0;
        int row = 0;
        cinema.bookSeats(hallNumber, row, new int[]{0, 5, 10, 15});

        var actual = cinema.checkAvailability(hallNumber, row, 10);

        assertFalse(!actual);
    }

    @Test
    void testPrintSeatingArrangement() {
        int hallNumber = 0;
        int row = 0;
        cinema.bookSeats(hallNumber, row, new int[]{0, 5, 10, 15});

        assertDoesNotThrow(() -> cinema.printSeatingArrangement(0));
    }

    @Test
    void autoBook_withRequiredBookedSeats() {
        cinema.bookSeats(1, 2, new int[]{5, 6});

        boolean booked = cinema.autoBook(1, 4);

        assertTrue(booked);

        assertTrue(cinema.isSeatBooked(1, 2, 5));
        assertTrue(cinema.isSeatBooked(1, 2, 6));
    }

    @Test
    void autoBook_withoutBookedSeats() {
        cinema.bookSeats(1, 2, new int[]{5, 6});

        boolean booked = cinema.autoBook(1, 4);

        assertTrue(booked);

        assertFalse(cinema.isSeatBooked(1, 2, 7));
        assertFalse(cinema.isSeatBooked(1, 3, 9));
    }
}