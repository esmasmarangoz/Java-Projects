public class OrderHistory {

    private OrderNode head;

    private class OrderNode {
        int orderID;
        double orderAmount;
        OrderNode next;

        OrderNode(int orderID, double orderAmount) {
            this.orderID = orderID;
            this.orderAmount = orderAmount;
            this.next = null;
        }
    }

    public void addOrder(int orderID, double orderAmount) {
        OrderNode newNode = new OrderNode(orderID, orderAmount);
        if (head == null) {
            head = newNode;
        } else {
            OrderNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public boolean removeOrder(int orderID) {
        if (head == null) {
            return false;
        }
        if (head.orderID == orderID) {
            head = head.next;
            return true;
        }
        OrderNode current = head;
        while (current.next != null && current.next.orderID != orderID) {
            current = current.next;
        }
        if (current.next == null) {
            return false;
        }
        current.next = current.next.next;
        return true;
    }

    public void displayOrderHistory() {
        OrderNode current = head;
        while (current != null) {
            System.out.println("Order ID: " + current.orderID + ", Order Amount: " + current.orderAmount);
            current = current.next;
        }
    }

    public double calculateTotalSales() {
        double totalSales = 0;
        OrderNode current = head;
        while (current != null) {
            totalSales += current.orderAmount;
            current = current.next;
        }
        return totalSales;
    }
}
