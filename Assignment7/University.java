public class University {
	private Student listOfStudents[];
	private Student storedListOfStudents[];
	private int numberOfStudents;
	public University (int maximumNumberOfStudents){
		listOfStudents = new Student [maximumNumberOfStudents];
		storedListOfStudents = new Student [maximumNumberOfStudents];
	}
	public boolean insertStudent ( Student aStudent){
		if (numberOfStudents != listOfStudents.length){
			listOfStudents[numberOfStudents] = aStudent;
			storedListOfStudents[numberOfStudents] = aStudent;
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
		String wholeString = new String("Number of Students in the University = " + numberOfStudents + "\n");
		for (int i = 0 ; i < numberOfStudents; i++ ){
			wholeString += listOfStudents[i].toString() + "\n";
		}
		return wholeString;
	}
	public String toStringUnsorted(){
		String wholeString = new String("Number of Students in the University = " + numberOfStudents + "\n");
		for (int i = 0 ; i < numberOfStudents; i++ ){
			wholeString += storedListOfStudents[i].toString() + "\n";
		}
		return wholeString;
	}
	public void sortStudents(){
		Sort thisList = new Sort ();
		thisList.sortAnything(listOfStudents, numberOfStudents);
	}
	public void reverse(){
		Student storeArray[] = new Student [numberOfStudents];
		for (int i = 0; i<numberOfStudents; i++){
			storeArray[i] = listOfStudents[i];
		}
		for (int i = 0; i<numberOfStudents; i++){
			listOfStudents[i] = storeArray[numberOfStudents-i-1] ;
		}
	}
}
