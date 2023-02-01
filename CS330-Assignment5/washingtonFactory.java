public class washingtonFactory extends slotFactory{
  slotMachine createSlot(String type){
    if(type.equals("straight")){
      return new washingtonStraightSlot();
    } else if(type.equals("bonus")){
      return new washingtonBonusSlot();
    } else if(type.equals("progressive")){
      return new washingtonProgressiveSlot();
    } else return null;
  }
}