import java.util.*;

class Program {

    public static void main(String[] args) {
        if(args[0].equals("items")){
            Item[] items = Shop.getItems();
            Arrays.stream(items)
                .filter(i -> i.brand().equals(args[1]))
                .map(i -> i.name())
                .forEach(System.out::println);
        }else if(args[0].equals("customers")){
            double amount = Double.parseDouble(args[1]);
            Collection<Customer> customers = Shop.getCustomers();
            customers.add(new Customer("Xavier", 120000, 5));
            customers.stream()
                .filter(c -> c.purchase() >= amount)
                .sorted()
                .map(c -> c.id() + "\t\t" + "*".repeat(c.rating()))
                .forEach(s -> System.out.println(s));
        }
    }
}
