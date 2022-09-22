public abstract class TreeDecorator extends Tree {
  protected Tree tree;

  public abstract String getDescription();

  public <T extends TreeDecorator> T getDecorator(Class<T> class_) {
    try {
      return class_.cast(this);
    } catch (ClassCastException e) {
      return this.tree.getDecorator(class_);
    }
  }
}
