import java.util.ArrayList;

public class Waitress {
  private ArrayList<OrderSlip> orders = new ArrayList<OrderSlip>();
  private ShortOrderCook cook = new ShortOrderCook();

  public void takeOrder(OrderSlip order) {
    orders.add(order);
  }

  public void returnToCounter() {
    for (int i = 0; i < orders.size(); i++) orders.get(i).orderUp(cook);
  }
}
