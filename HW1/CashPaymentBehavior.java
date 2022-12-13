import java.util.Scanner;

public class CashPaymentBehavior implements PaymentBehavior {
  public void takePayment() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Sale Amount: ");
    float sale = scanner.nextFloat();

    float paymentAmount = 0.0f;
    for (int i = 0; paymentAmount < sale; i++) {
      if (i > 0) System.out.println("Invalid Payment Amount");
      System.out.print("Payment Amount: ");
      paymentAmount = scanner.nextFloat();
    }
    
    float change = paymentAmount - sale;
    
    System.out.println(String.format("Change: %.2f", change));
  }
}
