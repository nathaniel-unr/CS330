public class GuitarHeroDanceController implements DanceController {
  public void Step(DanceController.direction dir) {
    System.out.println("GuitarHeroDanceController: Stepped " + dir);
  }
}
