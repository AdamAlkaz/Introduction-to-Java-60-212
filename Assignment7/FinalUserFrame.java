import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FinalUserFrame extends JFrame {
	private JLabel prompt;
	private JTextField inputArea;
	private JTextArea displayArea;
	private JButton showStudents, showStudentsAscending, showStudentsDescending;
	private OutputFrame OutFrame;


	public FinalUserFrame (University aUniversity){
		super("Input Frame");
		setLayout ( new FlowLayout());

		prompt = new JLabel ("Enter Name Of Country");
		add (prompt);

		inputArea = new JTextField (15);
		add (inputArea);

		displayArea = new JTextArea (20,50);
		add (displayArea);
		displayArea.setEditable(false);

		inputArea.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e){
				displayArea.setText("Number of Students from " + inputArea.getText() +" is: " + aUniversity.numberOfStudents(inputArea.getText()));
				inputArea.setText("");
			}
		});

		showStudents = new JButton();
		showStudents.setPreferredSize(new Dimension(150,30));
		showStudents.setText("Show Students");
		showStudents.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e){
				displayArea.setText(aUniversity.toStringUnsorted());
			}
		});
		add (showStudents);

		showStudentsAscending = new JButton();
		showStudentsAscending.setPreferredSize(new Dimension (250,30));
		showStudentsAscending.setText("Show Students sorted (Ascending)");
		showStudentsAscending.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e){
				OutFrame = null;
				OutFrame = new OutputFrame ("Show Students sorted (Ascending)");
				aUniversity.sortStudents();
				OutFrame.displayMessage(aUniversity.toString());
			}
		});
		add (showStudentsAscending);

		showStudentsDescending = new JButton();
		showStudentsDescending.setPreferredSize(new Dimension (250,30));
		showStudentsDescending.setText("Show Students sorted (Descending)");
		showStudentsDescending.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e){
				OutFrame = new OutputFrame ("Show Students sorted (Descending)");
				aUniversity.sortStudents();
				aUniversity.reverse();
				OutFrame.displayMessage(aUniversity.toString());
			}
		});
		add (showStudentsDescending);



		setSize (600,500);
		setVisible (true);

	}
}
