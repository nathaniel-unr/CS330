public class BallsRed extends TreeDecorator {
  public BallsRed(Tree tree) {
    this.tree = tree;
  }

  public String getDescription() {
    return this.tree.getDescription() + ", Balls Red";
  }

  public float cost() {
    return this.tree.cost() + 1.0f;
  }
}
