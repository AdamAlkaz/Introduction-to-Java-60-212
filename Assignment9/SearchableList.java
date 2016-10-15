public class SearchableList<T extends Searchable>{
	private ListGeneric aList;

	public SearchableList (){
		aList = new ListGeneric();
	}

	public class SearchingIterator{
		Object keyToSearchFor;

		public SearchingIterator(Object thing){
			keyToSearchFor = thing;
		}

		public T findFirstMatch(){

			if (aList.endOfList() ){

				aList.restart();
				return null;
			}

			if (keyMatches( aList.currentValue() )){

				return (T)( aList.currentValue() );
			}
			aList.getNextNode();

			return findFirstMatch();
		}

		public T findNextMatch(){
			aList.getNextNode();

			if (aList.endOfList() ){

				aList.restart();
				return null;
			}

			if (keyMatches(aList.currentValue() )){

				return (T)( aList.currentValue() );
			}

			return findNextMatch();
		}

		public boolean keyMatches(Object keyToMatch){

			if ( ((T)keyToMatch).keyMatches(keyToSearchFor) ){
				return true;
			}

			return false;
		}

	}//end of innerClass()

	public void insert(T x){

		if (aList.listIsEmpty() ){
			aList.addBeforeCurrent(x);
			aList.restart();
			return;
		}

		if (aList.endOfList() ){
			aList.addBeforeCurrent(x);
			aList.restart();
			return;
		}

		aList.getNextNode();

		insert(x);
	}

	public T getFirst(){
		aList.restart();

		if (aList.listIsEmpty() ){
			return null;
		}

		return ((T)aList.currentValue() );
	}

	public T getNext(){
		aList.getNextNode();
		if(aList.endOfList()){
			aList.restart();
			return null;
		}

		return ((T)aList.currentValue() );
	}

	public SearchingIterator getIterator(Object key){

		return ( new SearchingIterator(key) );
	}
}
