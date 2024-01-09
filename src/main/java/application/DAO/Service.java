package application.DAO;

import application.DTO.Order;
import application.DTO.Product;

import java.util.List;

public interface Service {
    List<Product> DisplayAllProducts();
    boolean placeOrder(Order newOrder);
    List<Order>displayAllOrders();
    int removeProduct(int pId);

    int updateProduct(Product newProduct);
}
