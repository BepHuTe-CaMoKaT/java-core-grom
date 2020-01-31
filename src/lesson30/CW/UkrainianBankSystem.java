package lesson30.CW;

public class UkrainianBankSystem implements BankSystem {
    @Override
    public void withdraw(User user, int amount) {

        if (!checkWithdraw(user,amount))
            return;
        user.setBalance(user.getBalance() - amount - amount*user.getBank().getCommission(amount));
    }

    @Override
    public void fund(User user, int amount) {
        if (!checkFund(user, amount))
            return;
        user.setBalance(user.getBalance() + amount);
    }

    @Override
    public void transferMoney(User fromUser, User toUser, int amount) {
        if (!checkWithdraw(fromUser, amount)) return;
        if (!checkFund(toUser, amount)) return;
        if (fromUser.getBank().getCurrency() != toUser.getBank().getCurrency()) return;

        withdraw(fromUser, amount);
        fund(toUser, amount);
        return;
    }

    @Override
    public void paySalary(User user) {
        if (!checkPaySalary(user))
            return;
        user.setBalance(user.getBalance() + user.getSalary());
    }

    private void printWithdrawalErrorMsg(int amount, User user){
        System.err.println("Can't withdraw money " + amount + " from user" + user.toString());
    }
    private boolean checkWithdraw(User user, int amount){
        return checkWithdrawLimits(user,amount,user.getBank().getLimitOfWithdrawal()) && checkWithdrawLimits(user,amount,user.getBalance());
    }
    private boolean checkWithdrawLimits(User user, int amount, double limit){
        if (amount + user.getBank().getCommission(amount) > limit) {
            printWithdrawalErrorMsg(amount, user);
            return false;
        }
        return true;
    }

    private void printFundErrorMsg(int amount, User user){
        System.err.println("Can't fund money " + amount + " to user" + user.toString());
    }
    private boolean checkFund(User user, int amount){
        return checkFundLimits(user,amount,user.getBank().getLimitOfFunding());
    }
    private boolean checkFundLimits(User user, int amount, double limit){
        if (amount > limit) {
            printFundErrorMsg(amount, user);
            return false;
        }
        return true;
    }

    private void printPaySalaryErrorMsg(int amount, User user){
        System.err.println("Can't pay salary " + amount + " to user" + user.toString());
    }
    private boolean checkPaySalary(User user){
        return checkPaySalaryLimits(user, user.getSalary(),user.getBank().getLimitOfFunding());
    }
    private boolean checkPaySalaryLimits(User user, int amount, double limit){
        if (amount>limit) {
            printPaySalaryErrorMsg(amount, user);
            return false;
        }
        return true;
    }

    public boolean checkCurrency(User fromUser, User toUser){
        if (fromUser.getBank().getCurrency()!=toUser.getBank().getCurrency()) return false;
        return true;
    }
}
