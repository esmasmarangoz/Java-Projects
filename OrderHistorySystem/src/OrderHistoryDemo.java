public class OrderHistoryDemo {
    public static void main(String[] args) throws Exception {
        OrderHistory orderHistory = new OrderHistory();

        orderHistory.addOrder(1, 100.50);
        orderHistory.addOrder(2, 200.75);
        orderHistory.addOrder(3, 150.25);

        System.out.println("Order History:");
        orderHistory.displayOrderHistory();

        orderHistory.removeOrder(2);

        System.out.println("\nUpdated Order History:");
        orderHistory.displayOrderHistory();

        double totalSales = orderHistory.calculateTotalSales();
        System.out.println("\nTotal Sales: " + totalSales);
    }
}
