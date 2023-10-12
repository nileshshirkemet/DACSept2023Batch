class Activity {

    public static int perform(int balance, int amount) {
        long limit = System.currentTimeMillis() + amount / 100;
        while(System.currentTimeMillis() < limit);
        return balance - amount;
    }
}
