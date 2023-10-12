class Program {

    public static void main(String[] args) {
        long m = Long.parseLong(args[0]);
        long n = Long.parseLong(args[1]);
        System.out.printf("Number of Primes: %d%n", Legacy.countPrimes(m, n));
        //long[] primes = Legacy.selectPrimes(m, 5, true);
        long[] primes = Legacy.selectPrimes(m, 5, false);
        System.out.println("First five selected primes");
        for(long prime : primes)
            System.out.println(prime);

    }
}
