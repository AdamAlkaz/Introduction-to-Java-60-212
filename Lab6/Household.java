public class Household {
	Person houseMembers [];
	private int numHouseholdMems = 0;
	public Household(){
			houseMembers = new Person [10];
	}

	public void insertNewHouseholdMember (Person Member){
		houseMembers [numHouseholdMems] = Member;
		numHouseholdMems++;
	}

	public String toString(){
		String wholeString = new String();
		for (int i = 0; i < numHouseholdMems; i++){
			wholeString +=  houseMembers[i].toString() + "\n";
		}
		return wholeString;
	}


	public String sortHouseholdMembers(){
		Sort wholeHouse = new Sort();
		wholeHouse.sortAnything(houseMembers, numHouseholdMems-1);
		return this.toString();
	}

	public int findNumberOfFatCats(){
		int numFatCat = 0;
		for (int i = 0; i < numHouseholdMems; i++){
			if (houseMembers[i].fatCat())
				numFatCat++;
		}
		return numFatCat;
	}
}
