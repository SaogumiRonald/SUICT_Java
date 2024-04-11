import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TransactionAnalyzerTest {
    @Test
    public void testReadDataFromCSV() {
        TransactionCSVReader csvReader = new TransactionCSVReader();
        List<Transaction> transactions = csvReader.readTransaction("https://informer.com.ua/dut/java/pr2.csv");
        boolean result = transactions.isEmpty();
        assertFalse(result);
    }

    @Test
    void calculateTotalBalance() {
        Transaction transaction1 = new Transaction("01-01-2023", 100.00, "Дохід");
        Transaction transaction2 = new Transaction("02-02-2023", -100.00, "Витрати");
        Transaction transaction3 = new Transaction("03-03-2023", 150.00, "Дохід");

        List<Transaction> transactions = Arrays.asList(transaction1, transaction2, transaction3);

        TransactionAnalyzer analyzer = new TransactionAnalyzer(transactions);

        double result = analyzer.calculateTotalBalance();

        assertEquals(150.0, result, "Розрахунок загального балансу правильний.");
        assertNotEquals(200.0, result, "Розрахунок загального балансу не правильний.");
    }

    @Test
    void countTransactionByMonth(){
        Transaction transaction1 = new Transaction("01-01-2023", 100.00, "Дохід");
        Transaction transaction2 = new Transaction("02-02-2023", -100.00, "Витрати");
        Transaction transaction3 = new Transaction("01-03-2023", 150.00, "Дохід");
        Transaction transaction4 = new Transaction("02-03-2023", 200.00, "Дохід");
        Transaction transaction5 = new Transaction("03-03-2023", 250.00, "Дохід");

        List<Transaction> transactions = Arrays.asList(transaction1, transaction2, transaction3, transaction4, transaction5);

        TransactionAnalyzer analyzer = new TransactionAnalyzer(transactions);

        double result = analyzer.countTransactionByMonth("03-2023");

        assertEquals(3, result, "Підрахунок кількості транзакцій за місяць правильний.");
        assertNotEquals(999, result, "Підрахунок кількості транзакцій за місяць неправильний.");
    }
}