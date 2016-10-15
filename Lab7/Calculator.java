import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame{
	private JLabel prompt;
	private JTextField inputArea;
	private JTextField resultArea;
	private JButton [] operationButtons;
	private int currentResult = 0;
	private int numberEntered = 0;


	private void carryOutOperation(char operation){
		String stringToDisplay;
		switch (operation){
		case '+': currentResult += numberEntered;
		break;
		case '-': currentResult -= numberEntered;
		break;
		case '*': currentResult *= numberEntered;
		break;
		case '/': currentResult /= numberEntered;
		break;
		default:break;
		}
		stringToDisplay = String.valueOf(currentResult);
		resultArea.setText(stringToDisplay);
	}

	public Calculator (){
		super ("Calculator");
		setLayout (new FlowLayout());

		prompt = new JLabel ("Result");
		add (prompt);

		resultArea =new JTextField (13);
		add (resultArea);
		resultArea.setEditable(false);
		resultArea.setText(String.valueOf(currentResult));

		prompt = new JLabel ("Input");
		add (prompt);
		inputArea = new JTextField(13);
		add (inputArea);
		char operatorArray [] = {'+','-','*','/'};
		operationButtons = new JButton [4];
		for (int i = 0 ; i<4 ; i++){
			operationButtons[i] = new JButton();
			operationButtons[i].setPreferredSize(new Dimension (50,25));
			operationButtons[i].setText(String.valueOf(operatorArray[i]));
			operationButtons[i].addActionListener(new ActionListener(){
				public void actionPerformed (ActionEvent e){
					numberEntered = Integer.parseInt(inputArea.getText());
					carryOutOperation (e.getActionCommand().charAt(0));
					inputArea.setText("");
				}
			});
		add (operationButtons[i]);
		}
		setSize(240,180);
		setVisible(true);

	}
	public static void main (String a []){
		Calculator frame = new Calculator();
	}
}
