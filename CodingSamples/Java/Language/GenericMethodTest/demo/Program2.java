class Program {

    private static Object select(int index, Object first, Object second) {
        if((index % 2) == 1)
            return first;
        return second;
    }

    public static void main(String[] args) {
        if(args.length > 0){
            int s = Integer.parseInt(args[0]);
            String ss = (String)select(s, "Monday", "Tuesday");
            System.out.printf("Selected String = %s%n", ss);
            //a primitive type does not support direct conversion to Object type
            //so first an instance of its wrapper class is initialized and the 
            //reference to this instance is converted into the Object (auto-boxing)
            double sd = (double)select(s, 45.6, 32.1);
            System.out.printf("Selected double = %s%n", sd);
            //double ssd = (double)select(s, 19.2, "June");
        }
    }
}