package payroll;

public class Employee {
    
    private int hours;
    private float rate;

    //parameterized constructor
    public Employee(int h, float r) {
        hours = h;
        rate = r;
    }

    //parameterless constructor - it is implicitly defined
    //in absence of any explcitly defined constructor
    public Employee() {
        this(0, 50); //calling above constructor
    }

    //accessor methods for a private field
    public int getHours() {
        return hours;
    }

    public void setHours(int value) {
        hours = value;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float value) {
        rate = value;
    }

    public double income() {
        double salary = hours * rate;
        int ot = hours - 180;
        if(ot > 0)
            salary += 50 * ot;
        return salary;
    }
}
