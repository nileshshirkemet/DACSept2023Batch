import finance.*;
import java.lang.reflect.*;

class Program {
    
    public static void main(String[] args) throws Exception {
        double p = Double.parseDouble(args[0]);
        Class<?> c = Class.forName("finance." + args[1]);
        Object policy = c.getConstructor().newInstance(); 
        Method scheme = c.getMethod(args[2], double.class, int.class);
        MaxDuration md = scheme.getAnnotation(MaxDuration.class);
        int m = md != null ? md.value() : 10;
        for(int n = 1; n <= m; ++n){
            double r = (double) scheme.invoke(policy, p, n);
            double emi = Loans.monthlyInstallment(p, n, r);
            System.out.printf("%-6d%12.2f%n", n, emi);
        }
    }
}
