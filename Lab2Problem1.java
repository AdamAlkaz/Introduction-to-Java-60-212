
import java.util.*;

public class Lab2Problem1 {
	public static void main (String [] a){
		Scanner Keyboard;
		Keyboard = new Scanner (System.in);
		String inputtedLine;
		String longestWord = "";
		int numOfVow = 0;
		char currentChar = '\0', prevChar = '\0';
		String outputWord = "";
		String checkVowel = "";
		//initialize all variables
		//tell the user what the program does
		System.out.println("Enter in a sentence with any number of spaces inbetween words");
		System.out.println("The program will output the words between the spaces, ");
		System.out.println("tell the longest word, and the number of vowels \n");
		//get the sentence from the user
		inputtedLine = Keyboard.nextLine();
		//tell the user what they inputted
		System.out.println("You typed: " + inputtedLine + "\n");

		//for every character in the inputted sentence
		for (int count = 0; count < inputtedLine.length (); count++){
			//previous character equals the current character
			prevChar = currentChar;
			//the current character equals the character at the point of the count of the for loop
			currentChar = inputtedLine.charAt(count);
			//make a string of the current character
			checkVowel = inputtedLine.substring(count,count+1);
			//see if that character matches the regular expression of any vowel
			if (checkVowel.matches("[AEIOUaeiou]"))
				numOfVow += 1;
				//counts the total number of vowels
			if (currentChar == ' ' && prevChar != ' ' && prevChar != '\0'){
				//if its in the middle of the word and there's two spaces in a row
				//output the current word and set the word string to empty
				System.out.println(outputWord);
				outputWord = "";
			}
			else if (currentChar != ' ' && currentChar != '\0')
				outputWord += currentChar ;
				//if the current character isn't a space or a null character it must be a letter
				//make a concatination of the current character and the string
			//check for the longest word by checking length of current word and see if its longer
			//than a stored value of the length of the longest word
			if (longestWord.length() < outputWord.length())
				longestWord = outputWord;
			if (count == (inputtedLine.length() - 1))
				System.out.println(outputWord);
		}
		//tell the user the result and what's the longest word and number of vowels
		System.out.println("\nThe number of vowels is: " + numOfVow);
		System.out.println("The longest word is: " + longestWord);
	}
}
