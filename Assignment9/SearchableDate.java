import java.util.*;
public class SearchableDate implements Searchable{
		 /* Three integer instance variables to store the day, the month and the year. */
	    private int day;
	    private int month;
	    private int year;

	    /* This is the constructor with one String parameter that stores the date
	     * in the following format: "DD/MM/YY"
		 */

	    public SearchableDate(String dayString) {
	        StringTokenizer tokens;                           // declaration of the StringTokenizer instance variable
	        tokens = new StringTokenizer(dayString, "/");    // constructs a string tokenizer for the dayString using the delimiter "/"
	        day = Integer.parseInt(tokens.nextToken());     // get the first token and convert to an int representing the day
	        month = Integer.parseInt(tokens.nextToken()); // get the next token corresponding to the month
	        year = Integer.parseInt(tokens.nextToken());    // get next token, corresponding to the year (in 2 digits)
	    }

	    /* This is the toString method with no arguments which returns the date
	     * in the form of a string.
	     * The format of the string is as follows:
	     * name of month + space + date + comma + space + apostrophe + last 2 digits of year
		 */

	    public String toString() {
	        String listMonthNames[] = {"January", "February", "March", "April", "May", "June",
	        		             "July", "August", "September", "October", "November", "December"};  // declare a string to store the complete names of all months
	        String monthName;
	        int yearInTwoDigits;  // an integer to store the last 2 digits of the year
	        monthName = listMonthNames[month - 1];
	        yearInTwoDigits = year % 100;  // remove the first two digits of year

	        /* an integer can not store the heading 0 if it is less than 10,
	         * (example -  09 can not be store as an integer.
			 */

	        if (yearInTwoDigits < 10) {
	            return (monthName + " " + day + ", '0" + yearInTwoDigits); // if the year is less then 10, convert to a
				                                                           // two-digit form when forming a string
	        } else {
	            return (monthName + " " + day + ", '" + yearInTwoDigits);
	        }
	    }

	    /*
	     * The method keyMatches returns true if the current object satisfies the
	     * search criterion with respect to the value specified in key.
	     * In this particular definition, the parameter key in an object of the Integer
	     * class and represents a year value. If the year stored in the current
	     * object year contained in  the argument key,
	     * the method should return true. Otherwise the method returns false.
	     * In other words, keyMatches helps us locate the objects in my list with a
	     * matching year value.
		 */

	    public boolean keyMatches(Object key){
	    	//System.out.println("date class keymatch being called");
			int yearToSearch = (Integer) key;
	        if (yearToSearch == this.year) {
	            return true;
	        } else {
	            return false;
	        }
	    }

}
