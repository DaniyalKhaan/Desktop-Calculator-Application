package dMKCalculator;
// textField is displaying recursion remember to fix it

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
	static JLabel label;
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
	boolean operatorCalled;
	Color operatorColor;
	String labelString;
	ImageIcon titleIcon;
	ImageIcon deleteIcon;

	
	GUI() {
		operator ="";
		presentNumber = "";
		pastNumber = "";
		labelnumber1 = "";
		labelnumber2 = "";
		updatedOperator = "";
		calculateCalled = false;
		operatorCalled = false;
		operatorColor = Color.RED;
		labelString = "";
		// Style frame
//		BorderLayout borderLayout = new BorderLayout();
		frame = new JFrame();
		frame.setTitle("DMKgg Calculator");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(316, 530);
	    frame.setLayout(null);;
	    frame.getContentPane().setBackground(new Color(30,30,30));
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
	    frame.requestFocusInWindow();
	    
	    titleIcon = new ImageIcon(getClass().getResource("ICON.png"));
	    deleteIcon = new ImageIcon(getClass().getResource("delete.png"));


	    frame.setIconImage(titleIcon.getImage());
	    
	
	    
	    
	    NumBtnsHandler numBtnsHandler = new NumBtnsHandler();
	    OperationBtnsHandler operationBtnsHandler = new OperationBtnsHandler();
//        functions.presentNum = " Washa kana yar";
        
//	    ImageIcon icon = new ImageIcon(getClass().getResource("res/ICON.png"));
	  
	    
	    // Style textField
	    textField = new JTextField();
	    textField.setBounds(0, 43, 295, 95);
	    textField.setText("0");
	    
	    textField.setFont(new Font("Calibri", Font.BOLD,48));
	    
	    textField.setHorizontalAlignment(SwingConstants.RIGHT);
//	    textField.setColumns(10);
	    textField.setBackground(new Color(25, 25, 25));
//	    textField.setBackground(new Color(36, 40, 44));
	    textField.setForeground(new Color(255,255,255));
	    textField.setEditable(false);
	    textField.requestFocusInWindow();
	    textField.setBorder(BorderFactory.createBevelBorder(3));
	    
	    // Style label
	    label = new JLabel("<html>" + labelString + "</html>");
	    label.setBounds(0,3,300,40);
	    label.setFont(new Font("Calibri",Font.PLAIN,18));
	    label.setHorizontalAlignment(SwingConstants.RIGHT);
	    label.setBackground(new Color(25, 25, 25));
//	    label.setBackground(new Color(32,64, 128));
	    label.setForeground(new Color(255,255,255));
	    label.setBorder(BorderFactory.createBevelBorder(3));
	    label.setOpaque(true);
	    
	    // declaring Buttons
	    addBtn = new JButton("+");
	    subtractBtn = new JButton("–");
	    multiplyBtn = new JButton("×");
	    divideBtn = new JButton("÷");
	    squareBtn = new JButton("<html>X<sup>2</sup></html>");
	    negationBtn = new JButton("±");
	    decimalBtn = new JButton("•");
	    deleteBtn = new JButton("");
	    clearBtn = new JButton();
	    equalBtn = new JButton("=");
	    
	    // declaring and styling number Buttons
	    numberBtns = new JButton[10];
	    for (int i =0; i<10; i++) {
	    	
	    	numberBtns[i] = new JButton(String.valueOf(i));
	    	numberBtns[i].setFont(new Font("Lucida Sans", Font.BOLD, 25));
//	    	numberBtns[i].setFont(new Font("Microsoft Sans Serif", Font.BOLD, 25));
	    	
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
	    deleteBtn.setFont(new Font("Wingdings", Font.BOLD,22));
	    deleteBtn.setForeground(new Color(245,164, 11));
	    decimalBtn.setFont(new Font("Georgia", Font.BOLD,18));
	    clearBtn.setFont(new Font("Arial", Font.PLAIN, 20));
	    squareBtn.setFont(new Font("Arial", Font.BOLD, 17));
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
	    
	    clearBtn.setIcon(deleteIcon);
	    
	    
//	    textField.setText(functions.presentNum);
	    frame.addKeyListener(numBtnsHandler);
	    frame.addKeyListener(operationBtnsHandler);
	    
	    frame.add(textField);
	    frame.add(label);
	    frame.add(panel);
//	    frame.addKeyListener(NumBtnsHandler);
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
		label.setText("");
		labelnumber1="";
		labelnumber2="";
		updatedOperator="";
		Sresult = "";
		calculateCalled = false;
		operatorCalled = false;
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
		label.setText("<html>" + labelString + "</html>");
	}
	
	
	public void textAnimation() {
		if (presentNumber.length()== 11 || presentNumber.length() == 12) {
				textField.setFont(new Font("Calibri", Font.BOLD,44));
	   
		} else if (presentNumber.length()== 13||  presentNumber.length()== 14) {
		      textField.setFont(new Font("Calibri", Font.BOLD,40));
	    
		} else if (presentNumber.length()== 15 ||  presentNumber.length()== 16) {
		      textField.setFont(new Font("Calibri", Font.BOLD,35));
                  }
		else if ( presentNumber.length() >=17) {
			textField.setFont(new Font("Calibri", Font.BOLD,32));
		}
	}
	
	public void handleRecursion() {
		if (presentNumber.length()>16) {
			presentNumber = presentNumber.substring(0, 17);
			textField.setFont(new Font("Calibri", Font.BOLD,32));
		} else {
			textField.setFont(new Font("Calibri", Font.BOLD,48));
		}
	}
	public void updateTextField() {
		handleRecursion();
		textAnimation();
//		textField.setForeground(new Color(47,58,64)); this color is good after changes set it to label
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
//		 calculateCalled=false;
	        // if no number is entered yet
	        if (presentNumber.isEmpty()) {
	            operator = newOperator;
	            updatedOperator = newOperator;
//	            label.setText(labelnumber1 + " "  +  updatedOperator + " ");
	            labelString = labelnumber1 + " "  + " <font size='+2' color='rgb(255, 234, 0)'><b>" + updatedOperator + "</b></font> " + " ";
	            updateLabel();
	            return;
	        }

	        if (!pastNumber.isEmpty()) {
	            calculate();
	            operator = newOperator;
	            
		        pastNumber = presentNumber;
		       
		       
		        presentNumber ="";
//		        updateTextField();
		        textField.setText(Sresult);
		        
//		        label.setText(labelnumber1 + " "+ updatedOperator +" "+ labelnumber2 + " = ");
		        labelString = labelnumber1 + " <font size='+2' color='rgb(255, 234, 0)'<b>" + updatedOperator + "</b></font> " + labelnumber2 + " = ";
		        updatedOperator = newOperator;
		        updateLabel();
		        labelnumber1 = Sresult;
		        operatorCalled = true;
		        return;
	        }
	        operator = newOperator;
	        
	        updatedOperator = newOperator;
	        pastNumber = presentNumber;
	        labelnumber1 = presentNumber;
//	        label.setText( labelnumber1 + " "  +  updatedOperator + " ");
	        labelString =  labelnumber1 + " "  +  " <font size='+2' color='rgb(255, 234, 0)'<b>" + updatedOperator + "</b></font> "+ " ";
	        updateLabel();
	        presentNumber ="";
	        updateTextField();
	        
	        
	    }
	
	public void calculate() {
		 if (pastNumber.length() < 1 || presentNumber.length() < 1) {
			 
	         return;
	        }
		double num1 = Double.parseDouble(pastNumber);
		double num2 = Double.parseDouble(presentNumber);
		labelnumber1 = pastNumber;
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
			if (num2 == 0) {
				
				textField.setText("cannot / by 0");
//				return;
			} else {
				result = num1 / num2;
//				presentNumber = " Cannot divide by zero";
			}
			break;
			

		}
		presentNumber = String.valueOf(result);
		pastNumber = "";
		operator = null;
//		updatedOperator = null;
		processOutputNumber();
		Sresult  = presentNumber;
		updateTextField();
		labelString = labelnumber1 + " <font size='+2' color='rgb(255, 234, 0)'<b>" + updatedOperator + "</b></font> " + labelnumber2 + " = ";
	}
	
	  
	class NumBtnsHandler implements ActionListener, KeyListener{
		
		
		public void actionPerformed(ActionEvent e) {
			char inputChar = e.getActionCommand().charAt(0);
			
			 for( int i=0; i<10; i++) {
		            if (e.getSource() == numberBtns[i]){
		            	if (operatorCalled) {
		            		labelString = Sresult + "dayo"  + " <font size='+2' color='rgb(255, 234, 0)'><b>" + updatedOperator + "</b></font> " + " ";
		            		updateLabel();
		            		presentNumber = String.valueOf(inputChar);
		            		operatorCalled = false;
		            	} else if ( calculateCalled) {
		            		clearOperation();
		            		presentNumber = String.valueOf(inputChar);
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

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if (Character.isDigit(e.getKeyChar()) ) {
				char keypress = e.getKeyChar();
			    
				if (operatorCalled) {
            		labelString = Sresult + " "  + " <font size='+2' color='rgb(255, 234, 0)'><b>" + updatedOperator + "</b></font> " + " ";
            		updateLabel();
            		presentNumber = String.valueOf(keypress);
            		operatorCalled = false;
            	} else if ( calculateCalled) {
            		clearOperation();
            		presentNumber = String.valueOf(keypress);
            		calculateCalled = false;
            	}

            	else if (textField.getText().equals("0")) {
                    presentNumber = String.valueOf(keypress);
                } else {
                	presentNumber = textField.getText() + keypress;
                  }
            	updateTextField();
		    } 		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		}
	
	class OperationBtnsHandler implements ActionListener, KeyListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == addBtn) {
				selectOperator(addBtn.getText());
				
			} else if (e.getSource() == subtractBtn) {
				selectOperator(subtractBtn.getText());
			} else if (e.getSource() == multiplyBtn) {
				selectOperator(multiplyBtn.getText());
			} else if (e.getSource() == divideBtn) {
				selectOperator(divideBtn.getText());
			} else if (e.getSource() == equalBtn) {
				calculate();
				calculateCalled = true;
				updateLabel();
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

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if (e.getKeyChar() == '+') {
				selectOperator(addBtn.getText());
				
			} else if (e.getKeyChar() == '-') {
				selectOperator(subtractBtn.getText());
			} else if (e.getKeyChar() == '*') {
				selectOperator(multiplyBtn.getText());
			} else if (e.getKeyChar() == '/') {
				selectOperator(divideBtn.getText());
			} else if (e.getKeyChar() == '=' || e.getKeyChar() == KeyEvent.VK_ENTER ) {
				calculate();
				calculateCalled = true;
				updateLabel();
			} else if (e.getKeyChar() == KeyEvent.VK_SHIFT) {
				squareOperation();
			} else if (e.getKeyChar() == KeyEvent.VK_DELETE || e.getKeyChar() =='C') {
				clearOperation();
			} else if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
				deleteOperation();
			} else if (e.getKeyChar() == 'n' || e.getKeyChar() == 'N')  {
				negationOperation();
			}
			 else if (e.getKeyChar() == '.') {
				decimalFunction();
			}
		   
//			updateTextField();
//			updateLabel();
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		} 		
	}
	

	

	
}
