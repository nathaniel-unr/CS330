public class Main {
  public static void main(String[] args) {
    GuitarHeroGuitarController guitar = new GuitarHeroGuitarController();
    GuitarHeroDanceController dance = new GuitarHeroDanceController();

    System.out.println("Guitar Controller:");
    guitar.PressFretButton(GuitarController.colors.GREEN);
    guitar.PressPick();
    guitar.PressTremelo();
    System.out.println();

    System.out.println("Dance Controller:");
    dance.Step(DanceController.direction.FORWARD);
    System.out.println();

    System.out.println("GuitarToDance Adapter:");
    DanceController guitarToDance = new ControllerAdapter(guitar);
    // DO: guitar.PressFretButton(GuitarController.colors.GREEN);
    guitarToDance.Step(DanceController.direction.FORWARD);
    guitarToDance.Step(DanceController.direction.FORWARD);

    // DO: guitar.PressPick();
    guitarToDance.Step(DanceController.direction.MIDDLE);
    guitarToDance.Step(DanceController.direction.LEFT);

    // DO: guitar.PressTremelo();
    guitarToDance.Step(DanceController.direction.MIDDLE);
    guitarToDance.Step(DanceController.direction.RIGHT);
    System.out.println();

    System.out.println("GuitarToDance Adapter:");
    GuitarController danceToGuitar = new ControllerAdapter(dance);
    // DO: dance.Step(DanceController.direction.FORWARD);
    danceToGuitar.PressFretButton(GuitarController.colors.GREEN);
    System.out.println();
  }
}
