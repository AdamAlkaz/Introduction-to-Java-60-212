import java.util.StringTokenizer;
import java.util.Scanner;

public class GroceryInventory {
	//hold inventory, price, fat, and sugar in arrays
	//Kg of apples, dozens of oranges, Kg of chicken, Kg of Salmon, loaves of bread, Kg of rice
	private static double amount [] = {500.0, 40.0, 600.0, 400.0, 50.0, 70.0};
	private double price [] = {1.89, 2.36, 9.89, 11.2, 4.5, 7.4};
	private double fat [] = {0.0, 0.0, 100.0, 72.0, 0.0, 0.0};
	private double sugar [] = {150.0, 130.0, 0.0, 0.0, 400.0, 600.0};
	private static double totalSugar;
	private double shopListFat = 0;
	private double shopListSugar = 0;
	private double shopListPrice = 0;
	//fat and sugar for Kg of apples, dozens of oranges, Kg of chicken, Kg of Salmon, loaves of bread, Kg of rice
	public GroceryInventory(){
	}
	public void buy (int item, double amount){
		food thisFood = null;
		if (item==1){
			thisFood = new Fruit ("Apple", price[0]*amount, sugar[0]*amount);
			if (this.amount[0] < amount)
				System.out.println("Not enough Apples");
			else
				this.amount[0] -= amount;
		}
		else if (item==2){
			thisFood = new Fruit ("Orange", price[1]*amount, sugar[1]*amount);
			if (this.amount[1] < amount)
				System.out.println("Not enough Oranges");
			else
				this.amount[1] -= amount;
		}
		else if (item==3){
			thisFood = new MeatFish ("Chicken", price[2]*amount, fat[2]*amount);
			if (this.amount[2] < amount)
				System.out.println("Not enough Chicken");
			else
				this.amount[2] -= amount;
		}
		else if (item==4){
			thisFood = new MeatFish ("Salmon", price[3]*amount, fat[3]*amount);
			if (this.amount[3] < amount)
				System.out.println("Not enough Salmon");
			else
				this.amount[3] -= amount;
		}
		else if (item==5){
			thisFood = new Carbohydrate ("Bread", price[4]*amount, sugar[4]*amount);
			if (this.amount[4] < amount)
				System.out.println("Not enough Bread");
			else
				this.amount[4] -= amount;
		}
		else if (item==6){
			thisFood = new Carbohydrate ("Rice", price[5]*amount, sugar[5]*amount);
			if (this.amount[5] < amount)
				System.out.println("Not enough Rice");
			else
				this.amount[5] -= amount;
		}
		else if (item == 0){
			this.donePurchase();
		}
		if (thisFood != null){
			shopListPrice += thisFood.getPrice();
			shopListFat += thisFood.getFat();
			shopListSugar += thisFood.getSugar();
			totalSugar += thisFood.getSugar();
		}
	}
	public void donePurchase(){
		System.out.println("There was "+ shopListFat +" grams of fat\n" + shopListSugar
				+ " grams of sugar\n" + "for $" + shopListPrice +"\n" +
				"Total sugar in all purchases is " + totalSugar+" grams");
		shopListFat = 0;
		shopListPrice = 0;
		shopListSugar = 0;
		shopListFat = 0;
		this.Inventory();
	}
	public void Inventory(){
		System.out.println("Enter the number you wish to buy followed by  space character and the amount ypu want to buy.");
		System.out.println("1) Apples 150g/Kg of sugar, $1.89/Kg, and " + amount[0] + "Kg left in stock");
		System.out.println("2) Oranges 130g/dozen of sugar, $2.36/dozen, and " + amount[1] + " dozens left in stock");
		System.out.println("3) Chicken 100g/Kg of fat, $9.89/Kg, and " + amount[2] + "Kg left in stock");
		System.out.println("4) Salmon 72g/Kg of fat, $11.2/Kg, and " + amount[3] + "Kg left in stock");
		System.out.println("5) Bread 400g/loaf of sugar, $4.5/loaf, and " + amount[4] + " loaves left in stock");
		System.out.println("6) Rice 600g/Kg of sugar, $7.4/Kg, and " + amount[5] + "Kg left in stock");
		System.out.println("0 0) to end this purchase");
	}
	public static void main (String args[]){
		StringTokenizer Tokens;
		Scanner keyboard = new Scanner (System.in);
		GroceryInventory store = new GroceryInventory();
		int item;
		double amount;
		String enteredString = null;
		store.Inventory();
		enteredString= keyboard.nextLine();
		while(enteredString != "-1"){
			Tokens = new StringTokenizer (enteredString," ");
			item = Integer.parseInt(Tokens.nextToken());
			amount = Double.parseDouble(Tokens.nextToken());
			store.buy(item,amount);
			enteredString= keyboard.nextLine();
		}
	}
}
