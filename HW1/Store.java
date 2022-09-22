public class Store extends Shop {
  public Store() {
    this.paymentBehavior = new CashPaymentBehavior();
    this.orderBehavior = new ComputerOrderBehavior();
  }
}
