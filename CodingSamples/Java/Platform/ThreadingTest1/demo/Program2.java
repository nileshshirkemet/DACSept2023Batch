class Program {

    private static String user;

    private static void handleJob(int jid) {
        System.out.printf("Thread<%x> has accepted job %d for %s%n", Thread.currentThread().hashCode(), jid, user);
        Activity.perform(jid);
        System.out.printf("Thread<%x> has finished job %d for %s%n", Thread.currentThread().hashCode(), jid, user);
    }

    public static void main(String[] args) {
        int n = args.length > 0 ? Integer.parseInt(args[0]) : 1;
        Thread child = new Thread(() -> {
            user = "Jack";
            handleJob(n);            
        });
        child.start();
        user = "Jill";
        handleJob(2);
    }
}