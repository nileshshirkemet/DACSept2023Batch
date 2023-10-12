package banking;

//A class declared with 'abstract' keyword does not support
//initialization of new instances, it can only be used as
//a superclass.
public abstract class Account {
        long id;
    protected double balance;
    public long id() { return id; }

    public double balance() { return balance; }

    //A method declared with 'abstract' keyword does not have
    //a body (pure method) and it must be overridden by any
    //non-abtract subclass
    public abstract void deposit(double amount);

    public abstract void withdraw(double amount) throws InsufficientFundsException;

    //A method declared with 'final' keyword cannot be overridden
    //in a subclass
    public final void transfer(double amount, Account that) throws InsufficientFundsException {
        if(this != that) {
            this.withdraw(amount);
            that.deposit(amount);
        }
    }

}
