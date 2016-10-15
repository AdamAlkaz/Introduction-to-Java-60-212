import java.util.*;
public class MyInformationSystem <T> {
	private class Pair <T>{
		private T value;
		private String key;
		boolean keyMatches (String keyValue){
			if (key.equals(keyValue)) return true;
			else return false;
		}
		private Pair (T value, String key){
			this.value = value;
			this.key = key;
		}
		Object getT(){
			return value;
		}
	}

	private ArrayList <Pair> myList = new ArrayList <Pair> ();

	public void insert (T value, String key){
		Pair thisPair = new Pair (value,key);
		myList.add(thisPair);
	}

	public T retrieve (String keyValue) throws Exception{
		for (Pair x:myList){
			if (x.keyMatches(keyValue))
				return (T)x.getT();
		}
		throw new Exception ();
	}
	public static void main(String a[]){
		String result;
		String keyList[] = {"126", "536", "428", "245"};
		MyInformationSystem<String> nameStudentNumberList;
		nameStudentNumberList = new MyInformationSystem<String>();
		nameStudentNumberList.insert("John", "245");// John has
		  // student number 245
		nameStudentNumberList.insert("Tom", "126");
		nameStudentNumberList.insert("Mary", "536");
		nameStudentNumberList.insert("Mark", "821");
		for (int i = 0; i < keyList.length; i++){
			try{
				result = nameStudentNumberList.retrieve(keyList[i]);
				System.out.println("For key " + keyList[i] + " the matching value is " + result);
			}
			catch(Exception e){
				 System.out.println("No Match with " + keyList[i]);
			}
		}
	}
}
