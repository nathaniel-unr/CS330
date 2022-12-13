public abstract class Shop {
  protected PaymentBehavior paymentBehavior;
  protected OrderBehavior orderBehavior;

  public void takePayment() {
    this.paymentBehavior.takePayment();
  }

  public void takeOrder() {
    this.orderBehavior.takeOrder();
  }

  public void setPaymentBehavior(PaymentBehavior paymentBehavior) {
    this.paymentBehavior = paymentBehavior;
  }

  public void setOrderBehavior(OrderBehavior orderBehavior) {
    this.orderBehavior = orderBehavior;
  }
}
