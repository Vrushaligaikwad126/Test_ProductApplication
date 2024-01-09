package application.UI;

import application.DAO.Service;
import application.DAO.ServiceImplementation;
import application.DTO.Order;
import application.DTO.Product;

import java.util.List;
import java.util.Scanner;

public class MainApp {
    static Scanner sc = new Scanner(System.in);
    static Service service = new ServiceImplementation();

    public static void main(String[] args) {

        System.out.println("SELECT!!");
        System.out.println("*******************************");
        System.out.println("1.DISPLAY ALL PRODUCTS");
        System.out.println("2.REMOVE PRODUCT");
        System.out.println("3.UPDATE PRODUCT");
        System.out.println("4.PLACE ORDER");
        System.out.println("5.DISPLAY ALL ORDERS");
        System.out.println("6.EXIT");
        int ch = sc.nextInt();

        switch (ch) {
            case 1:
                displayAllProducts();
                break;
            case 2:
                //removeProduct();
                break;
            case 3:
                //updateProduct();
                break;
            case 4:
                 placeOrder();
                break;
            case 5:
                 displayAllOrders();
                break;
            case 6:
                System.exit(0);
            default:
                System.out.println("PLEASE ENTER VALID CHOICE");


        }
        main(args);
    }

    private static void displayAllOrders() {
        for (Order ol: service.displayAllOrders()){
            System.out.println( ol.getoId()+"\t\t"+ol.getCustomer_Name()+"\t\t"+ol.getCustomer_Name()+"\t\t"+ol.getpQty()+"\t\t"+ol.getTotal_Bill());
        }
    }

    private static void placeOrder() {
            System.out.println("ENTER YOUR NAME");
            String customerName= sc.next();
            System.out.println("ENTER PRODUCT ID");
            int productId=sc.nextInt();
            System.out.println("ENTER PRODUCT QUANTITY");
            int productQty=sc.nextInt();

            Order newOrder= new Order(customerName,productId,productQty);

            boolean status= service.placeOrder(newOrder);

            if (status)
                System.out.println("ORDER PLACED!!");
            else
                System.out.println("ORDER NOT PLACED");

        }


    private static void displayAllProducts() {
        List<Product> product=service.DisplayAllProducts();
        for (Product p:product)
            System.out.println(p.getpId()+"\t\t"+p.getpName()+"\t\t"+p.getpPrice());
    }
}