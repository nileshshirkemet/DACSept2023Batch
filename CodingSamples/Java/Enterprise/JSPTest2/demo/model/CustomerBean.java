package model;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class CustomerBean implements Serializable{
    
    private String id;
    private String password;

    public final String getId() {
        return id;
    }

    public final void setId(String id) {
        this.id = id;
    }

    public final String getPassword() {
        return password;
    }

    public final void setPassword(String password) {
        this.password = password;
    }

    public boolean authenticate() throws SQLException, NamingException {
        var naming = new InitialContext();
        var pool = (DataSource) naming.lookup("java:app/jdbc/SalesDB");
        try(var con = pool.getConnection()) {
            var pstmt = con.prepareStatement("select count(cust_id) from customers where cust_id=? and pwd=?");
            pstmt.setString(1, id);
            pstmt.setString(2, password);
            var rs = pstmt.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            rs.close();
            pstmt.close();
            if(count == 1)
                return true;
            id = password = null;
            return false;
        }

    }

    public List<CustomerOrder> getOrders() throws NamingException, SQLException {
        var orders = new ArrayList<CustomerOrder>();
        var naming = new InitialContext();
        var pool = (DataSource) naming.lookup("java:app/jdbc/SalesDB");
        try(var con = pool.getConnection()) {
            var pstmt = con.prepareStatement("select pno, qty, ord_date from orders where cust_id=?");
            pstmt.setString(1, id);
            var rs = pstmt.executeQuery();
            while(rs.next())
                orders.add(new CustomerOrder(rs));
            rs.close();
            pstmt.close();
        }
        return orders;
    }
}
