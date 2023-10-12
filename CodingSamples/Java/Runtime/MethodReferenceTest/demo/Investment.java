class Investment {

    //a final instance field can only be assigned in costructor
    private final double installment;
    private final int years;

    public Investment(double amount, int count) {
        installment = amount;
        years = count;
    }

    public double installment() { return installment; }

    public int years() { return years; }

    public double futureValue(InterestRate growth) {
        double i = growth.forPeriod(years) / 100;
        return (installment / i) * (Math.pow(1 + i, years) - 1);
    }
}
