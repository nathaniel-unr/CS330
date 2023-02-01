class Main {
  public static void main(String[] args) {
    slotFactory jersey = new jerseyFactory();
    slotFactory nevada = new nevadaFactory();
    slotFactory washington = new washingtonFactory();

    slotMachine slot1 = jersey.orderSlot("straight");
    System.out.println("Jersey store ordered a " + slot1.getName());
    slot1.prepare();

    slotMachine slot2 = nevada.orderSlot("bonus");
    System.out.println("Nevada store ordered a " + slot2.getName());
    slot2.prepare();
    
    slotMachine slot3 = washington.orderSlot("progressive");
    System.out.println("Washington store ordered a " + slot3.getName());
    slot3.prepare();
  }
}