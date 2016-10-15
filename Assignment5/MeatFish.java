public class MeatFish extends food {
	public double fat;
	public MeatFish (String name, double price, double fat){
		super (name, price);
		this.fat = fat;
	}
	public double getFat(){
		return fat;
	}
	public double getSugar(){
		return 0.0;
	}
	public double getPrice(){
		return super.getPrice();
	}
}
