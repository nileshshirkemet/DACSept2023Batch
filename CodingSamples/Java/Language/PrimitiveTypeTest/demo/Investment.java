class Investment {
    
    //a method (member function) defined with 'static' keyword can be called
    //on the class (ClassName.methodName(...)) in which it is defined but it
    //can only directly refer to other static members of that class
    public static double futureValue(double installment, int years, boolean risk) {
        double i = risk ? 0.08 : 0.06;
        return (installment / i) * (Math.pow(1 + i, years) - 1);
    }

}
