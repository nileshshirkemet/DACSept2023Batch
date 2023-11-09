package shopping;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Persistence;

public class OrderManagerService extends UnicastRemoteObject implements OrderManager {
    
    public OrderManagerService(int port) throws RemoteException {
        super(port); //export this object on the specified TCP port
    }

    public int placeOrder(OrderEntity entity) throws RemoteException {
        var emf = Persistence.createEntityManagerFactory("ShopPU");
        try(var em = emf.createEntityManager()){
            var tx = em.getTransaction();
            tx.begin();
            var ctr = em.find(CounterEntity.class, "orders");
            int orderNo = ctr.getNextValue() + 1000;
            entity.setOrderNo(orderNo);
            entity.setOrderDate(new Date());
            em.persist(entity); //manage persisitence of entity
            //saves changes to managed entities and if there is no
            //exception then commit the transaction otherwise
            //rollback the transaction
            tx.commit(); 
            return orderNo;
        }
    }

    public List<OrderEntity> fetchOrders(String customerId) throws RemoteException {
        var emf = Persistence.createEntityManagerFactory("ShopPU");
        try(var em = emf.createEntityManager()){
            var query = em.createQuery("SELECT e FROM OrderEntity e WHERE e.customerId=?1", OrderEntity.class);
            query.setParameter(1, customerId);
            return query.getResultList();
        }       
    }
}
