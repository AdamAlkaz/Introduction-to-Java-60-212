public abstract class food {
	private String name;
	private double price;
	public food (String name, double price){
		this.name = name;
		this.price = price;
	}
	public String toString(){
		return (name +" has a price $" + price);
	}
	public double getPrice(){
		return price;
	}
	public abstract double getFat();
	public abstract double getSugar();
}
