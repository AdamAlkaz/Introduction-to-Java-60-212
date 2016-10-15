public class Lab9Tester {
	public static void main(String args[]){
		int testData[] = {5, 2, 7, 8, 3, 6,  10, 2, 6};
		int numberOfElementsDeleted = 0;
		SortedListOfInt myList = new SortedListOfInt();
		for (int i = 0; i < testData.length; i++){
			myList.addElement(testData[i]);
		}
		System.out.println("The values in the sorted list are given below");
		System.out.println(myList.retrieve(0, 20));
		System.out.println("The values in the sorted list between 4 and 7 are given below");
		System.out.println(myList.retrieve(4, 7));
		numberOfElementsDeleted = myList.deleteElement(6);
		System.out.println("Number of deleted elements  is " + numberOfElementsDeleted);
		System.out.println("The values in the sorted list after deleting all elements with value 6 are given below");
		System.out.println(myList.retrieve(0, 20));

	}
}
