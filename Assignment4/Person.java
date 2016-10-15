public class Person {
	private Name personName;
	private Person spouse = null;
	public Person (String fullName){
		personName = new Name (fullName);
	}
	public void setSpouse (Person spouse){
		this.spouse = spouse;
	}
	public String getName(){
		return personName.toString();
	}

	public String toString (){
		if (spouse == null)
			return ("Name is " + this.getName() );
		else
			return ("Name is " + this.getName() + " Married to " + spouse.getName());
	}

	public double getFamilyIncome (){
		if (spouse == null){
			if(this instanceof NewWorker)
				return ((NewWorker)this).getSalary();
			else
				return 0.0;
		}
		else{
				if (spouse instanceof NewWorker && this instanceof NewWorker)
					return ((NewWorker)this).getSalary() + ((NewWorker)spouse).getSalary();
				else if (spouse instanceof NewWorker && !(this instanceof NewWorker))
					return ((NewWorker)spouse).getSalary();
				else
					return ((NewWorker)this).getSalary();
		}
	}
}
