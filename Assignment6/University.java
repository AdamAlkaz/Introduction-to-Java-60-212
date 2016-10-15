public class University {
	private Student listOfStudents[];
	private int numberOfStudents;
	public University (int maximumNumberOfStudents){
		listOfStudents = new Student [maximumNumberOfStudents];
	}
	public boolean insertStudent ( Student aStudent){
		if (numberOfStudents != listOfStudents.length){
			listOfStudents[numberOfStudents] = aStudent;
			numberOfStudents++;
			return true;
		}
		else return false;
	}
	public int numberOfStudents (String nameOfCountry){
		int numOfCountry = 0;
		for (int i = 0; i<numberOfStudents;i++){
			if(nameOfCountry.compareTo(listOfStudents[i].findCountry())==0)
				numOfCountry++;
		}
		return numOfCountry;
	}
	public String toString(){
		String wholeString = new String();
		System.out.println("Number of Students in the University = " + numberOfStudents);
		for (int i = 0 ; i < numberOfStudents; i++ ){
			wholeString += listOfStudents[i].toString() + "\n";
		}
		return wholeString;
	}
	public void sortStudents(){
		Sort thisList = new Sort ();
		thisList.sortAnything(listOfStudents, numberOfStudents);
	}
}
