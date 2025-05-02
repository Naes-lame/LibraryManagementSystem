package Controller;

import Database.DatabaseOperations;
import Models.Transactions;
import java.util.List;

public class TransactionsController {

    private static final DatabaseOperations dbo = new DatabaseOperations();

    public static boolean issueBook(Transactions transactions) {
        return dbo.issueBook(transactions);
    }

    public static boolean returnBooks(Transactions transactions) {
        return dbo.returnBook(transactions);
    }

    public static List<Transactions> getTransaction() {
        return dbo.getTransaction();
    }

    public static boolean deleteTransaction(Transactions transactions) {
        return dbo.deleteTransaction(transactions);
    }

    public static int getRecordCount(String tableName) {
        return dbo.getRecordCount(tableName);
    }

}
