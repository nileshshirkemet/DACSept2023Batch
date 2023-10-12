package taxation;

public interface TaxPayer {
    
    double RATE = 0.15;

    double annualIncome();

    default double incomeTax() {
        double extra = annualIncome() - 120000;
        return extra > 0 ? RATE * extra : 0;
    }
}
