class Investment {

    private double installment;
    private int years;
    private boolean risk;

    public Investment(double amount, int count) {
        installment = amount;
        years = count;
        risk = false;
    }

    /*
    public static void allowRisk(Investment this, boolean yes) {
        this.risk = yes;
    }
     */
    public void allowRisk(boolean yes) {
        risk = yes;
    }

    public double totalPayment() {
        return installment * years;
    }

    public double futureValue() {
        double i = risk ? 0.09 : 0.06;
        return (installment / i) * (Math.pow(i + 1, years) - 1);
    }
}
