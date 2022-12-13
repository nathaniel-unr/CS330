public class GuitarHeroGuitarController implements GuitarController {
  public void PressFretButton(GuitarController.colors button) {
    System.out.println("GuitarHeroGuitarController: Pressed Fret Button " + button);
  }

  public void PressPick() {
    System.out.println("GuitarHeroGuitarController: Pressed Pick");
  }

  public void PressTremelo() {
    System.out.println("GuitarHeroGuitarController: Pressed Tremelo");
  }
}
