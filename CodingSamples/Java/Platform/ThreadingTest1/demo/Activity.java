class Activity {

    public static int perform(int amount) {
        long limit = System.currentTimeMillis() + amount * 1000;
        while(System.currentTimeMillis() < limit);
        return amount;
    }
}
