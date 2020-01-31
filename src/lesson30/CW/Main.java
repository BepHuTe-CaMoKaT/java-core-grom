package lesson30.CW;

import lesson30.CW.*;

public class Main {
    public static void main(String[] args) {
        Bank euBank = new EUBank(1001,"Sweden", Currency.EUR,100,1400,4,41414144);
        User user = new User(1,"Denis",12200,40,"GMD",1500, euBank);
        User user1 = new User(2,"Denis",12200,40,"GMD",1500, euBank);
        BankSystem bankSystem = new UkrainianBankSystem();
        bankSystem.withdraw(user,150);
        bankSystem.withdraw(user1,150);

        System.out.println(user.getBalance());
        System.out.println(user1.getBalance());

        Bank usBank = new USBank(1002,"Sweden",Currency.EUR,100,1400,4,41414144);
        User user2 = new User(3,"Denis",12200,40,"GMD",1500, usBank);
        User user3 = new User(4,"Denis",12200,40,"GMD",1500, usBank);
        bankSystem.withdraw(user2,150);
        bankSystem.withdraw(user3,150);
        System.out.println(user2.getBalance());
        System.out.println(user3.getBalance());

        Bank cnBank = new ChinaBank(1003,"Sweden",Currency.EUR,100,1400,4,41414144);
        User user4 = new User(5,"Denis",12200,40,"GMD",1500, cnBank);
        User user5 = new User(6,"Denis",12200,40,"GMD",1500, cnBank);
        bankSystem.withdraw(user4,150);
        bankSystem.withdraw(user5,150);
        System.out.println(user4.getBalance());
        System.out.println(user5.getBalance());
    }


}
