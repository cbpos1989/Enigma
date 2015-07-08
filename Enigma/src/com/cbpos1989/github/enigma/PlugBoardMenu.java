package com.cbpos1989.github.enigma;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerModel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;
import javax.swing.JList;
import javax.swing.JTextField;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

public class PlugBoardMenu extends JFrame {

	private JPanel contentPane;
	private char firstRow[] = {'Q','W','E','R','T','Z','U','I','O'};
	private char secondRow[] = {'A','S','D','F','G','H','J','K'};
	private char thirdRow[] = {'P','Y','X','C','V','B','N','M','L'};
	private char[] alpha = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	private JPanel plugPanel;
	private JTextField textField;
	/**
	 * Create the frame.
	 */
	public PlugBoardMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 300);
		GridLayout mainLayout = new GridLayout(1,1,10,10);
		getContentPane().setLayout(mainLayout);
		initialiseGui();
	}
	
	void initialiseGui(){
		//Plugboard Panel
		plugPanel = new JPanel();
		plugPanel.setLayout(new GridLayout(4,1,10,10));
		plugPanel.setBackground(Color.DARK_GRAY);
		getContentPane().add(plugPanel);
		
		textField = new JTextField();
		textField.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent arg0) {
			}
			public void inputMethodTextChanged(InputMethodEvent arg0) {
				System.out.print("Hello");
			}
		});
		
		plugPanel.add(textField);
		textField.setColumns(10);
		
		JLabel plugboardLabel = new JLabel("Enigma Plugboard");
		plugboardLabel.setForeground(Color.LIGHT_GRAY);
		plugboardLabel.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 16));
		plugboardLabel.setHorizontalAlignment(SwingConstants.CENTER);
		plugPanel.add(plugboardLabel);
		

		
		createPlugs(firstRow, plugPanel);
		createPlugs(secondRow, plugPanel);
		createPlugs(thirdRow, plugPanel);
		
		setVisible(true);
	}

	
	
	public void createPlugs(char[] chars, JPanel panel){
		JLabel[] plugRow = new JLabel[chars.length];
		JSpinner[] spinnerRow = new JSpinner[chars.length];
		JPanel p = new JPanel(new GridLayout(1,chars.length * 2));
		p.setBackground(Color.DARK_GRAY);
		
		for (int i = 0; i < chars.length; ++i) {
			plugRow[i] = new JLabel(chars[i] + "");
			spinnerRow[i] = new JSpinner();
			plugRow[i].setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 16));
			plugRow[i].setForeground(Color.WHITE);
			plugRow[i].setAlignmentY(CENTER_ALIGNMENT);
			p.add(plugRow[i]);
			p.add(spinnerRow[i]);
			
		}
		
		panel.add(p);
	}
}
