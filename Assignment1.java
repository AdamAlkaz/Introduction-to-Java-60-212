//A puzzle where every number is between 0 and 9
//Solve the equation TOO + TOO + TOO + TOO = GOOD
public class Assignment1 {
	public static void main (String [] a){

		int TOO, GOOD; //declaring variables and their types
		//It's known TOO and GOOD are integers since all letters are from 0 to 9

		System.out.println("This program will solve a cryptarithmetic puzzle for the following equation:");
		System.out.println("TOO + TOO + TOO + TOO = GOOD \n");
		//Telling the user what this program does

		for (int T = 0 ; T <= 9 ; T ++){
			for (int O = 0 ; O <= 9; O ++){
				for (int G = 0 ; G <= 9 ; G ++){
					for (int D = 0 ; D <= 9 ; D ++){
						/*incrementing every letter from 0 to 9 using nested loops so that
						  every possible scenario is accounted for */

						if (T != O && T != G && T != D && O != G && O != D && G != D){
							/* If the current sequence of T, G, O, and D are all unique to
							   one another then carry through to calculations */

							TOO = 100*T + 10*O + O; //Calculating TOO
							GOOD = 1000*G + 100*O + 10*O + D; //Calculating GOOD
							if (4*TOO == GOOD){ //Checking that TOO + TOO + TOO + TOO = GOOD

								System.out.println("A possible solution to the puzzle is:");
								System.out.println("T = " + T + "	O = " + O + "	G = " + G + "	D = " + D);
								//A possible solution has been found and the user is notified
							}
						}
					}
				}
			}
		}
	}
}
