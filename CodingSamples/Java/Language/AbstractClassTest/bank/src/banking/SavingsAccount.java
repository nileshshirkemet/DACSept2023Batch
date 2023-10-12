package banking;

final class SavingsAccount extends Account {
    
    //A field declared with 'static' modifier has a single
    //value for all of its instances.
    //A field declared with 'final' modifier is read-only
    static final double MIN_BAL = 5000;

    public SavingsAccount() {
        balance = MIN_BAL;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if(balance - amount < MIN_BAL)
            throw new InsufficientFundsException();
        balance -= amount;
    }
}
