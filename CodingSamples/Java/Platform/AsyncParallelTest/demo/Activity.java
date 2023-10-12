class Activity {

    public static long perform(int amount) {
        long limit = System.currentTimeMillis() + amount * 100;
        long count = amount;
        while(System.currentTimeMillis() < limit);
        return count * amount;
    }
}
