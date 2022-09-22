public class BallsSilver extends TreeDecorator {
  public BallsSilver(Tree tree) {
    this.tree = tree;
  }

  public String getDescription() {
    return this.tree.getDescription() + ", Balls Silver";
  }

  public float cost() {
    return this.tree.cost() + 3.0f;
  }
}
