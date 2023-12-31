package model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerOrder {
    
    private int productNo;
    private int quantity;
    private Date orderDate;

    public CustomerOrder(ResultSet rs) throws SQLException {
        productNo = rs.getInt("pno");
        quantity = rs.getInt("qty");
        orderDate = rs.getDate("ord_date");
    }

    public final int getProductNo() {
        return productNo;
    }

    public final int getQuantity() {
        return quantity;
    }

    public final Date getOrderDate() {
        return orderDate;
    }

    
}
