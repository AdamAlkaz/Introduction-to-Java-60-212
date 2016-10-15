public class Household {
	Person houseMembers [];
	private int numHouseholdMems = 0;
	private int maxHouseMems;
	public Household(){
		Household householdMembers = new Household();
		householdMembers.houseMembers = new Person [10];
	}
	public Household (int numOfMem){
		maxHouseMems = numOfMem;
		houseMembers = new Person [maxHouseMems];
	}
	public void insertNewHouseholdMember (Person Member){
		if (numHouseholdMems < maxHouseMems){
			houseMembers [numHouseholdMems] = Member;
			numHouseholdMems++;
		}
	}
	public String toString(){
		String thingy = new String();
		for (Person member:houseMembers){
			thingy +=  member.toString() + "\n";
		}
		return thingy;
	}
}
