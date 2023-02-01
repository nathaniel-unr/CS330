public abstract class slotMachine {
  public String name;
  public String cabinetSize;
  public String displayType;
  public String paymentType;
  public String GPU;
  public String OS;

  public void prepare() {
    System.out.println("Preparing " + name);
    System.out.println("Fetching components: " + cabinetSize + ", " + displayType + ", " + paymentType + ", " + GPU
        + ", " + OS + ".\n");
  }

  public String getName() {
    return name;
  }
}