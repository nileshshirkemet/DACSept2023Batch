import taxation.*;

class Program1 {

    //nested (static inner member) class
    static class Auditor implements AutoCloseable {

        public Auditor() {
            System.out.println("Auditor - acquiring resources");
        }

        public void audit(String id, TaxPayer info) {
            if(id.length() < 4)
                throw new IllegalArgumentException("Invalid ID");
            double amount = info.incomeTax() + 500;
            System.out.printf("Total tax payment: %.2f%n", amount);
        }

        public void close() {
            System.out.println("Auditor - releasing resources");
        }
    }

    private static void process(String name, int count) {
        TaxPayer t = name.equals("jack") ? new Supervisor(count) : new Worker(count);
        //try-with-resources can be used with AutoCloseable object
        try(Auditor a = new Auditor()){
            a.audit(name, t);
        }//close method will be automatically called
    }

    public static void main(String[] args) {
        try{
            String n = args[0].toLowerCase();
            int m = Integer.parseInt(args[1]);
            process(n, m);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}