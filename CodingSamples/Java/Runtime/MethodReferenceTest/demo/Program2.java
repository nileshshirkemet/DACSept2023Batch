import java.util.Scanner;

class Program2 {

    private static double safeScheme(int y) {
        return y < 3 ? 6 : 7.5;
    }

    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.print("Installment and Years: ");
        double p = input.nextDouble();
        int n = input.nextInt();
        var myinv = new Investment(p, n);
        //passing method-reference
        System.out.printf("Future value of safe investment : %.2f%n", myinv.futureValue(Program2::safeScheme));
        //passing lambda-expression: (arguments) -> body
        System.out.printf("Future value of risky investment: %.2f%n", myinv.futureValue(y -> 9 + 0.25 * y));
        input.close();
    }
}
