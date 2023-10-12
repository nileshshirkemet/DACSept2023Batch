package payroll;

//defining SalesPerson as a subclass of Employee (superclass)
public class SalesPerson extends Employee {
    
    private double sales;

    public SalesPerson(int h, float r, double s) {
        super(h, r); //call constructor of superclass
        sales = s;
    }

    public double getSales() {
        return sales;
    }

    public void setSales(double value) {
        sales = value;
    }

    //method overriding is defining an instance (non-static) method in a class
    //whose declaration matches with a method in the superclass
    public double income() {
        double salary = super.income();
        if(sales >= 20000)
            salary += 0.05 * sales;
        return salary;
    }
}
