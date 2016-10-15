public class Manager extends NewWorker {
	private NewWorker employeesSupervised []= new NewWorker [11];
	private int numWorkersSupervised;

	//NewWorker and Person takes care of constructors of name date and optional salary
	public Manager (String name, String date, double salary){
		super (name, date,salary);
	}
	public Manager (String name, String date){
		super (name,date);
	}

	//setting salary using NewWorker method
	public double getSalary(){
		return super.getSalary();
	}

	//add worker is called upon by the setSupervisor method in NewWorker
	public void addWorker (NewWorker w){
		if (numWorkersSupervised < 10){
			employeesSupervised [numWorkersSupervised] = w;
			numWorkersSupervised++;
			//salary is current salary plus 100 for every worker
			super.setSalary(super.getSalary() + 100);
		}
	}

	public void deleteWorker (NewWorker w){
		boolean removed = false;
		for (int i = 0 ; i < numWorkersSupervised; i++){
			//use NewWorker casting to access equals method
			if (((NewWorker)employeesSupervised [i]).equals(w)){
				employeesSupervised [i] = employeesSupervised[i+1];
				removed = true;
			}
			//once worker is removed shift elements of array left
			//this is to remove the worker while keeping the rest of the
			//array empty NewWorker objects
			else if (removed == true)
				employeesSupervised[i] = employeesSupervised [i+1];
		}

		//if worker got removed, deduct pay
		if (removed == true){
			numWorkersSupervised --;
			super.setSalary(super.getSalary() - 100);
		}
	}

	//toStrign uses toString of NewWorker
	public String toString(){
		String wholeString = super.toString() + "\n" + "Supervises: " + "\n";
		//cast employee supervised to NewWorker to get the name
		for (int i = 0 ; i < numWorkersSupervised; i++)
			wholeString += ((NewWorker)employeesSupervised [i]).getName() + "\n";
		return wholeString;
	}
}
