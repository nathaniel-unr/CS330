public class Main {
  public static void main(String[] args) {
    Tree tree = new ColoradoBlueSpruce();
    tree = new Star(tree);
    tree = new Ruffles(tree);
    tree = new Star(tree);
    tree = new Ruffles(tree);

    System.out.println(tree.getDescription() + " costs $" + tree.cost());
  }
}
