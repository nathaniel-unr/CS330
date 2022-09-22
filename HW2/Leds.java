public class Leds extends TreeDecorator {
  public Leds(Tree tree) {
    this.tree = tree;
  }

  public String getDescription() {
    return this.tree.getDescription() + ", Leds";
  }

  public float cost() {
    return this.tree.cost() + 10.0f;
  }
}
