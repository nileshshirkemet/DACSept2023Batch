class Program {

    static class JointAccount {

        private int balance;

        public int balance() { return balance; }

        public boolean withdraw(int amount) {
            boolean success = false;
            //in Java a synchronized block represents a critical section,
            //and each object has its own built-in monitor 
            synchronized(this) {
                if(balance >= amount) {
                    balance = Activity.perform(balance, amount);
                    success = true;
                }
            }
            return success;
        }

        public synchronized void deposit(int amount) {
            balance += amount;
        }
    }

    public static void main(String[] args) throws Exception {
        var acc = new JointAccount();
        acc.deposit(10000);
        System.out.println("Joint-Account opened for Jack and Jill.");
        System.out.printf("Initial balance: %d%n", acc.balance());
        Thread child1 = new Thread(() -> {
            System.out.println("Jack is withdrawing 6000 from the account...");
            if(!acc.withdraw(6000))
                System.out.println("Jack's withdrawal failed!");            
        });
        child1.start();
        Thread child2 = new Thread(() -> {
            System.out.println("Jill is withdrawing 7000 from the account...");
            if(!acc.withdraw(7000))
                System.out.println("Jill's withdrawal failed!");
        });
        child2.start();
        child1.join(); //main thread waits for child1 to exit
        child2.join(); //main thread waits for child2 to exit
        System.out.printf("Final balance : %d%n", acc.balance());
    }
}
