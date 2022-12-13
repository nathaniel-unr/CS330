public class BurgerOrderSlip implements OrderSlip {
  public void orderUp(ShortOrderCook cook) {
    cook.makeBurger();
  }
}
