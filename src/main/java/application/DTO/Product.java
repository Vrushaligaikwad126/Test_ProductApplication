package application.DTO;

public class Product {
    private int pId;
    private String pName;
    private int pQty;
    private double pPrice;

    public Product() {
    }

    public Product(String name, double pPrice) {
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public int getpQty() {
        return pQty;
    }

    public void setpQty(int pQty) {
        this.pQty = pQty;
    }

    public double getpPrice() {
        return pPrice;
    }

    public void setpPrice(double pPrice) {
        this.pPrice = pPrice;
    }

    public Product(int pId, String pName, int pQty, double pPrice) {
        this.pId = pId;
        this.pName = pName;
        this.pQty = pQty;
        this.pPrice = pPrice;
    }

}
