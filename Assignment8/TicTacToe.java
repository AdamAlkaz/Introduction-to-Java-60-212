import java.awt.*;    // import the java.awt package
import java.awt.event.*;

import javax.swing.*;
public class TicTacToe  extends JFrame {
		private int turn; // turn is 1 if it is the turn to display a X, 2  if it is the turn to display O
     	private int rowNumber, columnNumber;// gives the row and column where the new move is to be displayed
     	int xTable[] = {46, 79, 113};   // xTable[i] gives the displacement for rowNumber i
		int yTable[] = {113, 146, 180};
		private int exists [][] = {{-1,-1,-1},{-1,-1,-1},{-1,-1,-1}};
		private boolean onBoard = false;
		Coordinate lastMousePosition;

		public TicTacToe(){// I put in these three parameters to
			// the constructor so that you can specify the needed information to display a move.
			// You will remove these in your assignment.
			super("Tictactoe Board");
			setSize(300, 300);
			setVisible(true);
			addMouseListener ( new MouseAdapter(){
				public void mousePressed (MouseEvent e){
					Coordinate currentMousePosition;
					int xValue, yValue;
					xValue = e.getX();
					yValue = e.getY();
					currentMousePosition = new Coordinate (xValue, yValue);
					mousePositionOnBoard (currentMousePosition);
					repaint();
				}
				public void mouseReleased (MouseEvent e){
					if (exists[rowNumber][columnNumber] == -1){
						exists[rowNumber][columnNumber] = turn;
						turn = (turn + 1) % 2;
					}

				}
			});
			addMouseMotionListener( new MouseMotionAdapter(){
				public void mouseDragged( MouseEvent e ){ // when the mouse is dragged
					int xValue, yValue;// comments similar to mousePressed method
					Coordinate currentMousePosition;
					xValue = e.getX();
					yValue = e.getY();
					currentMousePosition = new Coordinate(xValue, yValue);
					mousePositionOnBoard(currentMousePosition);
					repaint();
				}
			});
		}

		public void paint(Graphics g){
			int red = 255, green = 0, blue = 0;
			Font my_font;
			my_font = new Font( "Serif", Font.BOLD, 18 );
			super.paint(g); // Note use of super!!
			g.setColor(new Color(red, green, blue)); // One way to set color
			g.drawLine(40, 140, 140, 140);
			g.drawLine(40, 173, 140, 173);
			g.drawLine(73, 107, 73, 207);
			g.drawLine(107, 107, 107, 207);
			g.setColor(new Color(0, 0, 0));
			g.fillRect(20, 87, 140, 5);
			g.fillRect(20, 87, 5, 140);
			g.fillRect(20, 222, 140, 5);
			g.fillRect(155, 87, 5, 140);
			g.setColor(Color.blue);       // Another way to set color
			g.setFont(my_font);
			g.drawString("My Tic Tac Toe Board", 20, 280);
			for (int i = 0 ; i < 3 ; i++){
				for (int j = 0 ; j < 3; j++){
					if (exists[i][j] == 1)
						drawX(g,i,j);
					else if (exists [i][j] == 0)
						drawCircle(g, i,j);

				}
			}
			if (onBoard)
				displayMoves(g);
			/*
			 * Method displayMoves(g)will display all the moves including the current
			 * move, if the current move is valid,.
			 */
		}


		private void displayMoves(Graphics g){

				if (turn == 1){
					drawX(g, rowNumber, columnNumber);
				}
				else{
					drawCircle(g, rowNumber, columnNumber);
				}

		}

		public void drawX(Graphics g, int rowNo, int columnNo){

			g.drawLine(xTable[columnNo], yTable[rowNo],
					      xTable[columnNo] + 10, yTable[rowNo] + 20);
			g.drawLine(xTable[columnNo], yTable[rowNo] + 20,
					   xTable[columnNo] + 10, yTable[rowNo]);
		}

		private void drawCircle(Graphics g, int rowNo, int columnNo){
			g.drawOval(xTable[columnNo], yTable[rowNo], 20, 20);
		}

		private void mousePositionOnBoard (Coordinate point){
			lastMousePosition = point;

			if (point.getX() > 40){
				if (point.getX() < 73)
					columnNumber = 0;
				else if (point.getX() < 107)
					columnNumber = 1;
				else if (point.getX() < 140)
					columnNumber = 2;
			}

			if (point.getY() > 107){
				if (point.getY() < 140)
					rowNumber = 0;
				else if (point.getY() < 173)
					rowNumber = 1;
				else if (point.getY() < 207)
					rowNumber = 2;
			}
			onBoard = false;
			if (columnNumber >=0 && rowNumber >= 0){
				if (exists[rowNumber][columnNumber] == -1)
					onBoard = true;
			}
		}


		public static void main(String args[]){
			TicTacToe newBoard;
			newBoard = new TicTacToe(); // row #, col #, 1 for x and 0 for O
		}
}
