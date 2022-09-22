public class Kiosk extends Shop {
  public Kiosk() {
    this.paymentBehavior = new CashPaymentBehavior();
    this.orderBehavior = new TicketOrderBehavior();
  }
}
