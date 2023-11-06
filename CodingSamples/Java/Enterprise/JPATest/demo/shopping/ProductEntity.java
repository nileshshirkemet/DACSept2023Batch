package shopping;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class ProductEntity {
    
    @Id
    @Column(name = "pno")
    private int productNo;

    @Column
    private double price;

    @Column
    private int stock;

    @OneToMany
    @JoinColumn(name = "pno")
    private List<OrderEntity> orders;

    public int getProductNo() {
        return productNo;
    }

    public void setProductNo(int productNo) {
        this.productNo = productNo;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public List<OrderEntity> getOrders() {
        return orders;
    }

    
}

