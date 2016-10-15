public class Student extends Person  {
	private String major;
	public Student (String name, String major){
		super (name);
		this.major = major;
	}
	public double getSalary(){
		return 0.0;
	}
	public String toString(){
		return (super.toString() + "\nMajors in: " + major);
	}
}
