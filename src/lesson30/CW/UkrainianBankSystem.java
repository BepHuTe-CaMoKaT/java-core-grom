package lesson30.CW;

import java.util.Date;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class UkrainianBankSystem implements BankSystem {
    private Set<Transaction> transaction = new TreeSet<>();

    @Override
    public void withdraw(User user, int amount) {
        if (!checkWithdraw(user, amount))
            return;
        user.setBalance(user.getBalance() - amount - amount * user.getBank().getCommission(amount));

        createAndSaveTransaction(new Date(), TransactionType.WITHDRAWAL, amount, "DFDF");
    }


    @Override
    public void fund(User user, int amount) {
        if (!checkFund(user, amount))
            return;
        createAndSaveTransaction(new Date(), TransactionType.FUNDING, amount, "DFDF");
    }

    @Override
    public void transferMoney(User fromUser, User toUser, int amount) {
        if (!checkWithdraw(fromUser, amount))
            return;
        if (!checkFund(toUser, amount))
            return;
        if (fromUser.getBank().getCurrency() != toUser.getBank().getCurrency())
            return;
        createAndSaveTransaction(new Date(), TransactionType.TRANSFER, amount, "DFDF");

    }

    @Override
    public void paySalary(User user) {
        if (!checkFund(user, user.getSalary()))
            return;

        user.setBalance(user.getBalance() + user.getSalary());
        createAndSaveTransaction(new Date(), TransactionType.SALARY_INCOME, (user.getSalary()), "DFDF");
    }

    private boolean checkWithdraw(User user, int amount) {
        return checkWithdrawLimits(user, amount, user.getBank().getLimitOfWithdrawal()) &&
                checkWithdrawLimits(user, amount, user.getBalance());
    }

    private boolean checkWithdrawLimits(User user, int amount, double limit) {
        if (amount + user.getBank().getCommission(amount) > limit) {
            printWithdrawalErrorMsg(amount, user);
            return false;
        }
        return true;
    }

    private boolean checkFund(User user, int amount) {
        return checkFundLimits(user, amount, user.getBank().getLimitOfFunding()) &&
                checkFundLimits(user, amount, (Double.MAX_VALUE - user.getBalance()));
    }

    private boolean checkFundLimits(User user, int amount, double limit) {
        if (amount > limit) {
            printFundErrorMsg(amount, user);
            return false;
        }
        return true;
    }


    private void printWithdrawalErrorMsg(int amount, User user) {

        System.err.println("Can't withdraw money" + amount + "for user" + user.toString());

    }

    private void printFundErrorMsg(int amount, User user) {

        System.err.println("Can't fund money" + amount + "for user" + user.toString());

    }

    private Transaction createAndSaveTransaction(Date dateCreated, TransactionType type, int amount, String description) {

        Random random = new Random();
        Transaction tr = new Transaction(random.nextInt(), dateCreated, null, type, amount, description);
        transaction.add(tr);

        return tr;
    }

    public Set<Transaction> getTransaction() {
        return transaction;
    }
}
