import java.util.StringTokenizer;

public class Name implements Sortable{
	private String firstName;
	//null middle name in case person doesn't have middle name
	private String middleName = null;
	private String lastName;
	private String PrivNameString;
	public Name (String nameString) {
		PrivNameString = nameString;
		StringTokenizer nameTokens = new StringTokenizer (PrivNameString, " ");
		int numOfToken = nameTokens.countTokens();
		firstName = new String (nameTokens.nextToken());
		if (numOfToken == 3)
			middleName = new String (nameTokens.nextToken());
		lastName = new String (nameTokens.nextToken());
	}
	public String getFName(){
		return firstName;
	}
	public String getLName(){
		return lastName;
	}

	public Name (Name d){
		this (d.PrivNameString);
		firstName = new String (d.firstName);
		middleName = new String (d.middleName);
		lastName = new String (d.lastName);
	}
	public void setName (String fName, String mName, String lName){
		firstName = fName;
		middleName = mName;
		lastName = lName;
	}
	public void setName (String fName, String lName){
		firstName = fName;
		middleName = null;
		lastName = lName;
	}
	public boolean lessThan (Sortable anotherName){
		int compareLastName = this.getLName().compareTo(((Person)anotherName).getLName());
		int compareFirstName = this.getFName().compareTo(((Person)anotherName).getFName());
		if (compareLastName< 0)
			return false;
		else if (compareLastName == 0 && compareFirstName < 0)
			return false;
		else return true;
	}
	public String toString(){
		if (middleName != null)
			return (lastName + ", " + firstName +" " + middleName.substring(0,1) + ".");
		else
			return (lastName + ", " + firstName);
	}
}
