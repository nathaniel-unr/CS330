abstract class Tree {
  protected String description;

  public Tree() {
    this.description = "";
  }

  public String getDescription() {
    return this.description;
  }

  public abstract float cost();

  public <T extends TreeDecorator> T getDecorator(Class<T> class_) {
    return null;
  }
}
