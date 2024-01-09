package application.DAO;

import application.DTO.Order;
import application.DTO.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceImplementation implements Service{

    static Connection conn=null;

    static {
        String url="jdbc:mysql://localhost:3306/testproducts";
        String username="root";
        String password="sql123";
        try {
            conn= DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> DisplayAllProducts() {
        String displayQuery="select pName,pPrice from product_info";
        List<Product> productList=new ArrayList<>();
        try {
            Statement stmt=conn.createStatement();
            ResultSet rs= stmt.executeQuery(displayQuery);
            while (rs.next()){
                String name=rs.getString(1);
                double pPrice=rs.getDouble(2);
                Product product=new Product(name,pPrice);
                productList.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return productList;

    }

    @Override
    public boolean placeOrder(Order newOrder) {
        boolean status= false;

        try {
            CallableStatement cstmt= conn.prepareCall("{call placeOrder(?,?,?,?)}");
            cstmt.setString(1,newOrder.getCustomer_Name());
            cstmt.setInt(2,newOrder.getpId());
            cstmt.setInt(3,newOrder.getpQty());

            cstmt.execute();

            status= cstmt.getBoolean(4);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return status;

    }

    @Override
    public List<Order> displayAllOrders() {
        List<Order> orderList=  new ArrayList<>();
        String displayquery = "select o.order_id,o.customer_name,o.product_id *p. product_price as total,p.product_name,o.  product_qty\n" +
                "from\n" +
                "order_info o inner join product_info p on o.product_id=p.product_id;\n" +
                "     ";
        try {
            Statement stmt= conn.createStatement();

            ResultSet rs= stmt.executeQuery(displayquery);
            while (rs.next()){
                int oId=rs.getInt(1);
                String cName= rs.getString(2);
                double totalAmt=rs.getDouble(3);
                String pName=rs.getString(4);
                int qty =rs.getInt(5);
                Order order=new Order(oId,cName,totalAmt,pName,qty);
                orderList.add(order);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderList;

    }
}
