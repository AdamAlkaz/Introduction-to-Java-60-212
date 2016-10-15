import java.util.*;
/*
 * Class MyDate is used to represent a date (day, month and year).
 */
public class MyDate {
	private int day;
	private int month;
	private int year;
/*
 * The constructor takes as its parameter a string describing the date in the format
 * DD/MM/YYYY. The constructor extracts the day, the month and the year using a strong tokenizer
 * and save this information in the instance variables.
 */
	public MyDate(String inputString){
		StringTokenizer tokenizeDate = new StringTokenizer(inputString, "/");
		this.day = Integer.parseInt(tokenizeDate.nextToken());
		this.month = Integer.parseInt(tokenizeDate.nextToken());
		this.year = Integer.parseInt(tokenizeDate.nextToken());
	}

	/*
	 * The copy constructor returns a copy of the supplied object of MyDate class.
	 */

	public MyDate(MyDate anotherDate){
		this.day = anotherDate.day;
		this.month = anotherDate.month;
		this.year = anotherDate.year;
	}

	/* equals method returns true if the date corresponding to anotherDate is the
	 * same as the current date.
	 */

	public boolean equals(MyDate anotherDate){
		if ((this.day == anotherDate.day) &&
			(this.month == anotherDate.month) &&
			(this.year == anotherDate.year)) {
			return true;
		}
		else {
			return false;
		}
	}

	/* Method lessThan returns true if the date corresponding to the parameter someDate of the method
	 * is earlier than the current date.
	 */


	public boolean lessThan (MyDate someDate ){

		if  (year > someDate.year)
			return false;
		else if  (year < someDate.year)
			return true;
		else if (month < someDate.month)
			return true;
		else if (month > someDate.month)
			return false;
		else if (day < someDate.day )
			return true;
		else
			return false;

	}

	/*
	 * Mthod toString return a string describing the date in the following format:
	 * a) the month name, a space, followed by
	 * b) the date, a space, a quote, followed by
	 * c) the last two digits of the year
	 */

	public String toString(){
		String monthNames[] = {"January", "February", "March", "April", "May",
                "June", "July", "August", "September", "October",
                "November", "December"};

		if (year % 100 < 10){
			return ( monthNames[month-1] + " " + day +  ", '0" + year % 100);
		} else {
			return (monthNames[month-1] + " " + day +  ", '" + year % 100);
		}
	}
}
