import java.util.List;

public class Program {
    public static void main(String[] args) {
        String filePath = "https://informer.com.ua/dut/java/pr2.csv";
        TransactionCSVReader csvReader = new TransactionCSVReader();
        List<Transaction> transactions = csvReader.readTransaction(filePath);
        TransactionAnalyzer analyzer = new TransactionAnalyzer(transactions);
        TransactionReportGenerator reportGenerator = new TransactionReportGenerator();

        for (Transaction transaction : transactions){
            System.out.println(transaction);
        }

        double totalBalance = analyzer.calculateTotalBalance();
        reportGenerator.printBalanceReport(totalBalance);

        String monthYear = "01-2024";
        int transactionsCount = analyzer.countTransactionByMonth(monthYear);
        reportGenerator.printTransactionsCountByMonth(monthYear, transactionsCount);

        List<Transaction> topExpenses = analyzer.findTopExpenses();
        reportGenerator.printTopExpensesReport(topExpenses);

        System.out.println("======================================");
        List<Transaction> topTransactions = analyzer.getTopTransactionsInPeriod("20-12-2023", "30-12-2023", 3);
        reportGenerator.printTopTransactionsInPeriod(topTransactions);

        List<Transaction> lowTransactions = analyzer.getLowestTransactionsInPeriod("20-12-2023", "30-12-2023", 3);
        reportGenerator.printLowTransactionsInPeriod(lowTransactions);

        System.out.println("======================================");
        analyzer.generateSummaryReportByCategory();

        System.out.println("======================================");
        analyzer.generateSummaryReportByMonth();
    }
}
