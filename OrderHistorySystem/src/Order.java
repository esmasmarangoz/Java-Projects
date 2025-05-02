public class Order {
    private int orderID;
    private String customerName;
    private String orderDate;
    private double totalAmount;

    public Order(int orderID, String customerName, String orderDate, double totalAmount){
        this.orderID = orderID;
        this.customerName = customerName;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
    }
    @Override
    public String toString(){
        return "Order ID: " + orderID + "\nCustomer Name: " + customerName + "\nOrder Date: " + orderDate + "\nTotal Amount: ";
    }
}
