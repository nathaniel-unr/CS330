
public class Bitters extends LiquorDecorator {
	public Bitters(Liquor liquor) {
		this.liquor=liquor;
	}
	
	public String getDescription() {
		return liquor.getDescription() + ", 1 dash bitters";
	}
	
	public int calories() {
		return 20 + liquor.calories();
	}
}
