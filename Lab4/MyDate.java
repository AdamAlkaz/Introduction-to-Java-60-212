import java.util.StringTokenizer;

	public class MyDate {
		private int day;
		private int month;
		private int year;
		private String yearToken;
		private String enteredDate;
		public MyDate (String dateString){
			enteredDate = dateString;
			StringTokenizer dateToken = new StringTokenizer (enteredDate, "/");
			String dayToken = new String (dateToken.nextToken());
			String monthToken = new String (dateToken.nextToken());
			yearToken = new String (dateToken.nextToken());
			day = Integer.parseInt (dayToken);
			month = Integer.parseInt(monthToken);
			year = Integer.parseInt(yearToken);
		}
		public MyDate (MyDate d){
			this (d.enteredDate);
		}
		public String toString(){
			String toStringDate = "";
			if (month == 1)
				toStringDate += "January ";
			else if (month == 2)
				toStringDate += "February ";
			else if (month == 3)
				toStringDate += "March ";
			else if (month == 4)
				toStringDate += "April ";
			else if (month == 5)
				toStringDate += "May ";
			else if (month == 6)
				toStringDate += "June ";
			else if (month == 7)
				toStringDate += "July ";
			else if (month == 8)
				toStringDate += "August ";
			else if (month == 9)
				toStringDate += "September ";
			else if (month == 10)
				toStringDate += "October ";
			else if (month == 11)
				toStringDate += "November ";
			else if (month == 12)
				toStringDate += "December ";
			return (toStringDate + day + ", '" + yearToken.substring(2));
		}
		public boolean lessThan(MyDate d){
			if (year < d.year || (year == d.year && month < d.month) || (year ==d.year && month == d.month && day < d.day))
				return true;
			else
				return false;
		}
		public boolean equals (MyDate d){
			if (year == d.year && month == d.month && day == d.day)
				return true;
			else
				return false;
		}
}
