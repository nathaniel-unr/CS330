public class Lights extends TreeDecorator {
  public Lights(Tree tree) {
    this.tree = tree;
  }

  public String getDescription() {
    return this.tree.getDescription() + ", Lights";
  }

  public float cost() {
    return this.tree.cost() + 5.0f;
  }
}
