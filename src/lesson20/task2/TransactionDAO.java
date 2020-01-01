package lesson20.task2;

import lesson20.task2.exception.LimitExceeded;

import java.util.Calendar;
import java.util.Date;

public class TransactionDAO {
    private Transaction[] transactions = new Transaction[10];
    private Utils utils = new Utils();

    public Transaction save(Transaction transaction) throws Exception {
        validate(transaction);
        return transaction;
    }

    public Transaction[] transactionList() {
        return null;
    }

    public Transaction[] transactionList(String city) {
        return null;
    }

    public Transaction[] transactionList(int amount) {
        return null;
    }

    private Transaction[] getTransactionsPerDay(Date dateOfCurTransaction) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfCurTransaction);

        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());
                int trmonth = calendar.get(Calendar.MONTH);
                int trday = calendar.get(Calendar.DAY_OF_MONTH);
                if (trmonth == month && trday == day) count++;
            }
        }

        Transaction[] result = new Transaction[count];
        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());
                int trmonth = calendar.get(Calendar.MONTH);
                int trday = calendar.get(Calendar.DAY_OF_MONTH);
                if (trmonth == month && trday == day) {
                    result[index] = transaction;
                    index++;
                }
            }
        }
        return result;
    }

    private void validate(Transaction transaction) throws Exception {
//        - сумма транзакции больше указанного лимита
//        - сумма транзакций за день больше дневного лимита
//        - количество транзакций за день больше указанного лимита
//        - если город оплаты (совершения транзакции) не разрешен
        if (transaction.getAmount() > utils.getLimitSimpleTransactionAmount())
            throw new LimitExceeded("Transaction limit exceeded " + transaction.getId() + ". Can'tbe saved");

        int sum = 0;
        int count = 0;
        for (Transaction tr : getTransactionsPerDay(transaction.getDateCreated())) {
            sum += tr.getAmount();
            count++;
        }
        if (sum > utils.getLimitTransactionsPerDayAmount())
            throw new LimitExceeded("Transaction limit per day amount exceeded " + transaction.getId() + ". Can'tbe saved");

        if (count > utils.getLimitTransactionsPerDayCount())
            throw new LimitExceeded("Transaction limit per day count exceeded " + transaction.getId() + ". Can'tbe saved");
    }
}
