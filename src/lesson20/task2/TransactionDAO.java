package lesson20.task2;

import lesson20.task2.exception.BadRequestException;
import lesson20.task2.exception.InternalServerException;
import lesson20.task2.exception.LimitExceeded;

import java.util.Calendar;
import java.util.Date;

public class TransactionDAO {
    private Transaction[] transactions = new Transaction[10];
    private Utils utils = new Utils();

    public Transaction save(Transaction transaction) throws Exception {
//       - сумма транзакции больше указанного лимита
//        - сумма транзакций за день больше дневного лимита
//        - количество транзакций за день больше указанного лимита
//        - если город оплаты (совершения транзакции) не разрешен
        if (transaction.getAmount() > utils.getLimitSimpleTransactionAmount())
            throw new LimitExceeded("Transaction limit exceeded " + transaction.getId() + ". Can't be saved");

        validate(transaction);
        checkTransactionCity(transaction);

        for (Transaction tr:transactions){
            if (transaction.equals(tr)){
                throw new BadRequestException("There is the same transaction already saved "+transaction.getId()+" Can't be saved");
            }
        }

        int index=0;
        for (Transaction tr:transactions){
            if (tr==null){
                transactions[index]=transaction;
                return transaction;
            }
            index++;
        }
        throw new InternalServerException("There is no free space. Transaction "+transaction.getId()+" can't be saved");
    }

    public Transaction[] transactionList() {
        int count=0;
        for (Transaction tr:transactions){
            if (tr!=null)
                count++;
        }
        Transaction[] counted=new Transaction[count];
        int index=0;
        for (Transaction transaction:transactions){
            if (transaction!=null){
                counted[index]=transaction;
                index++;
            }
        }

        return counted;
    }

    public Transaction[] transactionList(String city) {
        int count=0;
        for (Transaction tr:transactions){
            if (tr!=null&&tr.getCity().equals(city))
                count++;
        }
        Transaction[] counted=new Transaction[count];
        int index=0;
        for (Transaction transaction:transactions){
            if (transaction!=null&&transaction.getCity().equals(city)){
                counted[index]=transaction;
                index++;
            }
        }
        return counted;
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

    private void validate(Transaction transaction) throws LimitExceeded {
//
        if (transaction.getAmount() > utils.getLimitSimpleTransactionAmount())
            throw new LimitExceeded("Transaction limit exceeded " + transaction.getId() + ". Can't be saved");

        int sum = 0;
        int count = 0;
        for (Transaction tr : getTransactionsPerDay(transaction.getDateCreated())) {
            sum += tr.getAmount();
            count++;
        }
        if (sum + transaction.getAmount() > utils.getLimitTransactionsPerDayAmount())
            throw new LimitExceeded("Transaction limit per day amount exceeded " + transaction.getId() + ". Can't be saved");

        if (count + 1> utils.getLimitTransactionsPerDayCount())
            throw new LimitExceeded("Transaction limit per day count exceeded " + transaction.getId() + ". Can't be saved");
    }
    private void checkTransactionCity(Transaction transaction) throws BadRequestException {
        for (String city:utils.getCities()){
            if (city.equals(transaction.getCity()))
               return;
        }
        throw new BadRequestException("Can't be saved "+transaction.getId());
    }
}
