import banking.*;

class Program {

    private static void payAnnualInterest(Account[] list) {
        for(Account acc : list){
            if(acc instanceof Profitable p) {
                //Profitable p = (Profitable) acc;
                double amount = p.interest(12);
                acc.deposit(amount);
            }
        }
    }

    public static void main(String[] args) {
        Account[] bank = new Account[5];
        bank[0] = Banker.openSavingsAccount();
        bank[0].deposit(5000);
        bank[1] = Banker.openCurrentAccount();
        bank[1].deposit(20000);
        bank[2] = Banker.openSavingsAccount();
        bank[2].deposit(25000);
        bank[3] = Banker.openCurrentAccount();
        bank[3].deposit(40000);
        bank[4] = Banker.openSavingsAccount();
        bank[4].deposit(45000);
        /*
        for(int i = 0; i < bank.length; ++i){
            System.out.printf("%d\t%.2f%n", bank[i].id(), bank[i].balance());
        }
        */
        payAnnualInterest(bank);
        for(Account acc : bank){
            System.out.printf("%d\t%.2f%n", acc.id(), acc.balance());
        }
    }
}
