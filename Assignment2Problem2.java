import java.util.*;
public class Assignment2Problem2 {
	public static void main (String a[]){
		Scanner keyboard = new Scanner (System.in);
		String inputtedDate = "";
		//Tell the user what the program does
		System.out.println("This program will tell the validity of inputted dates");
		System.out.println("Valid ways of inputting the date is DD/MM/YY or DD-MM-YY");
		System.out.println("The day can't exceed the number 31, the month can't exceed 12, and the year can't exceed 12");
		System.out.println("Also don't input any spaces");
		System.out.println("\nEnter the date:");
		//get the inputted date from the user
		inputtedDate = keyboard.nextLine();
		//use a single regular expression to check if a valid date was entered
		if (inputtedDate.matches("([0-2][0-9]|3[0-1])(-|/)(0[1-9]|1[0-2])(-|/)(0[0-9]|1[0-6])"))
			System.out.println("The date: " + inputtedDate + " is valid");
		else
			System.out.println("The date: " + inputtedDate +" is invalid");
		//tell the user the result
	}
}
