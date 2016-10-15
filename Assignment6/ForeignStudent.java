public class ForeignStudent extends Student {

	private String countryOfOrigin;
	public ForeignStudent(String studentName, int numberOfCoursesTaken, String countryOfOrigin, MyDate dateOfEntryToCanada){
		super (studentName , numberOfCoursesTaken);
		this.countryOfOrigin = countryOfOrigin;
		}
	protected String findCountry(){
		return countryOfOrigin;
	}
	public double computeFees(){
		return super.getCourses()*1000.0;
	}
	protected String getName(){
		return super.getName();
	}
	public boolean lessThan(Sortable anotherStudent){
		if (anotherStudent instanceof SeniorStudent )
			return false;
		else if (anotherStudent instanceof ForeignStudent){
			if (super.getName().compareTo(((ForeignStudent)anotherStudent).getName())>0)
				return false;}
		return true;
	}
}
