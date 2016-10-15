import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class MoveRectangle  extends JFrame{
	Rectangle myRectangle; // This is the object tat will keep information about a Rectangle and support all services needed
	public MoveRectangle(){
		super("showing Rectangle");
		addMouseListener( new MouseAdapter(){
			public void mousePressed(MouseEvent e ){// when the mouse is pressed
				Coordinate currentMousePosition;
				int xValue, yValue;// extract the coordinates of the position where the event occurred
				xValue = e.getX();
				yValue = e.getY();
				currentMousePosition = new Coordinate(xValue, yValue);
				myRectangle. processMousePressedEvent(currentMousePosition);// send a message to myRectangle to handle the event
				repaint();
			}
			public void mouseReleased(MouseEvent e ){ // when the left mouse button is released
				Coordinate currentMousePosition;
				int xValue, yValue;// comments similar to mousePressed method
				xValue = e.getX();
				yValue = e.getY();
				currentMousePosition = new Coordinate(xValue, yValue);
				myRectangle. processMouseReleasedEvent(currentMousePosition);
				repaint();
			}
		}
		);

		addMouseMotionListener( new MouseMotionAdapter(){
			public void mouseDragged( MouseEvent e ){ // when the mouse is dragged
				int xValue, yValue;// comments similar to mousePressed method
				Coordinate currentMousePosition;
				xValue = e.getX();
				yValue = e.getY();
				currentMousePosition = new Coordinate(xValue, yValue);
				myRectangle. processMouseMotionEvent(currentMousePosition);
				repaint();
			}
		}
		);
		myRectangle = new Rectangle();  // create the cirle
		setSize(500,500); // define the size of the window
		setVisible(true); // make the window visible
	}

	public void paint(Graphics g){ // called to display the Rectangle
		super.paint(g);
		myRectangle. showRectangle(g); // invoke message on myRectangle to display itself
	}
} 
