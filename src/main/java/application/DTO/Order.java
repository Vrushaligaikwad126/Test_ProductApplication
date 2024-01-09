package application.DTO;

import java.util.LinkedList;
import java.util.List;

public class Order {
    private int oId;
    private  String customer_Name;
    private int pId;
    private int pQty;
    private double total_Bill;

    public Order() {
    }

    public Order(int oId, String customer_Name, int pId, int pQty, double total_Bill) {
        this.oId = oId;
        this.customer_Name = customer_Name;
        this.pId = pId;
        this.pQty = pQty;
        this.total_Bill = total_Bill;
    }

    public Order(String customerName, int productId, int productQty) {
    }

    public Order(int oId, String cName, double totalAmt, String pName, int qty) {
    }

    public int getoId() {
        return oId;
    }

    public void setoId(int oId) {
        this.oId = oId;
    }

    public String getCustomer_Name() {
        return customer_Name;
    }

    public void setCustomer_Name(String customer_Name) {
        this.customer_Name = customer_Name;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public int getpQty() {
        return pQty;
    }

    public void setpQty(int pQty) {
        this.pQty = pQty;
    }

    public double getTotal_Bill() {
        return total_Bill;
    }

    public void setTotal_Bill(double total_Bill) {
        this.total_Bill = total_Bill;
    }


}
