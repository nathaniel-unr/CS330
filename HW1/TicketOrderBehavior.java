import java.util.Scanner;

public class TicketOrderBehavior implements OrderBehavior {
  public void takeOrder() {
    System.out.print("Order Number: ");
    Scanner scanner = new Scanner(System.in);
    int orderId = scanner.nextInt();

    System.out.println("Order number is " + orderId);
  }
}
