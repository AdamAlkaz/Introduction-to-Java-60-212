import java.util.*;
public class Assignment2Problem1 {
	public static void main (String a []){

		Scanner keyboard = new Scanner (System.in);
		String inputtedGrades = "";

		//Tell the user what the program does
		System.out.println("Type in your grades enclosed by '()' and seperated by a ';'" );
		System.out.println("Grades can either be inputted as a fraction or a percent out of 100");
		//Get the grades from the user
		inputtedGrades = keyboard.nextLine();
		//Have flags to see if the grade is a fraction or a percent
		Boolean isPercent = false , isFraction = false;
		//Check tokens separated by the ';' character
		StringTokenizer inputtedTokens = new StringTokenizer (inputtedGrades, ";");
		StringTokenizer fractionToken;
		//Get the number of grades entered
		int numOfGradeTokens, numOfGrades = 0;
		numOfGradeTokens = inputtedTokens.countTokens();
		//need strings and floats for percent, and denominator so that the number string can
		//be extracted from the tokens then the float can equal it
		float gradePercentFloat = 0, gradeNumeratorFloat = 0, gradeDenominatorFloat = 0;
		float gradeSum = 0;
		String gradeTokenString = "", gradePercentString, numeratorString, denominatorString;
		String numeratorToken="", denominatorToken = "";

		//for loop to check every token of the inputted grades
		for (int count = 0 ; count < numOfGradeTokens ; count++){
			//all strings we need for numbers are empty
			gradePercentString = "";
			numeratorString = "";
			denominatorString = "";
			//every iteration of the loop checks a new token in sequence
			gradeTokenString = inputtedTokens.nextToken();

			System.out.println("Inputted grade " + (count+1) + ": " + gradeTokenString);

			//Have a regular expression to check if grade is a percent
			//there can be any amount of spaces in the grade token
			//if its a percent it can only be up to 3 numbers in a row
			if (gradeTokenString.matches("[ ]*+[(][ ]*+[0-9]{1,3}+[ ]*+[)][ ]*+"))
				isPercent = true;
			else
				isPercent = false;
			//Have a regular expression to check if grades is a fraction
			if (gradeTokenString.matches("[ ]*+[(][ ]*+[0-9]+[ ]*+[/][ ]*+[0-9]+[ ]*+[)][ ]*+"))
				isFraction = true;
			else
				isFraction = false;

			if (isPercent == true){
			//if it's a percent
				//check every character of the grade token and look for a character that is a number
				for (int countCharacters = 0 ; countCharacters < gradeTokenString.length() ; countCharacters++ ){
					if (gradeTokenString.substring(countCharacters,countCharacters+1).matches("[0-9]")){
						//make the string to hold percent hold the number
						gradePercentString += gradeTokenString.substring(countCharacters,countCharacters +1);
					}
				}
				//the percent float equals the number string
				gradePercentFloat = Float.parseFloat(gradePercentString);

				//if the grade is less then 100 its a valid grade
				if (gradePercentFloat <= 100){
					//Tell the user the result
					System.out.println(gradePercentFloat + "%\n");
					//increase the number of valid grades
					numOfGrades += 1;
					//compute the sum of all valid grades
					gradeSum += gradePercentFloat;
				}
			}

			if (isFraction == true){
				//if its a fraction make new tokens separated by the '/' character
				fractionToken = new StringTokenizer (gradeTokenString,"/");
				//numerator is the token before '/'
				numeratorToken = fractionToken.nextToken();
				//check every character in the numerator token
				for (int countCharacters = 0 ; countCharacters < numeratorToken.length() ; countCharacters++ ){
					if (numeratorToken.substring(countCharacters,countCharacters + 1).matches("[0-9]")){
						//check every character to see if its a number and make a string of just numbers
						numeratorString += numeratorToken.substring(countCharacters,countCharacters + 1);
					}
				}
				//get the float from the string
				gradeNumeratorFloat = Float.parseFloat(numeratorString);
				//the denominator is the token after the '/'
				denominatorToken = fractionToken.nextToken();
				//check every character and make a string of just the numbers in the denominator
				for (int countCharacters = 0 ; countCharacters < denominatorToken.length() ; countCharacters++ ){
					if (denominatorToken.substring(countCharacters,countCharacters + 1).matches("[0-9]"))
						denominatorString += denominatorToken.substring(countCharacters,countCharacters + 1);
				}
				//get the float from the denominator
				gradeDenominatorFloat = Float.parseFloat(denominatorString);
				//get the percent from the fraction
				gradePercentFloat = (gradeNumeratorFloat/gradeDenominatorFloat)*100;
				//if the grade is less then 100 it's valid
				if (gradePercentFloat <= 100){
					//Tell the user the result
					System.out.println(gradePercentFloat + "%\n");
					//total valid grades increase by 1
					numOfGrades += 1;
					//compute sum of all grades
					gradeSum += gradePercentFloat;
				}
			}
			//if the input doesn't match the regular expression for a fraction and a percent or
			//the percent is over 100
			if ((isFraction == false && isPercent == false) || gradePercentFloat > 100)
				System.out.println("The input: " + gradeTokenString + " is an invalid input \n");
			//tell the user the input was invalid
		}
		//tell the user the computed average
		System.out.println("The average of all the grades is: " + gradeSum/numOfGrades + "%");
	}
}
