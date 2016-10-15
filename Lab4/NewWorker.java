public class NewWorker extends Person {
	private static int howManyWorkers = 0;
	private int workerNumber;
	private MyDate dateJoiningCompany;
	private double salary;
	private NewWorker supervisor;


	//send to other constructor with no salary inputted
	public NewWorker(String name, String date, double salary){
		this(name, date);
		this.salary = salary;
	}

	public NewWorker(String name, String date){
		//send to Person class passing through name
		super (name);
		dateJoiningCompany = new MyDate(date);
		this.salary = 0.0;
		howManyWorkers++;
		workerNumber = howManyWorkers;
	}

	//static increase number of workers
	public static int getHowManyWorkers(){
		return howManyWorkers;
	}

	//method to set salary
	public void setSalary(double salary) {
		this.salary = salary;
	}

	//method to return salary
	public double getSalary (){
		return salary;
	}

	//set supervisor of another NewWorker
	public void setSupervisor(NewWorker supervisor) {
		this.supervisor = supervisor;
	}

	//get name method returns name from person class
	public String getName(){
		return super.getName();
	}

	//get supervisor returns name of the supervisor from it's person variables
	public String getSupervisor (){
		return supervisor.getName();
	}

	public String toString(){
		String nameString;
		//toString utilizes toString from Person attributes
		if (supervisor != null){
			nameString = "Worker Number " + workerNumber + " " + super.toString() + ".\n" +
			"Joined the company on: " +
			dateJoiningCompany.toString() + "\n" +
			"Salary: $" + this.getSalary() + "\n" +
			"Name of supervisor: " + getSupervisor();
		}
		else {
			nameString = "Worker Number " + workerNumber + " " + super.toString() + ".\n" +
			"Joined the company on: " +
			dateJoiningCompany.toString() + "\n" +
			"Salary: $" + this.getSalary() + "\n" +
			"has no supervisor";
		}
		return nameString;
	}
}
