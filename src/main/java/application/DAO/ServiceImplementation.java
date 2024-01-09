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
        String displayQuery="select * from product_info";
        List<Product> productList=new ArrayList<>();
        try {
            Statement stmt=conn.createStatement();
            ResultSet rs= stmt.executeQuery(displayQuery);
            while (rs.next()){
               Product product=new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4));
                productList.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return productList;

    }

    @Override
    public boolean placeOrder(Order newOrder) {
        try {
            CallableStatement cstmt= conn.prepareCall("{call placeOrder(?,?,?)}");
            cstmt.setString(1,newOrder.getCustomer_Name());
            cstmt.setInt(2,newOrder.getpId());
            cstmt.setInt(3,newOrder.getpQty());
            cstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;

    }

    @Override
    public List<Order> displayAllOrders() {
        List<Order> orderList=  new ArrayList<>();
        String displayquery = "select * from order_info";
        try {
            Statement stmt= conn.createStatement();

            ResultSet rs= stmt.executeQuery(displayquery);
            while (rs.next()){
               Order order =new Order(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getDouble(5));
                orderList.add(order);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderList;

    }

    @Override
    public int removeProduct(int pId) {
        String delquery="delete from product_info where pId=?";
        int n=0;
        try {
            PreparedStatement pstmt=conn.prepareStatement(delquery);
            pstmt.setInt(1,pId);
           n= pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }

    @Override
    public int updateProduct(Product newProduct) {
        String update="update product_info set pPrice=? where pId=?";
        int n=0;
        try {
            PreparedStatement pstmt=conn.prepareStatement(update);
            pstmt.setInt(2, newProduct.getpId());
            pstmt.setDouble(1,newProduct.getpPrice());
           n= pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return n;

    }
}
