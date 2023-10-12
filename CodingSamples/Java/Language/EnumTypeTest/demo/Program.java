class Program {

    public static void main(String[] args) {
        System.out.println("Welcome Investor!");
        double p = Double.parseDouble(args[0]);
        int n = Integer.parseInt(args[1]);
        Investment myinv = new Investment(p, n); 
        System.out.printf("Future value in risk-free investment: %.2f%n", myinv.futureValue());
        myinv.allowRisk(true); 
        System.out.printf("Future value in low-risk investment: %.2f%n", myinv.futureValue());
        myinv.allowRisk(RiskLevel.HIGH);
        System.out.printf("Future value in high-risk investment: %.2f%n", myinv.futureValue());
    }
}