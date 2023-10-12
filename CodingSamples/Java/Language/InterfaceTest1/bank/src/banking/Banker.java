package banking;

public class Banker {
    
    private static long nid = System.currentTimeMillis();

    public static Account openCurrentAccount() {
        Account acc = new CurrentAccount();
        acc.id = ++nid;
        return acc;
    }

    public static Account openSavingsAccount() {
        Account acc = new SavingsAccount();
        acc.id = ++nid;
        return acc;
    }
}
