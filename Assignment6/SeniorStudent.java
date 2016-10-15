public class SeniorStudent extends CanadianStudent {
	private double pension;
	public SeniorStudent (String name, int numOfCourses, double pension){
		super (name, numOfCourses);
		this.pension = pension;
	}
	public double computeFees(){
		return 50.0;
	}
	protected String findCountry(){
		return super.findCountry();
	}
	public String toString(){
		return super.toString() + " who gets pension $" + pension;
	}
	public boolean lessThan(Sortable anotherStudent){
		if (anotherStudent instanceof SeniorStudent){
			if (((Student)this).getName().compareTo(((Student)anotherStudent).getName()) <0){
				return true;
			}
			else return true;
		}
		return true;
	}
}
