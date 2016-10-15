
import java.util.*;

public class Lab2Problem2 {
	public static void main (String a []){
		//Tell the user what the program does
		System.out.println("This program will check the validity of an entered name by the user");
		System.out.println("You may enter the following titles: Mr, Mrs, or Ms.");
		System.out.println("You may enter a full middle name or initial but it must be upper case followed by a period");
		System.out.println("First, last, and middle names must begin with a capital letter followed by lower cases \n");
		//initialize variables of the entire name and the first and last name
		String name = "", lastName = "", firstName = "";
		int numOfTokens;
		//flag if user inputted a title, initialized to false
		Boolean userInputtedTitle = false;
		StringTokenizer inputtedTokens;
		Scanner keyboard = new Scanner (System.in);
		//get the inputted name from the user
		name = keyboard.nextLine();
		//get tokens separated by a space
		inputtedTokens = new StringTokenizer (name," ");
		//get number of tokens entered
		numOfTokens = inputtedTokens.countTokens();
		//check if the name matches a single regular expression
		//title and middle initial/ name is optional
		//no first name is a title
		if (name.matches("(Mr |Ms |Mrs )?[A-Z&&[^(Mr |Ms |Mrs )]][a-z]+\\s([A-Z][.]\\s|[A-Z][a-z]+\\s)?[A-Z][a-z]+")){
			System.out.println(name + " is a valid name");
			//the name is valid
			firstName = inputtedTokens.nextToken();
			if (firstName.matches("(Mr|Ms|Mrs)")){
				//the first name is the seond token if a title was added
					firstName = inputtedTokens.nextToken();
					userInputtedTitle = true;
			}
			lastName = inputtedTokens.nextToken();
			if (numOfTokens > 2 && userInputtedTitle == false)
				lastName = inputtedTokens.nextToken();
			//the last name is the third token if there's 3 tokens and no title
			if (numOfTokens > 3)
				lastName = inputtedTokens.nextToken();
			//the last name is the fourth token if there's four tokens
			//tell the user the extracted first and last name
			System.out.println("First name: " + firstName + "     Last name: " + lastName);
		}
		else
			System.out.println(name + " is an invalid name");
			//if string doesn't match regular expression it's invalid
	}
}
