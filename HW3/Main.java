public class Main {
  public static void main(String[] args) {
    Customer customer = new Customer();
    Waitress waitress = new Waitress();
    OrderSlip order = customer.createOrder();

    waitress.takeOrder(order);
    waitress.returnToCounter();
  }
}
