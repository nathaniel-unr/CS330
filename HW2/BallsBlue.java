public class BallsBlue extends TreeDecorator {
  public BallsBlue(Tree tree) {
    this.tree = tree;
  }

  public String getDescription() {
    return this.tree.getDescription() + ", Balls Blue";
  }

  public float cost() {
    return this.tree.cost() + 2.0f;
  }
}
