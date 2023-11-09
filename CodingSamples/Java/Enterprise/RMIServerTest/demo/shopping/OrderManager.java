package shopping;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface OrderManager extends Remote {
    
    int placeOrder(OrderEntity entity) throws RemoteException;
    List<OrderEntity> fetchOrders(String customerId) throws RemoteException;
    
}
