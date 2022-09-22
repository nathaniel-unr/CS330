
public class Cocktail {

	public static void main(String[] args) {
		Liquor liquor = new Gin();
		liquor = new LimeJuice(liquor);
		liquor = new Cherry(liquor);
		liquor = new Sugar(liquor);
		liquor = new Lime(liquor);
		System.out.println(liquor.getDescription() + " calories: " + liquor.calories() + "\n");
	}

}
