public class Ruffles extends TreeDecorator {
  public Ruffles(Tree tree) {
    this.tree = tree;
  }

  public String getDescription() {
    return this.tree.getDescription() + ", Ruffles";
  }

  public float cost() {
    return this.tree.cost() + 1.0f;
  }
}
