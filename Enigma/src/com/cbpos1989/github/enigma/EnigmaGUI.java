package com.cbpos1989.github.enigma;


import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class EnigmaGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7470739719745441939L;
	
	private JButton[] buttons = new JButton[26];
	

	/**
	 * Create the frame.
	 */
	public EnigmaGUI() {
		
		setBounds(100, 100, 450, 300);
		createButtons();
		addButtonListeners();
		initialiseGui();
	
	}
	
	
	void initialiseGui(){
		//Button Panel
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(4,7,0,15));
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		addButtonsToPanel(buttonPanel);
		add(buttonPanel);
		
		setVisible(true);
	}
	
	void createButtons(){
		char c = 'A';
		for (int i = 0; i < 26; ++i){
			buttons[i] = new JButton(Character.toString(c++));
		}
	}
	
	void addButtonListeners(){
		EnigmaHandler eh = new EnigmaHandler(this);
		
		for (JButton b: buttons) {
			b.addActionListener(eh);
		}
	}
	
	void addButtonsToPanel(JPanel panel){
		for (JButton b: buttons) {
			panel.add(b);
		}
	}
	
}
