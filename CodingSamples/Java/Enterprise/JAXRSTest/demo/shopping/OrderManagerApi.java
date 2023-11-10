package shopping;

import java.rmi.Naming;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("/sales")
public class OrderManagerApi {
  
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response readOrders(@PathParam("id") String customerId) {
        try{
            var stub = (OrderManager) Naming.lookup("rmi://localhost:4030/orderManager");
            var orders = stub.fetchOrders(customerId);
            return orders.size() > 0 ? Response.ok(orders).build() : Response.status(404).build();
        }catch(Exception e){
            return Response.status(500).build();
        }
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response createOrder(OrderEntity resource) {
        try{
            var stub = (OrderManager) Naming.lookup("rmi://localhost:4030/orderManager");
            int orderNo = stub.placeOrder(resource);
            resource.setOrderNo(orderNo);
            return Response.ok(resource).build();
        }catch(Exception e){
            return Response.status(500, "Order Failed").build();
        }
    }
}
