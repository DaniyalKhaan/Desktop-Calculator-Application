package dMKCalculator;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.plaf.ButtonUI;
import javax.swing.plaf.basic.BasicButtonUI;

class GUI {
	
	private JFrame frame;
	private JTextField textField;
	private JLabel label;
	private JButton addBtn, subtractBtn, multiplyBtn, divideBtn, squareBtn ;
	private JButton decimalBtn, negationBtn, deleteBtn, clearBtn, equalBtn ;
	private JButton numberBtns[];
	private JButton operationBtns[];
	private JPanel panel;
	private JMenuBar menuBar;
	private JMenu colors;
	private JRadioButtonMenuItem dark;
	private JRadioButtonMenuItem light;
	private JMenuItem color1;
	private JMenuItem color2;
	private JMenuItem color3;
	private JMenuItem color4;
	private JMenuItem color5;
	private JMenuItem color6;
	private ButtonGroup buttonGroup;
	private String pastNumber, presentNumber;
	private String operator;
	private String updatedOperator;
	private String labelnumber1, labelnumber2;
	private String Sresult;
	private String labelString;
	private boolean calculateCalled;
	private boolean operatorCalled;
	private boolean darkMode;
	private boolean lightMode;
	private boolean fullBlack;
	private boolean fullLight;
	private boolean divideByZero;
	private ImageIcon titleIcon;
	private ImageIcon deleteIcon;
	private ImageIcon deleteWhiteIcon;
	private ButtonUI customUI;
	
	
	
	private static Color btnUIClr;
	private String labelClr;
	private Color backgroundClr;
	private Color foregroundClr;
	private Color btnBackClr;
	private Color btnFrontClr;
	private Color lastColoumClr;
	private Color panelBackClr;


	
	GUI() {
		
		lastColoumClr = new Color(245,164, 11); // yellow
		
		labelClr = "#E49B0F"; //yellow4white
		
		darkMode = true;
		lightMode = false;
		fullBlack = false;
		fullLight = false;
		calculateCalled = false;
		operatorCalled = false;
		divideByZero = false;
		
		operator ="";
		presentNumber = "0";
		pastNumber = "";
		labelnumber1 = "";
		labelnumber2 = "";
		updatedOperator = "";
		labelString = "";
		// Style frame
		frame = new JFrame();
		frame.setTitle("DMK Calculator");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(316, 530);
	    frame.setLayout(null);;
	    frame.setLocationRelativeTo(null);
	    frame.requestFocusInWindow();
	    
	    menuBar = new JMenuBar();
	    menuBar.setBorder(BorderFactory.createBevelBorder(3));
	    
	    colors = new JMenu(" Colors      ");
	    dark = new JRadioButtonMenuItem("Dark Mode");
	    dark.setSelected(true);
        light = new JRadioButtonMenuItem("Light Mode");
        
        buttonGroup = new ButtonGroup();
        buttonGroup.add(dark);
        buttonGroup.add(light);
        
	    color1 = new JMenuItem("Yellow");
	    color2 = new JMenuItem("Red");
	    color3 = new JMenuItem("Blue");
	    color4 = new JMenuItem("Green");
	    color5 = new JMenuItem("Black (Simple)");
	    color6 = new JMenuItem("Cyan");
	    
	    colors.add(dark);
        colors.add(light);
	    colors.add(color1);
	    colors.add(color2);
	    colors.add(color3);
	    colors.add(color4);
	    colors.add(color5);
	    colors.add(color6);
	    
	    menuBar.add(colors);
	    
	    titleIcon = new ImageIcon(getClass().getResource("ICON.png"));
	    deleteIcon = new ImageIcon(getClass().getResource("delete.png"));
	    deleteWhiteIcon = new ImageIcon(getClass().getResource("whitedelete.png"));

	    NumBtnsHandler numBtnsHandler = new NumBtnsHandler();
	    OperationBtnsHandler operationBtnsHandler = new OperationBtnsHandler();
	    customUI = new btnPressedUI();
	    
	    dark.addActionListener(operationBtnsHandler);
	    light.addActionListener(operationBtnsHandler);
	    color1.addActionListener(operationBtnsHandler);
	    color2.addActionListener(operationBtnsHandler);
	    color3.addActionListener(operationBtnsHandler);
	    color4.addActionListener(operationBtnsHandler);
	    color5.addActionListener(operationBtnsHandler);
	    color6.addActionListener(operationBtnsHandler);
	    // Style textField
	    textField = new JTextField();
	    textField.setBounds(0, 31, 295, 78);
	    textField.setText("0");
	    textField.setFont(new Font("Calibri", Font.BOLD,48));
	    textField.setHorizontalAlignment(SwingConstants.RIGHT);
	    textField.setEditable(false);
	    textField.requestFocusInWindow();
	    textField.setBorder(BorderFactory.createBevelBorder(3));
	    // Style label
	    label = new JLabel("<html>" + labelString + "</html>");
	    label.setBounds(0,1,295,29);
	    label.setFont(new Font("Calibri",Font.PLAIN,18));
	    label.setHorizontalAlignment(SwingConstants.RIGHT);
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
	    	numberBtns[i].setFont(new Font("Calibri", Font.BOLD, 25));
	    	numberBtns[i].setUI(customUI);
	    	numberBtns[i].setFocusable(false);
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
	    	operationBtns[i].setUI(customUI);
	    	operationBtns[i].setFocusable(false);
	    	operationBtns[i].setBorder(BorderFactory.createBevelBorder(3));
	    	operationBtns[i].addActionListener(operationBtnsHandler);
	    }
	    // changing Color of the last column Buttons to yellow
	    divideBtn.setBackground(lastColoumClr);
	    multiplyBtn.setBackground(lastColoumClr);
	    subtractBtn.setBackground(lastColoumClr);
	    addBtn.setBackground(lastColoumClr);
	    equalBtn.setBackground(lastColoumClr);
	    deleteBtn.setForeground(lastColoumClr);
	    // made changes to some buttons for icon look 
	    deleteBtn.setFont(new Font("Wingdings", Font.BOLD,22));
	    decimalBtn.setFont(new Font("Georgia", Font.BOLD,18));
	    squareBtn.setFont(new Font("Arial", Font.BOLD, 17));
	    // Style Panel
	    panel = new JPanel();
	    panel.setBounds(3, 119, 295, 349);
	    panel.setLayout(new GridLayout(5, 4, 2, 2));
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
	    

	    frame.add(textField);
	    frame.add(label);
	    frame.add(panel);
	    frame.setJMenuBar(menuBar);
	    selectTheme();
	    frame.setIconImage(titleIcon.getImage());
	    
	    frame.addKeyListener(numBtnsHandler);
	    frame.addKeyListener(operationBtnsHandler);
	    frame.setVisible(true);
	    frame.requestFocusInWindow();

	   }
	
	public void decimalFunction() {
		if (calculateCalled){
			clearOperation();
			presentNumber = presentNumber + ".";
    		calculateCalled = false;
		}
		else if (!presentNumber.contains(".")) {
			presentNumber = presentNumber + ".";
		}
		updateTextField();
	}
	public void negationOperation() {
		if (!presentNumber.isEmpty()) {
			double negation = Double.parseDouble(presentNumber);
			negation = negation * (-1);
			presentNumber = String.valueOf(negation);
			processOutputNumber();
			updateTextField();
		} 

	}
	public void deleteOperation() {
		String delete = presentNumber;
		presentNumber = "";
		if (!delete.equals("")) {
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
		labelnumber1="";
		labelnumber2="";
		labelString = "";
		updatedOperator="";
		Sresult = "";
		updateLabel();
		calculateCalled = false;
		operatorCalled = false;
	}
	public void squareOperation() {
		if (!presentNumber.isEmpty()) { 
			double typedNumber = Double.parseDouble(presentNumber);
			double square = typedNumber * typedNumber;
			label.setText("sqr( " + presentNumber +" ) ");
			presentNumber = String.valueOf(square);
			processOutputNumber();
			updateTextField();
		} else {
			double typedNumber = Double.parseDouble(textField.getText());
			double square = typedNumber * typedNumber;
			label.setText("sqr( " + typedNumber +" ) ");
			presentNumber = String.valueOf(square);
			processOutputNumber();
			updateTextField();
		}
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
		} else if ( presentNumber.length() >=17) {
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
		 calculateCalled=false;
	        if (presentNumber.isEmpty()) {
		        // if no number is entered yet
	            operator = newOperator;
	            updatedOperator = newOperator;
	            labelString = labelnumber1 + " "  + " <font size='+2' color='" + labelClr + "'><b>" + updatedOperator + "</b></font> " + " ";
	            updateLabel();
	            return;
	        }
	        if (!pastNumber.isEmpty()) {
	            calculate();
	            operator = newOperator;
		        pastNumber = presentNumber;
		        presentNumber ="";
		        textField.setText(Sresult);
		        labelString = labelnumber1 + " <font size='+2' color='" + labelClr + "'<b>" + updatedOperator + "</b></font> " + labelnumber2 + " = ";
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
	        labelString =  labelnumber1 + " "  +  " <font size='+2' color='" + labelClr + "'<b>" + updatedOperator + "</b></font> "+ " ";
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
				clearOperation();
				Sresult = "cannot ÷ by 0";
				textField.setText("cannot ÷ by 0");
				divideByZero = true;
				return;
			} else {
				result = num1 / num2;
			}
			break;

		}
		presentNumber = String.valueOf(result);
		pastNumber = "";
		operator = null;
		processOutputNumber();
		Sresult  = presentNumber;
		updateTextField();
		labelString = labelnumber1 + " <font size='+2' color='" + labelClr + "'<b>" + updatedOperator + "</b></font> " + labelnumber2 + " = ";
	    calculateCalled = true;
	}

	static class btnPressedUI extends BasicButtonUI{
		protected void paintButtonPressed(Graphics g, AbstractButton b) {
            if (b.getModel().isArmed()) {
                g.setColor(btnUIClr);
                g.fillRect(0, 0, b.getWidth(), b.getHeight());
            }
        }
	}
	
	public void changeCustomColor() {
		fullBlack = false;
		fullLight = false;
		addBtn.setBackground(lastColoumClr);
		subtractBtn.setBackground(lastColoumClr);
		multiplyBtn.setBackground(lastColoumClr);
		divideBtn.setBackground(lastColoumClr);
		equalBtn.setBackground(lastColoumClr);
		deleteBtn.setForeground(lastColoumClr);
	}
	
	public void selectColor(String selectedColor) {
			switch (selectedColor) {
			case "Yellow":
				lastColoumClr = new Color(245,164, 11);// yellow color 4 buttons
				labelClr = "#E49B0F"; // yellow4white
				changeCustomColor();
				break;
			case "Red":
				lastColoumClr = new Color(255, 38, 38); // red done
				labelClr = "#FF2626";
				changeCustomColor();
				break;
			case "Blue":
				lastColoumClr = new Color(31, 81, 255) ; // blue done
				labelClr = "#1F51FF";
				changeCustomColor();
				break;
			case "Green": 
				lastColoumClr = new Color(34,180 , 34); // green done
				labelClr = "#22B422";
				changeCustomColor();
				break;

			case "Black (Simple)":
				lastColoumClr = new Color(46, 46, 46); 
				labelClr = "#FFFFFF";
				changeCustomColor();
				fullBlack = true;
				fullLight = false;
				
				deleteBtn.setForeground(new Color(255,255,255));
				
				break;
			case "White (Simple)":
				lastColoumClr = new Color(250, 250, 250); 
				labelClr = "#020202";
				changeCustomColor();
				fullLight = true;
				fullBlack = false;
				deleteBtn.setForeground(new Color(40,40,40));
				break;
			case "Cyan":
				lastColoumClr = new Color(0, 139, 139);// cyan color
				labelClr = "#008B8B";
				changeCustomColor();
				break;
		
	}
		
		labelString = labelString.replaceFirst("color='[^']+'", "color='" + labelClr + "'");
		updateLabel();
	}
	
	public void selectTheme() {

		if (darkMode) {
			
			backgroundClr = new Color(25,25,25);
			foregroundClr = new Color(255,255,255);
			panelBackClr = new Color(15,15,15);
			btnBackClr = new Color(46,46,46);
			btnFrontClr = new Color(255,255,255);
			btnUIClr = new Color(25,25,25);
			clearBtn.setIcon(deleteIcon);
			color5.setText("Black (Simple)");
			lightMode = false;
			applyThemeColor();
			
			 if (fullLight) {
				addBtn.setBackground(new Color(46, 46, 46));
				subtractBtn.setBackground(new Color(46, 46, 46));
				multiplyBtn.setBackground(new Color(46, 46, 46));
				divideBtn.setBackground(new Color(46, 46, 46));
				equalBtn.setBackground(new Color(46, 46, 46));
				deleteBtn.setForeground(new Color(255,255,255));
				labelClr = "#FFFFFF";
				labelString = labelString.replaceFirst("color='[^']+'", "color='" + labelClr + "'");
				updateLabel();
				fullBlack =true;
			} 
			
		} else if (lightMode) {
			
			backgroundClr = new Color(235,235,235);
			foregroundClr = new Color(2,2,2);
			panelBackClr = new Color(180,180,180);
			btnBackClr = new Color(250,250,250);
			btnFrontClr = new Color(40,40,40);
			btnUIClr = new Color(180,180,180);
			clearBtn.setIcon(deleteWhiteIcon);
			color5.setText("White (Simple)");
			darkMode = false;
			applyThemeColor();
			
			if (fullBlack) {
				addBtn.setBackground(new Color(250, 250, 250));
				subtractBtn.setBackground(new Color(250, 250, 250));
				multiplyBtn.setBackground(new Color(250, 250, 250));
				divideBtn.setBackground(new Color(250, 250, 250));
				equalBtn.setBackground(new Color(250, 250, 250));
				deleteBtn.setForeground(new Color(40, 40, 40));
				labelClr = "#020202";
				labelString = labelString.replaceFirst("color='[^']+'", "color='" + labelClr + "'");
				updateLabel();
				fullLight = true;
			}
		}
	}
	
	public void applyThemeColor() {
		
		textField.setForeground(foregroundClr);
		label.setForeground(foregroundClr);
		
		textField.setBackground(backgroundClr);
		label.setBackground(backgroundClr);
		panel.setBackground(panelBackClr);
		frame.getContentPane().setBackground(backgroundClr);
		menuBar.setBackground(backgroundClr);
		
		colors.setForeground(foregroundClr);
	    dark.setBackground(new Color(44,44,44));
	    dark.setForeground(new Color(210,210,210));
	    
	    color1.setBackground(new Color(245,164, 11));
	    color2.setBackground( new Color(255, 38, 38));
	    color3.setBackground(new Color(31, 81, 255) );
	    color4.setBackground(new Color(34, 180, 34));
	    color5.setBackground(btnBackClr);
	    color6.setBackground(new Color(0, 139, 139));
	    
	    color1.setForeground(foregroundClr);
	    color2.setForeground(foregroundClr);
	    color3.setForeground(foregroundClr);
	    color4.setForeground(foregroundClr);
	    color5.setForeground(foregroundClr);
	    color6.setForeground(foregroundClr);
		
		numberBtns[0].setBackground(btnBackClr);
		numberBtns[1].setBackground(btnBackClr);
		numberBtns[2].setBackground(btnBackClr);
		numberBtns[3].setBackground(btnBackClr);
		numberBtns[4].setBackground(btnBackClr);
		numberBtns[5].setBackground(btnBackClr);
		numberBtns[6].setBackground(btnBackClr);
		numberBtns[7].setBackground(btnBackClr);
		numberBtns[8].setBackground(btnBackClr);
		numberBtns[9].setBackground(btnBackClr);
		squareBtn.setBackground(btnBackClr);
		clearBtn.setBackground(btnBackClr);
		deleteBtn.setBackground(btnBackClr);
		negationBtn.setBackground(btnBackClr);
		decimalBtn.setBackground(btnBackClr);
		
		numberBtns[0].setForeground(btnFrontClr);
		numberBtns[1].setForeground(btnFrontClr);
		numberBtns[2].setForeground(btnFrontClr);
		numberBtns[3].setForeground(btnFrontClr);
		numberBtns[4].setForeground(btnFrontClr);
		numberBtns[5].setForeground(btnFrontClr);
		numberBtns[6].setForeground(btnFrontClr);
		numberBtns[7].setForeground(btnFrontClr);
		numberBtns[8].setForeground(btnFrontClr);
		numberBtns[9].setForeground(btnFrontClr);
		squareBtn.setForeground(btnFrontClr);
		clearBtn.setForeground(btnFrontClr);
		negationBtn.setForeground(btnFrontClr);
		decimalBtn.setForeground(btnFrontClr);
		// just foreground color for these buttons
		addBtn.setForeground(btnFrontClr);
		subtractBtn.setForeground(btnFrontClr);
		multiplyBtn.setForeground(btnFrontClr);
		divideBtn.setForeground(btnFrontClr);
		equalBtn.setForeground(btnFrontClr);
		
	}
	
	class NumBtnsHandler implements ActionListener, KeyListener{
		
		public void actionPerformed(ActionEvent e) {
			char inputChar = e.getActionCommand().charAt(0);
			
			 for( int i=0; i<10; i++) {
		            if (e.getSource() == numberBtns[i]){
		            	if (divideByZero) {
		            		clearOperation();
		            		presentNumber = String.valueOf(inputChar);
		            		divideByZero = false;
		            	}
		            	if (operatorCalled) {
		            		labelString = Sresult + " "  + " <font size='+2' color='" + labelClr + "'><b>" + updatedOperator + "</b></font> " + " ";
		            		updateLabel();
		            		presentNumber = String.valueOf(inputChar);
		            		operatorCalled = false;
		            		calculateCalled = false;
		            	} else if ( !operatorCalled && calculateCalled) {
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
		            frame.requestFocusInWindow();
		            
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
            	if (divideByZero) {
            		clearOperation();
            		presentNumber = String.valueOf(e.getKeyChar());
            		divideByZero = false;
            	}
			    
				if (operatorCalled) {
            		labelString = Sresult + " "  + " <font size='+2' color='" + labelClr + "'><b>" + updatedOperator + "</b></font> " + "";
            		updateLabel();
            		presentNumber = String.valueOf(e.getKeyChar());
            		operatorCalled = false;
            		calculateCalled = false;
            	} else if ( !operatorCalled && calculateCalled) {
            		clearOperation();
            		presentNumber = String.valueOf(e.getKeyChar());
            		calculateCalled = false;
            	}

            	else if (textField.getText().equals("0")) {
                    presentNumber = String.valueOf(e.getKeyChar());
                } else {
                	presentNumber = textField.getText() + e.getKeyChar();
                  }
				
				
            updateTextField();
            
		    } 	
			frame.requestFocusInWindow();
			
		}

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
				updateLabel();
			} else if (e.getSource() == squareBtn) {
				squareOperation();
			} else if (e.getSource() == clearBtn) {
				clearOperation();
			} else if (e.getSource() == deleteBtn) {
				deleteOperation();
			} else if (e.getSource() == negationBtn) {
				negationOperation();
			} else if (e.getSource() == decimalBtn) {
				decimalFunction();
			} else if (e.getSource() == dark) {
				darkMode = true;
				lightMode = false;
				selectTheme();
			} else if (e.getSource() == light) {
				lightMode = true;
				darkMode = false;
				selectTheme();
			} else if (e.getSource() == color1) {
				selectColor(color1.getText());
			} else if (e.getSource() == color2) {
				selectColor(color2.getText());
			} else if (e.getSource() == color3) {
				selectColor(color3.getText());
			} else if (e.getSource() == color4) {
				selectColor(color4.getText());
			} else if (e.getSource() == color5) {
				selectColor(color5.getText());
			} else if (e.getSource() == color6) {
				selectColor(color6.getText());
			}
			
			frame.requestFocusInWindow();
			
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
				updateLabel();
			} else if (e.getKeyChar() == KeyEvent.VK_SHIFT) {
				squareOperation();
			} else if (e.getKeyChar() == KeyEvent.VK_DELETE || e.getKeyChar() =='c') {
				clearOperation();
			} else if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
				deleteOperation();
			} else if (e.getKeyChar() == 'n' || e.getKeyChar() == 'N')  {
				negationOperation();
			} else if (e.getKeyChar() == '.') {
				decimalFunction();
			}
			
			frame.requestFocusInWindow();
	      }

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		} 		
	
	}

	
}
