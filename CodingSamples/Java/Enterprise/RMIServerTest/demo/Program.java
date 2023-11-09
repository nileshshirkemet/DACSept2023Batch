import java.rmi.registry.LocateRegistry;

import shopping.OrderManagerService;

class Program {

    public static void main(String[] args) throws Exception {
        var registry = LocateRegistry.createRegistry(4030);
        registry.bind("orderManager",  new OrderManagerService(4030));
    }
}