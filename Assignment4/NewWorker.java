public class NewWorker extends Person {
	private static int howManyWorkers = 0;
	private int workerNumber;
	private MyDate dateJoiningCompany;
	private double salary;
	private Manager supervisor;

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

	//setSupervisor takes a Manager object and passes this object
	//to addWorker method for the manager object
	public void setSupervisor(Manager supervisor) {
		this.supervisor = supervisor;
		supervisor.addWorker(this);
	}

	//Manager method getName get name from NewWorker
	//which gets name from Person attributes
	public String getSupervisor (){
		return supervisor.getName();
	}

	//getName gets name from Person
	public String getName(){
		return super.getName();
	}

	//equals method says if two objects have the same name, supervisor, salary, date joining company, and worker number
	//then it's the same Worker
	public boolean equals (NewWorker w){
		if (this.getName().equals( w.getName())&& this.getSalary() == w.getSalary() && this.dateJoiningCompany.equals( w.dateJoiningCompany) && this.workerNumber == w.workerNumber)
			return true;
		else
			return false;
	}

	public String toString(){
		String nameString;

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
