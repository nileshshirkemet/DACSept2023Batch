import java.util.Scanner;

class Program1 {

    static class SafeScheme implements InterestRate {

        public double forPeriod(int y) {
            return y < 3 ? 6 : 7.5;
        } 
    }

    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.print("Installment and Years: ");
        double p = input.nextDouble();
        int n = input.nextInt();
        var myinv = new Investment(p, n);
        System.out.printf("Future value of safe investment : %.2f%n", myinv.futureValue(new SafeScheme()));
        System.out.printf("Future value of risky investment: %.2f%n", myinv.futureValue(new InterestRate(){
            public double forPeriod(int y) {
                return 9 + 0.25 * y;
            }
        }));
        input.close();
    }
}
