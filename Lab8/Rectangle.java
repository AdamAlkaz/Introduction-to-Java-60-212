import java.awt.Color;
import java.awt.Graphics;
public class Rectangle {
	Coordinate topLeftCorner; // A Rectangle is defined by its color, radius and the top left corner of the bounding box for the Rectangle
	Coordinate lastMousePosition;
	int width, height;
	Color RectangleColor;
	int topLeftX, topLeftY;
	boolean RectangleIsSelectedForMoving = false; // true if the user presses mouse button inside the Rectangle
	boolean bottomSelected = false;
	boolean rightSelected = false;// true if the user presses mouse button on the perimeter of the Rectangle

	public Rectangle(){
		topLeftCorner = new Coordinate(100, 100); // initial definition of the Rectangle
		width = 150;
		height = 100;
		RectangleColor = Color.RED;
	}
	public void processMouseMotionEvent(Coordinate currentMousePosition){// called when the user drags the mouse
		if (RectangleIsSelectedForMoving){// If the Rectangle is selected for moving
			updateRectanglePosition(currentMousePosition); // Find new position of Rectangle
		} else if (bottomSelected){// if the perimeter of the Rectangle is selected for modifying the size of Rectangle
			updateRectangleHeight(currentMousePosition); // Find new radius of Rectangle and update the size of Rectangle
		} else if (rightSelected){
			updateRectangleWidth (currentMousePosition);
		}
	}
    public void processMouseReleasedEvent(Coordinate currentMousePosition){// called when the user releases the left mouse button
    	RectangleColor = Color.RED;              // the color becomes red again and all flags
		RectangleIsSelectedForMoving = false;             // are reset.
		bottomSelected = false;
		rightSelected = false;
    }

	public void processMousePressedEvent(Coordinate currentMousePosition){// called when the user presses the left mouse button
		lastMousePosition = currentMousePosition;// save the current position of the button so that subsequent mouse drag event
		                                         // can be handled
		if (RectangleIsSelected(lastMousePosition)){ // If Rectangle is selected
			RectangleIsSelectedForMoving = true;     // the corresponding flag is set to true and
			RectangleColor = Color.GREEN;            //the color of the Rectangle becomes green
		}
		else if (onBottom(lastMousePosition)){ // If the user selects the circumference of the Rectangle
			bottomSelected = true;             // by pressing the mouse within 5 pixels of the perimeter
			                                      // the corresponding flag is set to true and
			RectangleColor = Color.BLUE;             // the color becomes blue
		}
		else if (onRight(lastMousePosition)){
			rightSelected = true;
			RectangleColor = Color.BLUE;
		}
	}

	private void updateRectanglePosition(Coordinate newMousePosition){// This method is called when the user selects the Rectangle
		                                                           // for moving and has then dragged the mouse
		int newXValue, newYValue; // gives the x value and the y value of the new topLeftCorner of the Rectangle
		newXValue = topLeftCorner.getX() + newMousePosition.getX() - lastMousePosition.getX();
		newYValue = topLeftCorner.getY() + newMousePosition.getY() - lastMousePosition.getY();
		topLeftCorner = new Coordinate(newXValue, newYValue); // get the new position of topLeftCorner of Rectangle
		lastMousePosition = newMousePosition; // get the new position of topLeftCorner of Rectangle
	}

	private void updateRectangleHeight(Coordinate newMousePosition){// method is called to modify the size of Rectangle
		int newYValue;
		newYValue = newMousePosition.getY();
		// The new radius is the new distance of the mouse from the topLeftCorner of the Rectangle.
		height = Math.abs ((int) (topLeftCorner.getY() - newYValue));
	}

	private void updateRectangleWidth(Coordinate newMousePosition){// method is called to modify the size of Rectangle
		int newXValue;
		newXValue = newMousePosition.getX();
		// The new radius is the new distance of the mouse from the topLeftCorner of the Rectangle.
		width = Math.abs((int) (topLeftCorner.getX() - newXValue));
	}
	private boolean  RectangleIsSelected(Coordinate point){// method is called to check if the user has pressed mouse button
		double Distance; // within the Rectangle - at least 5 pixels closer to the topLeftCorner
		Distance = Math.sqrt((double) (topLeftCorner.getX() + width/2 - point.getX())*(topLeftCorner.getX() + width / 2 - point.getX())
				+ (topLeftCorner.getY() + height / 2 - point.getY()) * (topLeftCorner.getY() + height / 2 - point.getY()));
	if (Distance < 10.0 && Distance > 0.0) {
			return true;
		}
		else {
			return false;
		}
	}

	private boolean onBottom(Coordinate point){ // method is called to check if the user has pressed mouse button
		if ((point.getY() < (topLeftCorner.getY() + height + 5)) && (point.getY() > (topLeftCorner.getY() + height - 5 ))
			&& (point.getX() <  (topLeftCorner.getX() + width + 5)) && (point.getX() > (topLeftCorner.getX() - width - 5))){
					return true;
		} else{
			return false;
		}
	}

	private boolean onRight (Coordinate point){
		if ((point.getX() > (topLeftCorner.getX() + width - 5)) && (point.getX() < (topLeftCorner.getX() + width + 5))
				&& (point.getY() < (topLeftCorner.getY() + height + 5)) && (point.getY() > (topLeftCorner.getY() - height - 5))){
			return true;
		}
		else return false;
	}

	public void showRectangle(Graphics g){	// display the cirle with the specified color, size and topLeftCorner
		g.setColor(RectangleColor);
		g.drawRect(topLeftCorner.getX() , topLeftCorner.getY() , width, height);
	}

}
