public class Carbohydrate extends food {
	private double sugar;
	public Carbohydrate (String name, double price, double sugar){
		super (name, price);
		this.sugar = sugar;
	}
	public double getSugar(){
		return sugar;
	}
	public double getFat(){
		return 0.0;
	}
	public double getPrice(){
		return super.getPrice();
	}
}
