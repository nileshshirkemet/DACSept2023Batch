class Program {

    static class JointAccount {

        private int balance;

        public int balance() { return balance; }

        public boolean withdraw(int amount) {
            boolean success = false;
            if(balance >= amount) {
                balance = Activity.perform(balance, amount);
                success = true;
            }
            return success;
        }

        public void deposit(int amount) {
            balance += amount;
        }
    }

    public static void main(String[] args) {
        var acc = new JointAccount();
        acc.deposit(10000);
        System.out.println("Joint-Account opened for Jack and Jill.");
        System.out.printf("Initial balance: %d%n", acc.balance());
        System.out.println("Jack is withdrawing 6000 from the account...");
        if(!acc.withdraw(6000))
            System.out.println("Jack's withdrawal failed!");
        System.out.println("Jill is withdrawing 7000 from the account...");
        if(!acc.withdraw(7000))
            System.out.println("Jill's withdrawal failed!");
        System.out.printf("Final balance : %d%n", acc.balance());
    }
}
