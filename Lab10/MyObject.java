public class MyObject {
	int avgNumbers[] = {0,0,0,0,0};
	int count = 0;

	public void insert(int a){
		avgNumbers[count] = a;
		count++;
	}

	public double  calcAverage() throws DivideByZeroException {
		if (count == 0){
			throw new DivideByZeroException();
		}
		int sum = 0;
		double result = 0;
		for(int i = 0; i < count ; i++){
			sum += avgNumbers[i];
		}
		result = ((double) sum)/count;
		return result;
	}

}
