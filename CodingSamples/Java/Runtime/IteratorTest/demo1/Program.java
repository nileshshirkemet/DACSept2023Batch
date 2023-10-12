class Program {

    public static void main(String[] args) {
        SimpleStack<String> a = new SimpleStack<String>();
        a.push("Monday");
        a.push("Tuesday");
        a.push("Wednesday");
        a.push("Thursday");
        a.push("Friday");
        //local type 'var' is substituted by the type of its initializer
        for(var i = a.iterator(); i.hasNext();)
            System.out.println(i.next());
        System.out.println("---------------------------");
        /*
        while(!a.empty())
            System.out.println(a.pop());   
        */
        SimpleStack<Double> b = new SimpleStack<>(); 
        b.push(23.1);    
        b.push(54.2);
        b.push(65.3);
        b.push(43.4);
        for(double d : b)
            System.out.println(d);
    }
}
