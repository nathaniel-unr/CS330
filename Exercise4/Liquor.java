
public abstract class Liquor {
	String description = "unknown cocktail";
	
	public String getDescription() {
		return description;
	}
	
	public abstract int calories();
}
