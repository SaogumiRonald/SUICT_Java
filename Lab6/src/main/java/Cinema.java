import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private final int halls;
    private final int rows;
    private final int seats;
    final int[][][] cinemaData;

    public Cinema(int halls, int rows, int seats) {
        this.halls = halls;
        this.rows = rows;
        this.seats = seats;

        cinemaData = new int[halls][rows][seats];
    }

    public void bookSeats(int hallNumber, int row, int[] seats){
        for (int seat : seats) {
            if (cinemaData[hallNumber][row][seat] == 1) {
                System.out.println("Місце " + seat + " в ряду " + row + " у залі " + hallNumber + " вже заброньоване.");
            } else {
                cinemaData[hallNumber][row][seat] = 1;
                System.out.println("Місце " + seat + " в ряду " + row + " у залі " + hallNumber + " успішно заброньоване.");
            }
        }
    }

    public void cancelBooking(int hallNumber, int row, int[] seats){
        for (int seat : seats) {
            if (cinemaData[hallNumber][row][seat] == 0) {
                System.out.println("Місце " + seat + " в ряду " + row + " у залі " + hallNumber + " вже вільне.");
            } else {
                cinemaData[hallNumber][row][seat] = 0;
                System.out.println("Скасовано бронювання для місця " + seat + " в ряду " + row + " у залі " + hallNumber + ".");
            }
        }
    }

    public boolean checkAvailability(int hallNumber, int row, int numSeats){
        for (; row < cinemaData[hallNumber].length; row++) {
            for (int seat = 0; seat <= cinemaData[hallNumber][row].length - numSeats; seat++) {
                boolean available = true;
                for (int i = 0; i < numSeats; i++) {
                    if (cinemaData[hallNumber][row][seat + i] == 1) {
                        available = false;
                        break;
                    }
                }

                if (available) {
                    return true;
                }
            }
        }

        return false;
    }

    public void printSeatingArrangement(int hallNumber) {
        final String ANSI_NONE = "\u001B[0m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_BLACK_BG = "\u001B[40m";
        final String ANSI_YELLOW_BG = "\u001b[43m";
        System.out.println("Схема розміщення місць для залу " + hallNumber + ":");

        System.out.print("\t");
        for (int seat = 0; seat < cinemaData[hallNumber][0].length; seat++) {
            System.out.print((seat + 1) + "\t");
        }
        System.out.println();

        for (int row = 0; row < cinemaData[hallNumber].length; row++) {
            System.out.print((row + 1) + "|\t");

            for (int seat = 0; seat < cinemaData[hallNumber][row].length; seat++) {
                String seatText = (cinemaData[hallNumber][row][seat] == 0) ? "O\t" : "1\t";
                String textColor = (cinemaData[hallNumber][row][seat] == 0) ? ANSI_GREEN : ANSI_RED;
                String backgroundColor = (cinemaData[hallNumber][row][seat] == 0) ? ANSI_BLACK_BG : ANSI_YELLOW_BG;

                System.out.print(textColor + backgroundColor + seatText + " " + ANSI_NONE);
            }
            System.out.println();
        }
            System.out.print("\t");
            for (int seat = 0; seat < cinemaData[hallNumber][0].length; seat++) {
                System.out.print((seat + 1) + "\t");
            }
            System.out.println();
    }

    public List<int[]> findBestAvailable(int hallNumber, int numSeats) {
        List<int[]> bestAvailableSeats = new ArrayList<>();

        for (int row = 0; row < cinemaData[hallNumber].length; row++) {
            for (int seat = 0; seat <= cinemaData[hallNumber][row].length - numSeats; seat++) {
                boolean available = true;
                for (int i = 0; i < numSeats; i++) {
                    if (cinemaData[hallNumber][row][seat + i] == 1) {
                        available = false;
                        break;
                    }
                }

                if (available) {
                    int[] seatRange = new int[numSeats];
                    for (int i = 0; i < numSeats; i++) {
                        seatRange[i] = seat + i + 1;
                    }
                    bestAvailableSeats.add(seatRange);
                }
            }
        }

        return bestAvailableSeats;
    }

    public boolean autoBook(int hallNumber, int numSeats) {
        List<int[]> bestAvailableSeats = findBestAvailable(hallNumber, numSeats);

        if (!bestAvailableSeats.isEmpty()) {
            int[] seatsToBook = bestAvailableSeats.get(0);
            bookSeats(hallNumber, seatsToBook[0] - 1, seatsToBook);
            System.out.println("Автоматично заброньовано " + numSeats + " місць у залі " + hallNumber);
            return true;
        } else {
            System.out.println("Нажаль, немає достатньої кількості доступних місць у залі " + hallNumber);
        }
        return false;
    }

    public boolean isSeatBooked(int hallNumber, int row, int seat) {
        return cinemaData[hallNumber][row][seat] == 1;
    }

    private int[][] getHall(int hall){
        return cinemaData[hall];
    }

    private int[] getRow(int hall, int row){
        return cinemaData[hall][row];
    }
}
