package lesson20.task2;

import java.util.Calendar;
import java.util.Date;

public class TransactionDAO {
    private Transaction[] transactions=new Transaction[10];

    public Transaction save(Transaction transaction){
        return null;
    }
    public Transaction[] transactionList(){return null;}
    public Transaction[] transactionList(String city){return null;}
    public Transaction[] transactionList(int amount){return null;}

    private Transaction[]getTransactionsPerDay(Date dateOfCurTransaction){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfCurTransaction);

        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        int count = 0;
        for (Transaction transaction:transactions){
            if (transaction!=null){
                calendar.setTime(transaction.getDateCreated());
                int trmonth = calendar.get(Calendar.MONTH);
                int trday = calendar.get(Calendar.DAY_OF_MONTH);
                if (trmonth==month&&trday==day) count++;
            }
        }

        Transaction[] result = new Transaction[count];
        int index = 0;
        for (Transaction transaction:transactions){
            if (transaction!=null){
                calendar.setTime(transaction.getDateCreated());
                int trmonth = calendar.get(Calendar.MONTH);
                int trday = calendar.get(Calendar.DAY_OF_MONTH);
                if (trmonth==month&&trday==day) {
                    result[index]=transaction;
                    index++;
                }
            }
        }
        return result;
    }
}
