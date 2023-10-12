import java.util.*;

class Shop {
    
    public static Item[] getItems() {
        return new Item[] {
            new Item("cpu", "intel"),
            new Item("ddr", "samsung"),
            new Item("motherboard", "intel"),
            new Item("mouse", "logitech"),
            new Item("cpu", "amd"),
            new Item("monitor", "samsung"),
            new Item("keyboard", "logitech"),
            new Item("ssd", "samsung"),
            new Item("mouse", "microsoft")
        };
    }

    public static Collection<Customer> getCustomers() {
        Collection<Customer> customers = new ArrayList<Customer>();
        customers.add(new Customer("Diptish", 42000, 3));
        customers.add(new Customer("Vinayak", 58000, 2));
        customers.add(new Customer("Karan", 65000, 5));
        customers.add(new Customer("Amol", 84000, 4));
        customers.add(new Customer("Suyog", 21000, 1));
        customers.add(new Customer("Ritul", 72000, 3));
        customers.add(new Customer("Bhavesh", 52000, 4));
        customers.add(new Customer("Monali", 96000, 5));
        customers.add(new Customer("Tejal", 81000, 4));
        customers.add(new Customer("Nikita", 19000, 2));
        return customers;
    }
}
