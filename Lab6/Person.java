public abstract class Person implements HighIncome, Sortable {
	private Name personName;
	private Person spouse = null;

	public abstract double getSalary();

	//constructor takes name string and sets it in the instance variable
	public Person (String fullName){
		personName = new Name (fullName);
	}
	public String getFName(){
		return personName.getFName();
	}
	public String getLName(){
		return personName.getLName();
	}
	//set spouse takes another person as an argument
	public void setSpouse (Person spouse){
		this.spouse = spouse;
	}

	//get name returns the person's name
	public String getName(){
		return personName.toString();
	}

	//toString checks if this person has a spouse or not and returns
	//both names if there is
	public String toString (){
		if (spouse == null)
			return ("Name is " + this.getName() );
		else
			return ("Name is " + this.getName() + " Married to " + spouse.getName());
	}

	//Implementation of interfaces
	public boolean lessThan (Sortable anotherName){
		return personName.lessThan(anotherName);
	}

	public boolean fatCat(){
		if (this instanceof NewWorker){
			if (((NewWorker)this).getSalary() > 3000.0)
				return true;
			else return false;
		}
		else return false;
	}


	//getFamilyIncome checks if this person is married and if they or their spouse is working
	//to get salary the person needs to be casted as a NewWorker
	public double getFamilyIncome (){
		if (spouse!= null)
			return getSalary() + spouse.getSalary();
		else
			return getSalary();
	}
}
