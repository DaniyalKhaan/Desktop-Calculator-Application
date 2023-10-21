package dmkcapp;
// textField is displaying recursion remember to fix it

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


//import java.awt.GridLayout;i;
//import javax.swing.border.Border;
















class GUI {
	JFrame frame;
	JTextField textField;
	JLabel label;
	JButton addBtn, subtractBtn, multiplyBtn, divideBtn, squareBtn ;
	JButton decimalBtn, negationBtn, deleteBtn, clearBtn, equalBtn ;
	// see if I can add decimal number into numberBtns array;
	JButton numberBtns[];
	JButton operationBtns[];
	JPanel panel;
	String pastNumber, presentNumber;
	String operator;
	String updatedOperator;
	String labelnumber1, labelnumber2;
	String Sresult;
	boolean calculateCalled;

	
	GUI() {
		operator ="";
		presentNumber = "";
		pastNumber = "";
		labelnumber1 = "";
		labelnumber2 = "";
		updatedOperator = "";
		calculateCalled = false;
		// Style frame
//		BorderLayout borderLayout = new BorderLayout();
		frame = new JFrame();
		frame.setTitle("DMK Calculator");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(316, 530);
	    frame.setLayout(null);;
	    frame.getContentPane().setBackground(new Color(30,30,30));
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
	    frame.requestFocusInWindow();
	    
	    NumBtnsHandler numBtnsHandler = new NumBtnsHandler();
	    OperationBtnsHandler operationBtnsHandler = new OperationBtnsHandler();
//        functions.presentNum = " Washa kana yar";
        
//	    ImageIcon icon = new ImageIcon(getClass().getResource("res/ICON.png"));
	  
	    
	    // Style textField
	    textField = new JTextField();
	    textField.setBounds(0, 43, 298, 95);
	    textField.setText("0");
	    textField.setFont(new Font("Calibri", Font.BOLD,40));
	    textField.setHorizontalAlignment(SwingConstants.RIGHT);
	    textField.setBackground(new Color(25, 25, 25));
	    textField.setForeground(new Color(255,255,255));
	    textField.setEditable(false);
	    textField.setBorder(BorderFactory.createBevelBorder(3));
	    
	    // Style label
	    label = new JLabel();
	    label.setBounds(0,5,300,40);
	    label.setHorizontalAlignment(SwingConstants.RIGHT);
	    label.setBackground(new Color(25, 25, 25));
	    label.setForeground(new Color(255,255,255));
	    label.setBorder(BorderFactory.createBevelBorder(3));
	    label.setOpaque(true);
	    
	    // declaring Buttons
	    addBtn = new JButton("+");
	    subtractBtn = new JButton("–");
	    multiplyBtn = new JButton("×");
	    divideBtn = new JButton("÷");
	    squareBtn = new JButton("<html>x<sup>2</sup></html>");
	    negationBtn = new JButton("±");
	    decimalBtn = new JButton("•");
	    deleteBtn = new JButton("");
	    clearBtn = new JButton("C");
	    equalBtn = new JButton("=");
	    
	    // declaring and styling number Buttons
	    numberBtns = new JButton[10];
	    for (int i =0; i<10; i++) {
	    	
	    	numberBtns[i] = new JButton(String.valueOf(i));
	    	numberBtns[i].setFont(new Font("Harlow Solid Italic", Font.ITALIC, 25));
	    	numberBtns[i].setFocusable(false);
	    	numberBtns[i].setBackground(new Color(60,60, 60));
	    	numberBtns[i].setForeground(new Color(255,255,255));
	    	numberBtns[i].setBorder(BorderFactory.createBevelBorder(3));   
	    	numberBtns[i].addActionListener(numBtnsHandler);
	    }
	    
	    // declaring and styling function Buttons
	    operationBtns = new JButton[10];
	    operationBtns[0] = addBtn;
	    operationBtns[1] = subtractBtn;
	    operationBtns[2] = multiplyBtn;
	    operationBtns[3] = divideBtn;
	    operationBtns[4] = squareBtn;
	    operationBtns[5] = negationBtn;
	    operationBtns[6] = decimalBtn;
	    operationBtns[7] = deleteBtn;
	    operationBtns[8] = clearBtn;
	    operationBtns[9] = equalBtn;
	    
	    for (int i=0; i<10; i++) {

	    	operationBtns[i].setFont(new Font("Cooper Black", Font.BOLD,25));
	    	operationBtns[i].setFocusable(false);
	    	operationBtns[i].setBackground(new Color(60,60, 60));
	    	operationBtns[i].setForeground(new Color(255,255,255));
	    	operationBtns[i].setBorder(BorderFactory.createBevelBorder(3));
	    	operationBtns[i].addActionListener(operationBtnsHandler);
	    }
	    // function Buttons Done!
	    
	    // changing Color of the last column Buttons to yellow
	    divideBtn.setBackground(new Color(245,164, 11));
	    multiplyBtn.setBackground(new Color(245,164, 11));
	    subtractBtn.setBackground(new Color(245,164, 11));
	    addBtn.setBackground(new Color(245,164, 11));
	    equalBtn.setBackground(new Color(245,164, 11));
	    
	    // made changes to some buttons for icon look 
	    deleteBtn.setFont(new Font("Wingdings", Font.BOLD,20));
	    deleteBtn.setForeground(new Color(245,164, 11));
	    decimalBtn.setFont(new Font("Georgia", Font.BOLD,18));
	    clearBtn.setFont(new Font("Arial", Font.PLAIN, 20));
	    squareBtn.setFont(new Font("Forte", Font.PLAIN, 19));
//	    addBtn.setIcon(icon);
	    
//	    addBtn.addActionListener(operationBtnsHandler);)
	    
	    // Style Panel
	    panel = new JPanel();
	    panel.setBounds(3, 140, 295, 349);
	    // setting no of rows and column of the panel
	    panel.setLayout(new GridLayout(5, 4, 2, 2));
	    panel.setBackground(new Color(25, 25, 25));
	    panel.setForeground(new Color(255, 255, 255));
	    
	    // adding Buttons to panel
	    // First Row
	    panel.add(operationBtns[4]);
	    panel.add(operationBtns[8]);
	    panel.add(operationBtns[7]);
	    panel.add(operationBtns[3]);
	    // Second Row
	    panel.add(numberBtns[7]);
	    panel.add(numberBtns[8]);
	    panel.add(numberBtns[9]);
	    panel.add(operationBtns[2]);
	    // Third Row
	    panel.add(numberBtns[4]);
	    panel.add(numberBtns[5]);
	    panel.add(numberBtns[6]);
	    panel.add(operationBtns[1]);
	    // Fourth Row
	    panel.add(numberBtns[1]);
	    panel.add(numberBtns[2]);
	    panel.add(numberBtns[3]);
	    panel.add(operationBtns[0]);
	    // Fifth Row
	    panel.add(operationBtns[5]);
	    panel.add(numberBtns[0]);
	    panel.add(operationBtns[6]);
	    panel.add(operationBtns[9]);
	    
	    
//	    textField.setText(functions.presentNum);
	    frame.add(textField);
	    frame.add(label);
	    frame.add(panel);
	    frame.setVisible(true);

	   }
	public void decimalFunction() {
		if (!presentNumber.contains(".")) {
			presentNumber = presentNumber + ".";
		}
		updateTextField();
	}
	public void negationOperation() {
		double negation = Double.parseDouble(presentNumber);
		negation = negation * (-1);
		presentNumber = String.valueOf(negation);
		processOutputNumber();
		updateTextField();
	}
	
	public void deleteOperation() {
		String delete = presentNumber;
		presentNumber = "";
		if (!delete.equals("cd0")) {
			if (delete.length() > 1) {
				for (int i =0; i<delete.length()-1;i++) {
					presentNumber = presentNumber + delete.charAt(i);
          		}
			} else {
				presentNumber = "0";
			}
			
		}
		updateTextField();
	}
	public void clearOperation() {
		presentNumber = "0";
		pastNumber = "";
		operator = null;
		updateTextField();
		}
	public void squareOperation() {
		double typedNumber = Double.parseDouble(presentNumber);
		double square = typedNumber * typedNumber;
		label.setText("sqr( " + presentNumber +" )");
		presentNumber = String.valueOf(square);
		processOutputNumber();
		updateTextField();
		
	}
	public void updateLabel() {
	}
	
	public void updateTextField() {
		textField.setText(presentNumber);
	}
	 
	public void processOutputNumber() {
		
	        if (presentNumber.length() > 0) {
	            String integerPart = presentNumber.split("\\.")[0];
	            String decimalPart = presentNumber.split("\\.")[1];
	            if (decimalPart.equals("0")) {
	            	presentNumber = integerPart;
	            }
	        }
	    }
	
	 public void selectOperator(String newOperator) {
	        // if no number is entered yet
	        if (presentNumber.isEmpty()) {
	            operator = newOperator;
	            updatedOperator = newOperator;
	            label.setText("Ist"+ labelnumber1 + " "  +  updatedOperator + " ");
	            return;
	        }

	        if (!pastNumber.isEmpty()) {
	            calculate();
	            operator = newOperator;
	            updatedOperator = newOperator;
		        pastNumber = presentNumber;
		        labelnumber1 = presentNumber;
		        label.setText("2nd " + labelnumber1  + updatedOperator);
		        presentNumber ="";
//		        updateTextField();
		        textField.setText(Sresult);
		        calculateCalled = true;
		        return;
	        }
	        operator = newOperator;
	        
	        updatedOperator = newOperator;
	        pastNumber = presentNumber;
	        labelnumber1 = presentNumber;
	        label.setText("3rd "+ labelnumber1 + " "  +  updatedOperator + " ");
	        presentNumber ="";
	        updateTextField();
	        
	        
	    }
	
	public void calculate() {
		 if (pastNumber.length() < 1 || presentNumber.length() < 1) {
			 
	         return;
	        }
		double num1 = Double.parseDouble(pastNumber);
		double num2 = Double.parseDouble(presentNumber);
		labelnumber2 = presentNumber;
		double result = 0.0;
		
		switch(operator) {
		case "+":
			result = num1 + num2;
			break;
		case "–":
			result = num1 - num2;
			break;
		case "×":
			result = num1 * num2;
			break;
		case "÷":
			if (num2 != 0) {
				result = num1 / num2;
			} else if (num2 ==20){
//				presentNumber = " Cannot divide by zero";
			}
			break;
			

		}
		presentNumber = String.valueOf(result);
//		pastNumber = ""; I am right about this line but finding the solution
		
		pastNumber = "";
		operator = null;
		processOutputNumber();
		Sresult  = presentNumber;
		updateTextField();
		label.setText(labelnumber1 + " "+ updatedOperator +" "+ labelnumber2 + " = ");
		
	}
	
	  
	class NumBtnsHandler implements ActionListener{
		
		
		public void actionPerformed(ActionEvent e) {
			char inputChar = e.getActionCommand().charAt(0);
			
			 for( int i=0; i<10; i++) {
		            if (e.getSource() == numberBtns[i]){
		            	if (calculateCalled) {
		            		presentNumber = String.valueOf(inputChar);
//		            		textField.setText(String.valueOf(inputChar));
		            		calculateCalled = false;
		            	}

		            	else if (textField.getText().equals("0")) {
		                    presentNumber = String.valueOf(inputChar);
		                } else {
		                	presentNumber = textField.getText() + inputChar;
		                  }
		            	updateTextField();
		            	}
		            
		            }
			 }
		}
	
	class OperationBtnsHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == addBtn) {
				selectOperator(addBtn.getText());
				
			} else if (e.getSource() == subtractBtn) {
				selectOperator(subtractBtn.getText());
//				label.setText(temp + operator);
			} else if (e.getSource() == multiplyBtn) {
				selectOperator(multiplyBtn.getText());
//				label.setText(temp + operator);
			} else if (e.getSource() == divideBtn) {
				selectOperator(divideBtn.getText());
//				label.setText(temp + operator);
			} else if (e.getSource() == equalBtn) {
				calculate();
				calculateCalled = true;
			} else if (e.getSource() == squareBtn) {
				squareOperation();
			} else if (e.getSource() == clearBtn) {
				clearOperation();
			} else if (e.getSource() == deleteBtn) {
				deleteOperation();
			} else if (e.getSource() == negationBtn) {
				negationOperation();
			}
			 else if (e.getSource() == decimalBtn) {
				decimalFunction();
			}
//			updateTextField();
//			updateLabel();
			
			
		} 		
	}
	

	
}
