// Author: Nathaniel Daniel

public class Main {
  public static void main(String[] args) {
    Shop kiosk = new Kiosk();
    Shop store = new Store();

    System.out.println("Kiosk Payment");
    kiosk.takePayment();
    System.out.println();

    System.out.println("Kiosk Order");
    kiosk.takeOrder();
    System.out.println();
    
    
    System.out.println("Store Cash Payment");
    store.setPaymentBehavior(new CashPaymentBehavior());
    store.takePayment();
    System.out.println();
    
    System.out.println("Store Credit Payment");
    store.setPaymentBehavior(new CreditCardPaymentBehavior());
    store.takePayment();
    System.out.println();
    
    System.out.println("Store Order");
    store.takeOrder();
    System.out.println();
  }
}
