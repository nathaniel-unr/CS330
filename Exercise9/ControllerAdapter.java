public class ControllerAdapter implements GuitarController, DanceController {
  private GuitarHeroGuitarController guitar;
  private GuitarHeroDanceController dance;

  private DanceController.direction danceBuffer = null;

  public ControllerAdapter(GuitarHeroGuitarController guitar) {
    this.guitar = guitar;
  }

  public ControllerAdapter(GuitarHeroDanceController dance) {
    this.dance = dance;
  }

  public void PressFretButton(GuitarController.colors button) {
    this.dance.Step(ControllerAdapter.mapColorsToDirection(button));
  }

  public void PressPick() {}

  public void PressTremelo() {}

  public void Step(DanceController.direction dir) {
    if (this.danceBuffer == null) {
      this.danceBuffer = dir;
      return;
    }

    if (danceBuffer == DanceController.direction.MIDDLE) {
      if (dir == DanceController.direction.LEFT) {
        this.guitar.PressPick();
        this.danceBuffer = null;
        return;
      } else if (dir == DanceController.direction.RIGHT) {
        this.guitar.PressTremelo();
        this.danceBuffer = null;
        return;
      }
    }

    if (this.danceBuffer != dir)
      this.guitar.PressFretButton(ControllerAdapter.mapDirectionToColors(this.danceBuffer));
    this.guitar.PressFretButton(ControllerAdapter.mapDirectionToColors(dir));

    this.danceBuffer = null;
  }

  private static GuitarController.colors mapDirectionToColors(DanceController.direction dir) {
    switch (dir) {
      case FORWARD:
        return GuitarController.colors.GREEN;
      case LEFT:
        return GuitarController.colors.RED;
      case RIGHT:
        return GuitarController.colors.YELLOW;
      case BACK:
        return GuitarController.colors.BLUE;
      case MIDDLE:
        return GuitarController.colors.ORANGE;
      default:
        System.out.println("mapDirectionToColors: Unknown direction " + dir);
        return null;
    }
  }

  private static DanceController.direction mapColorsToDirection(GuitarController.colors button) {
    switch (button) {
      case GREEN:
        return DanceController.direction.FORWARD;
      case RED:
        return DanceController.direction.LEFT;
      case YELLOW:
        return DanceController.direction.RIGHT;
      case BLUE:
        return DanceController.direction.BACK;
      case ORANGE:
        return DanceController.direction.MIDDLE;
      default:
        System.out.println("mapColorsToDirection: Unknown color " + button);
        return null;
    }
  }
}
