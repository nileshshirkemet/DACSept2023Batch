import jakarta.persistence.Persistence;
import shopping.ProductEntity;

class Program {

    public static void main(String[] args) throws Exception {
        var emf = Persistence.createEntityManagerFactory("SalesPU");
        var em = emf.createEntityManager();
        if(args.length == 0) {
            var query = em.createQuery("SELECT e FROM ProductEntity e WHERE e.stock > 5", ProductEntity.class);
            var products = query.getResultList();
            for(var item : products)
                System.out.printf("%d\t%.2f\t%d%n", item.getProductNo(), item.getPrice(), item.getStock());
        }else{
            int productNum = Integer.parseInt(args[0]);
            var product = em.find(ProductEntity.class, productNum);
            if(product != null){
                for(var entry : product.getOrders())
                    System.out.printf("%s\t%d\t%tF%n", entry.getCustomerId(), entry.getQuantity(), entry.getOrderDate());
            }
        }
        em.close();
    }
}
