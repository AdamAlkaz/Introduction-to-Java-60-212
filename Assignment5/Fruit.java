public class Fruit extends food {
	public double sugar;
	public Fruit (String name, double price, double sugar){
		super (name, price);
		this.sugar = sugar;
	}
	public double getFat(){
		return 0.0;
	}
	public double getSugar(){
		return 0.0;
	}
	public double getPrice(){
		return super.getPrice();
	}
}
