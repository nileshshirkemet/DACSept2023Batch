class Program {

    //Wildcard substitution - or a generic type G with type-parameter T, 
    //the data-type G<?> does not support a member of G in which T appears 
    //as an argument type but it can be substituted by any G<S>
    private static void printStack(SimpleStack<?> stack) {
        while(!stack.empty())
            System.out.println(stack.pop());
        //stack.push("abcd");
    }

    public static void main(String[] args) {
        SimpleStack<String> a = new SimpleStack<String>();
        a.push("Monday");
        a.push("Tuesday");
        a.push("Wednesday");
        a.push("Thursday");
        a.push("Friday");
        printStack(a);
        System.out.println("---------------------------");
        SimpleStack<Interval> b = new SimpleStack<>();
        b.push(new Interval(5, 31));
        b.push(new Interval(3, 42));
        b.push(new Interval(4, 13));
        b.push(new Interval(6, 24));
        printStack(b);
    }
}