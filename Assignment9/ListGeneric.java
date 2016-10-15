public class ListGeneric <T>{

	private class InnerNode       // This class contains one Object and one
	{                        // self-referential link.
	    private T value;
	    private InnerNode next;

	    public InnerNode(T value, InnerNode nextNode)    //The constructor inserts the
	    {                                            // arguments in the new object.
	         this.value = value;
	         this.next = nextNode;
	    }
	}

		protected InnerNode firstNode; // firstNode can be used by this
		                          // class and any of its subclass.
		private InnerNode currentNode, previousNode; // These are usable only
		                                        // within this class.
		public ListGeneric(){ // Constructor creates an
			                  // empty list.
			currentNode = null;
			firstNode = null;
			previousNode = null;
		}

		/*
		 * The method addAfterCurrent adds a new node with value x
		 * after the current node.
		 */
		public void addAfterCurrent(T x){
			if (firstNode == null){
				firstNode = new InnerNode(x, null);
				currentNode = firstNode;
			}
			else{
				InnerNode newNode = new InnerNode(x, currentNode.next);
				currentNode.next = newNode;
				previousNode = currentNode;
				currentNode = newNode;
			}
		}

		/*
		 * The  method addBeforeCurrent adds a new node with value x
		 * before the current node.
		 */
		public void addBeforeCurrent(T x){
			if (firstNode == null){
				firstNode = new InnerNode(x, null);
				currentNode = firstNode;
			}
			else {
				InnerNode newNode = new InnerNode(x, currentNode);
				if (previousNode != null) {
					previousNode.next = newNode;
				}
				else{
					firstNode = newNode;
				}
				currentNode = newNode;
			}
		}

		/*
		 * removeCurrent() deletes the current node. This is defined
		 * only if the list is not empty.
		 */
		public void removeCurrent(){
			InnerNode temp;
			if (listIsEmpty() || endOfList()) return;
			temp = currentNode.next;
			/*
			 * if previousNode is null, firstNode is currentNode.
			 */

			if (previousNode == null) {
				firstNode = temp;
			}
			else {
				previousNode. next = temp;
			}
			currentNode = currentNode.next;
		}

		/*
		 * listIsEmpty() is true if list is empty.
		 * current() returns the current node.
		 * restart() makes the the first node the current node.
		 */


		public boolean listIsEmpty(){
			return firstNode == null;
		}

		public T currentValue(){
			return  currentNode.value;
		}

		public void restart(){
			currentNode = firstNode;
			previousNode = null;
		}

		/*   endOfList() is true if current is not pointing to
		 * any node.
		 */

		public boolean endOfList(){
			return currentNode == null;
		}

		/* getNextNode makes the next node the current node.
		 * The method returns true if the operation was successful
		 * otherwise it returns false.
		 */
		public boolean getNextNode(){
			if (currentNode == null) {
				return false;
			}
			else {
				previousNode = currentNode;
				currentNode = currentNode.next;
				return true;
			}
		}
		/*
		 * method toString() returns the result of invoking toString()
		 * on all successive elements of the list.
		 */
		public String toString(){
			String s = "";
			InnerNode listPtr;
			listPtr = firstNode;

			while (listPtr != null){
				s += listPtr.value + "\n";
				listPtr = listPtr. next;
			}
			return s;
		}
}
