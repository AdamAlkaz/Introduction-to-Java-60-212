public abstract class CanadianStudent extends Student {
	public CanadianStudent (String name, int numOfClasses){
		super (name, numOfClasses);
	}
	protected String findCountry(){
		return "Canada";
	}
	public String toString(){
		return super.toString();
	}
	protected int getCourses(){
		return super.getCourses();
	}
	protected String getName(){
		return super.getName();
	}
	public abstract double computeFees();
}
