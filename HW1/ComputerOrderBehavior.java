public class ComputerOrderBehavior implements OrderBehavior {
  private static int nextOrderId = 1;

  public void takeOrder() {
    System.out.println("Order number is " + this.nextOrderId++);
  }
}
