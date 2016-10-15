public class Worker {
	//static variable for all workers in the company
	private static int howManyWorkers = 0;
	private int workerNumber;
	private Name workerName ;
	private String nameString;
	private MyDate dateJoiningCompany;
	private double Salary;
	private String dateString;

	//supervisor variables initialized to null in case worker is CEO
	private Worker Supervisor = null;
	private Name supervisorName = null;
	//constructor if salary is given
	public Worker (String givenName, String givenDate, double givenSalary){
		nameString = givenName;
		dateString = givenDate;
		howManyWorkers ++;
		workerNumber = new Integer (howManyWorkers);
		workerName= new Name (nameString);
		dateJoiningCompany = new MyDate (dateString);
		Salary = new Double (givenSalary);
	}
	//overload constructor if salary isn't given
	public Worker (String givenName, String givenDate){
		nameString = givenName;
		dateString = givenDate;
		howManyWorkers++;
		workerNumber = new Integer (howManyWorkers);
		workerName = new Name (nameString);
		dateJoiningCompany = new MyDate (dateString);
		Salary = new Double (0.0);
	}
	//copy constructor
	public Worker (Worker d){
		workerName = new Name (d.nameString);
		dateJoiningCompany = new MyDate (d.dateString);
		Salary = new Double (d.Salary);
		workerNumber = new Integer (d.workerNumber + 1);
	}
	public void setSalary (double givenSalary){
		Salary = givenSalary;
	}
	public void setSupervisor (Worker givenSupervisor){
		Supervisor = givenSupervisor;
		if (Supervisor != null){
			supervisorName = new Name (Supervisor.nameString);
	}
	//if no supervisor given
	else{
		Supervisor = null;
		supervisorName = null;
	}
	}
	public static int getHowManyWorkers(){
		return new Integer (howManyWorkers);

	}
	public Name getSupervisorName (){
		return (supervisorName);
	}
	public String toString(){
		if (Supervisor != null)
			return ("Worker Number: " +  workerNumber + "\nWorker's Name: " + workerName.toString() + "\nDate Joined: " + dateJoiningCompany.toString() + "\nSupervisor's Name: " + supervisorName.toString() + "\nSalary: $" + Salary);
		else
			return ("Worker Number: " + workerNumber + "\nWorker's Name: " + workerName.toString() + "\nDate Joined: " + dateJoiningCompany.toString() + "\nSalary: $" + Salary);
	}
}
