package lesson20.task2;

import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args) throws Exception {
        Transaction transaction1 = new Transaction(1001,"Kiev",10,"111",TransactionType.INCOME,new Date());
        Controller controller = new Controller();
        controller.save(transaction1);
        controller.transactionList();
    }
}
