public abstract class Student implements FeeCalculator, Sortable {
	private static int studentNumber = 1;
	private int thisStudentNumber;
	private String studentName;
	private int numberOfCoursesTaken;
	protected abstract String findCountry();
	public abstract double computeFees();
	public Student (String name, int numOfCourses){
		studentName = name;
		numberOfCoursesTaken = numOfCourses;
		thisStudentNumber = studentNumber;
		studentNumber++;
	}
	protected int getCourses(){
		return numberOfCoursesTaken;
	}
	protected String getName(){
		return studentName;
	}
	public String toString(){
		return ("Student #: " + thisStudentNumber + ", Name: " + studentName +" is from " + findCountry() +"; pays fees $" +computeFees());
	}
}
