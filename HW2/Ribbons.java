public class Ribbons extends TreeDecorator {
  public Ribbons(Tree tree) {
    this.tree = tree;
  }

  public String getDescription() {
    return this.tree.getDescription() + ", Ribbons";
  }

  public float cost() {
    return this.tree.cost() + 2.0f;
  }
}
