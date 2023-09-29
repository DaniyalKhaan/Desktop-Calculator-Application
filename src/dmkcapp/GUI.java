package dmkcapp;
// make sure to remove all imports and then add necessary imports one by one

//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.JTextField;
//import javax.swing.SwingConstants;
//import javax.swing.JLabel;
//import javax.swing.JButton;
//import java.awt.Color;
//import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;


class GUI {
	JFrame frame;
	JPanel panel;
	JTextField textField;
	JLabel label;
	JButton addBtn, subtractBtn, multiplyBtn, divideBtn, squareBtn ;
	JButton decimalBtn, negationBtn, deleteBtn, clearBtn, equalBtn ;
	// see if I can add decimal number into numbersBtns array;
	JButton numbersBtns[];
	JButton functionBtns[];
	
	public GUI() {
		// Style frame
		frame = new JFrame();
		frame.setTitle("DMK Calculator");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(314, 530);
	    frame.setLayout(null);
	    frame.getContentPane().setBackground(new Color(30,30,30));
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
	    frame.requestFocusInWindow();
	    
	    // Style Panel
	    panel = new JPanel();
	    panel.setBounds(3, 140, 298, 349);
	    panel.setLayout(new GridLayout(5, 4, 2, 2));
	    panel.setBackground(new Color(25, 25, 25));
	    panel.setForeground(new Color(255, 255, 255));
	    
	    // Style textField
	    textField = new JTextField();
	    textField.setBounds(0, 43, 300, 95);
	    textField.setFont(new Font("Calibri", Font.PLAIN,40));
	    textField.setHorizontalAlignment(SwingConstants.RIGHT);
	    textField.setBackground(new Color(30, 30, 30));
	    textField.setForeground(new Color(255,255,255));
	    textField.setEditable(false);
	    textField.setBorder(BorderFactory.createBevelBorder(3));
	    
	 // Style label
	    label.setBounds(0,5,304,40);
	    label.setHorizontalAlignment(SwingConstants.RIGHT);
	    label.setBackground(new Color(30,30,30));
	    label.setForeground(new Color(255,255,255));
	    label.setBorder(BorderFactory.createBevelBorder(3));
	    label.setOpaque(true);
	    
	    subtractBtn = new JButton("–");
	    addBtn = new JButton("+");
	    divideBtn = new JButton("÷");
	    multiplyBtn = new JButton("×");
	    decimalBtn = new JButton("•");
	    deleteBtn = new JButton("");
	    clearBtn = new JButton("C");
	    equalBtn = new JButton("=");
	    negationBtn = new JButton("±");
	    squareBtn = new JButton("<html>x<sup>2</sup></html>");
		
	}
}