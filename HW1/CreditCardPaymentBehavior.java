import java.util.Scanner;

public class CreditCardPaymentBehavior implements PaymentBehavior {
    public void takePayment() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Credit Card #: ");
        int creditCardNumber = scanner.nextInt();
        
        System.out.print("Sale Amount: ");
        float sale = scanner.nextFloat();
    }
}
