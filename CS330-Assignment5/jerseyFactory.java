public class jerseyFactory extends slotFactory{
  slotMachine createSlot(String type){
    if(type.equals("straight")){
      return new jerseyStraightSlot();
    } else if(type.equals("bonus")){
      return new jerseyBonusSlot();
    } else if(type.equals("progressive")){
      return new jerseyProgressiveSlot();
    } else return null;
  }
}