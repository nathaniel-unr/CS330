public class nevadaFactory extends slotFactory{
  slotMachine createSlot(String type){
    if(type.equals("straight")){
      return new nevadaStraightSlot();
    } else if(type.equals("bonus")){
      return new nevadaBonusSlot();
    } else if(type.equals("progressive")){
      return new nevadaProgressiveSlot();
    } else return null;
  }
}