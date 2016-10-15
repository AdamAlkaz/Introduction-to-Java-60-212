public class Coordinate {
	private int xValue;
	private int yValue;

	public Coordinate(int xValue, int yValue){
		this.xValue = xValue;
		this.yValue = yValue;
	}

	public int getX(){
		return xValue;
	}

	public int getY(){
		return yValue;
	}

	// Method distance calculates the distance from the current object to point
	public double distance(Coordinate point)
	   {
	     double dist;
	     dist = Math.sqrt((double) ((point.getX() - xValue)*(point.getX() - xValue) +
	                      (point.getY() - yValue)*(point.getY() - yValue)));
	     return dist;
	   }

	public Coordinate add(Coordinate anotherPosition){
		int newXValue, newYValue;
		newXValue = this. xValue + anotherPosition.xValue;
		newYValue = this. yValue + anotherPosition.yValue;
		return new Coordinate(newXValue, newYValue);
	}

	public Coordinate difference(Coordinate anotherPosition){
		int newXValue, newYValue;
		newXValue = this. xValue - anotherPosition.xValue;
		newYValue = this. yValue - anotherPosition.yValue;
		return new Coordinate(newXValue, newYValue);
	}
}
