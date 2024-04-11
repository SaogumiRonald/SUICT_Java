import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TransactionAnalyzer {
    private List<Transaction> transactions;

    private DateTimeFormatter dateFormatter;

    public TransactionAnalyzer(List<Transaction> transactions) {
        this.transactions = transactions;
        this.dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }

    public double calculateTotalBalance() {
        double balance = 0;
        for (Transaction transaction : transactions){
            balance += transaction.getAmount();
        }

        return balance;
    }

    public int countTransactionByMonth(String monthYear){
        int count = 0;
        for (Transaction transaction : transactions){
            LocalDate date = LocalDate.parse(transaction.getDate(), dateFormatter);
            String transactionMonthYear = date.format(DateTimeFormatter.ofPattern("MM-yyyy"));
            if (transactionMonthYear.equals(monthYear)){
                count++;
            }
        }
        return count;
    }

    public List<Transaction> findTopExpenses() {
        return transactions.stream()
                .filter(t -> t.getAmount() < 0)
                .sorted(Comparator.comparing(Transaction::getAmount))
                .limit(10)
                .collect(Collectors.toList());
    }

    public List<Transaction> getTopTransactionsInPeriod(String startDate, String endDate, int n) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate start = LocalDate.parse(startDate, formatter);
        LocalDate end = LocalDate.parse(endDate, formatter);

        List<Transaction> transactionsInPeriod = transactions.stream()
                .filter(transaction -> {
                    LocalDate transactionDate = LocalDate.parse(transaction.getDate(), formatter);
                    return !transactionDate.isBefore(start) && !transactionDate.isAfter(end);
                })
                .collect(Collectors.toList());

        transactionsInPeriod.sort(Comparator.comparingDouble(Transaction::getAmount));

        return transactionsInPeriod.stream()
                .limit(n)
                .collect(Collectors.toList());
    }

    public List<Transaction> getLowestTransactionsInPeriod(String startDate, String endDate, int n) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate start = LocalDate.parse(startDate, formatter);
        LocalDate end = LocalDate.parse(endDate, formatter);

        List<Transaction> transactionsInPeriod = transactions.stream()
                .filter(transaction -> {
                    LocalDate transactionDate = LocalDate.parse(transaction.getDate(), formatter);
                    return !transactionDate.isBefore(start) && !transactionDate.isAfter(end);
                })
                .collect(Collectors.toList());

        transactionsInPeriod.sort(Comparator.comparingDouble(Transaction::getAmount).reversed());

        return transactionsInPeriod.stream()
                .limit(n)
                .collect(Collectors.toList());
    }

    public void generateSummaryReportByCategory() {
        Map<String, Double> expensesByCategory = new HashMap<>();
        for (Transaction transaction : transactions) {
            if (transaction.getAmount() < 0) {
                String category = transaction.getDescription();
                double amount = -transaction.getAmount();
                expensesByCategory.put(category, expensesByCategory.getOrDefault(category, 0.0) + amount);
            }
        }

        System.out.println("\nЗвіт по всім витатам за категоріями: ");
        for (Map.Entry<String, Double> entry : expensesByCategory.entrySet()) {
            String category = entry.getKey();
            double amount = entry.getValue();
            System.out.print(category + ": ");
            printStars(amount);
        }
    }

    public void generateSummaryReportByMonth() {
        Map<String, Double> expensesByMonth = new HashMap<>();
        for (Transaction transaction : transactions) {
            if (transaction.getAmount() < 0) {
                String month = transaction.getDate().substring(3, 10);
                double amount = -transaction.getAmount();
                expensesByMonth.put(month, expensesByMonth.getOrDefault(month, 0.0) + amount);
            }
        }

        System.out.println("\nЗвіт по всім витатам за місяцями: ");
        for (Map.Entry<String, Double> entry : expensesByMonth.entrySet()) {
            String month = entry.getKey();
            double amount = entry.getValue();
            System.out.print(month + ": ");
            printStars(amount);
        }
    }

    private void printStars(double amount) {
        int stars = (int) (amount / 1000);
        for (int i = 0; i < stars; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}
