public class CanadianStudentUnder65 extends CanadianStudent {
	public CanadianStudentUnder65 (String name){
		super (name, 5);
	}
	public CanadianStudentUnder65 (String name, int numOfCourses){
		super (name, numOfCourses);
	}
	public double computeFees(){
		if (super.getCourses() >= 4)
			return 800.0;
		else
			return super.getCourses()*200.0;
	}
	protected String findCountry(){
		return super.findCountry();
	}
	protected String getName(){
		return super.getName();
	}
	public boolean lessThan (Sortable anotherStudent){
		if (anotherStudent instanceof ForeignStudent || anotherStudent instanceof SeniorStudent){
			return false;
		}
		else if (super.getName().compareTo(((CanadianStudentUnder65)anotherStudent).getName()) < 0 ){
				return true;
		}
		return false;
	}
}
