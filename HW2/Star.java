public class Star extends TreeDecorator {
  private boolean hasStar = false;

  public Star(Tree tree) {
    this.hasStar = tree.getDecorator(Star.class) != null;
    if (this.hasStar) System.out.println("Tree already has a star!");
    this.tree = tree;
  }

  public String getDescription() {
    return this.tree.getDescription() + (this.hasStar ? "" : ", a Star");
  }

  public float cost() {
    return this.tree.cost() + (this.hasStar ? 0.0f : 4.0f);
  }
}
