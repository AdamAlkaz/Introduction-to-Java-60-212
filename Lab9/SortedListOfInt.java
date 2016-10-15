public class SortedListOfInt {
	/* This is to show how you may approach Lab 9
	 * Without using recursion, I have defined method addInteger(int x) which adds
	 * x into a sorted list.
	 * I have defined a toString method to display all elements in a list.
	 * This uses a recursive method displayList.
	 * Your methods should use an approach like mine.
	 */
	ListGeneral myList = new ListGeneral();
	public void addElement(int newElement){
		boolean positionToInsertNewElementNotFound = true;
		int currentValue;
		/*
		 *  variable positionToInsertNewElementNotFound will be set to false when
		 *  we have
		 *       a) found a node in myList which has variable value  greater than newElement.
		 *       	At this stage we can insert a node containing newElement before this node, or
		 *       b) reached the end of the list. At this stage
		 *       	we can insert a node containing newElement to become the last elements in the linked
		 *          list.
		 */
		myList.restart();
		while (positionToInsertNewElementNotFound){
			if (myList.endOfList()){
				positionToInsertNewElementNotFound = false;
			} else{
				currentValue = (Integer) myList.currentValue(); // currentValue returns an object of type Object
				if (currentValue >= newElement){
					positionToInsertNewElementNotFound = false;
				} else {
					myList.getNextNode(); // Note that since endOfList() is false, getNextNode will not return false;
				}
			}
		}
		myList.addBeforeCurrent(newElement); // I used automatic boxing of int into Innteger
	}

	private String displayList(){
		int valueInCurrentNode;
		if (myList.endOfList()){
			return ""; // If list is empty return an empty string
		} else {
			valueInCurrentNode = (Integer) myList.currentValue();
			/*
			 *  This cast was not really needed since I could have worked directly with the
			 *  the value returned by myList.currentValue()
			 */
			myList.getNextNode();
			return  valueInCurrentNode + "\n" + displayList();
		}
	}

	public String toString(){
		/*
		 * This method returns a string containing all elements in the list - one element in each line.
		 * This
		 */
		myList.restart();
		return displayList();
	}



	public int deleteElement (int x){
		int count = 0;
		myList.restart();
		if (myList.firstNode!=null){
			if ((Integer)myList.currentValue() == x){
				count ++;
				myList.removeCurrent();
			}

			while (myList.getNextNode()){
				if ((Integer)myList.currentValue() == x){
					count ++;
					myList.removeCurrent();
				}
			}
		}
		return count;
	}

	public String retrieve (int lowerLimit, int upperLimit){

		myList.restart();
		SortedListOfInt subList = new SortedListOfInt();
		if (subList.myList.firstNode != null){
			if ((Integer)subList.myList.currentValue() >= lowerLimit && (Integer)subList.myList.currentValue() <= upperLimit){
				subList.addElement((Integer)subList.myList.currentValue());
			}
		}
		while (subList.myList.getNextNode()){
			if ((Integer)subList.myList.currentValue() >= lowerLimit && (Integer)subList.myList.currentValue() <= upperLimit){
				subList.addElement((Integer)subList.myList.currentValue());
			}
		}
		return subList.toString();
	}
}
