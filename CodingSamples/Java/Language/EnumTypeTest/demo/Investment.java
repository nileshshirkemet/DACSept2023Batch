class Investment {

    private double installment;
    private int years;
    private RiskLevel risk;

    public Investment(double amount, int count) {
        installment = amount;
        years = count;
        risk = RiskLevel.NONE;
    }

    public void allowRisk(boolean yes) {
        risk = yes ? RiskLevel.LOW : RiskLevel.NONE;
    }

    //method overloading is defining multiple methods in a
    //class with same name but different list of parameter types
    public void allowRisk(RiskLevel level) {
        risk = level;
    }

    public double totalPayment() {
        return installment * years;
    }

    public double futureValue() {
        double i;
        switch(risk) {
            case HIGH:
                i = 0.11;
                break;
            case LOW:
                i = 0.09;
                break;
            default:
                i = 0.06;
        }
        return (installment / i) * (Math.pow(i + 1, years) - 1);
    }
}
