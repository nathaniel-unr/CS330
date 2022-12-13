
public class LimeJuice extends LiquorDecorator {
	public LimeJuice(Liquor liquor) {
		this.liquor=liquor;
	}
	
	public String getDescription() {
		return liquor.getDescription() + ", 1 oz lime juice";
	}
	
	public int calories() {
		return 8 + liquor.calories();
	} 
}
