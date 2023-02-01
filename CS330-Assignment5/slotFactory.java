public abstract class slotFactory{
  public slotMachine orderSlot(String type){
    slotMachine slotmachine;

    slotmachine = createSlot(type);
    return slotmachine;
  }
  abstract slotMachine createSlot(String tpye);
}