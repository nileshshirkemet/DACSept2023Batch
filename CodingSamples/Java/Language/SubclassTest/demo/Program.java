//request compiler to expand Employee to payroll.Employee
import payroll.Employee;
import payroll.SalesPerson; 

class Program {

    private static double tax(Employee emp) {
        double i = emp.income(); //emp.class.income(emp) 
        return i > 10000 ? 0.15 * (i - 10000) : 0;
    }
    public static double bonus(Employee emp) {
        if(emp instanceof SalesPerson)
            return 0;
        return 10 * emp.getHours();
    }
    public static void main(String[] args) {
        Employee jack = new Employee();
        jack.setHours(186);
        jack.setRate(52);
        System.out.printf("Jack's Income is %.2f, Tax is %.2f and bonus is %.2f%n", jack.income(), tax(jack), bonus(jack));
        SalesPerson jill = new SalesPerson(186, 52, 64000);
        System.out.printf("Jill's Income is %.2f, Tax is %.2f and bonus is %.2f%n", jill.income(), tax(jill), bonus(jill));
    }
}