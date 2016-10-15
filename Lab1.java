//Lab1 was to take a number from the user and output the prime number that comes after it
public class Lab1 {
	public static void main (String [] a){

		int input_number = 42, next_prime; //declare variables of an input value and the next prime number
		next_prime = input_number; //initialize variable: next_prime
		boolean done = false; //boolean variable to check if program is done
		boolean is_it_prime; //declare a boolean variable to check if a number is prime

		while (done == false){ //main while loop checking every increment past the input number and checking if it's prime
			next_prime++; //incrementing the next prime number
			is_it_prime = true; //initializing that the number is primed

			for (int counter = 2 ; counter < next_prime ; counter ++){ //checking every number past one to see if it can divide the number
				if (next_prime % counter == 0){ //a number other then 1 and itself was able to wholly divide the number
					is_it_prime = false; //thus the number is not primed
				}
			}

			if (is_it_prime == true){ //after the test, if no number divides into the current number other then 0 and itself
				done = true; //the current number is primed and thus the algorithm is done
			}
		}

		System.out.println("The next prime after " + input_number + " is: " + next_prime);
		//Tell the user the result of the algorithm and what the next prime number is relative to the input number
	}
}
