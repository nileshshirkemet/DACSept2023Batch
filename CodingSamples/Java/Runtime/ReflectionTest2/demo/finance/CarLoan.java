package finance;

public class CarLoan extends PersonalLoan {
    
    @Override
    public double common(double amount, int period) {
        return amount < 1000000 ? 15 : 18;
    }
}
