import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cinema cinema = new Cinema(5, 10, 20);

        int[] seatsToBook = {2, 3, 4};
        cinema.bookSeats(1, 3, seatsToBook);
        cinema.bookSeats(1, 2, new int[]{7, 8, 13, 15});

        cinema.printSeatingArrangement(1);

        cinema.cancelBooking(1, 3, seatsToBook);

        cinema.printSeatingArrangement(1);

        boolean available = cinema.checkAvailability(1, 1, 3);
        System.out.println("Доступність 3 місць в залі 1: " + available);

        cinema.printSeatingArrangement(1);

        List<int[]> bestAvailableSeats = cinema.findBestAvailable(1, 3);
        System.out.println("Найкращі доступні місця у залі 1 для 3 осіб: " + bestAvailableSeats);

        cinema.autoBook(1, 3);

        cinema.printSeatingArrangement(1);
    }
}
