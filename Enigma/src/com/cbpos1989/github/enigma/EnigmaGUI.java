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
	

	private JPanel buttonPanel;
	private char firstRow[] = {'Q','W','E','R','T','Z','U','I','O'};
	private char secondRow[] = {'A','S','D','F','G','H','J','K'};
	private char thirdRow[] = {'P','Y','X','C','V','B','N','M','L'};
	

	/**
	 * Create the frame.
	 */
	public EnigmaGUI() {
		
		setBounds(100, 100, 450, 300);
		initialiseGui();
	
	}
	
	
	void initialiseGui(){
		GridLayout mainLayout = new GridLayout(2,1,100,0);
		setLayout(mainLayout);
		
		//Light Panel
		JPanel lightPanel = new JPanel();
		lightPanel.setBorder(BorderFactory.createEmptyBorder(50,400,50,50));
		this.add(lightPanel);
		
		//Button Panel
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(3,7,0,15));
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		add(buttonPanel);
		setVisible(true);
		
		createButtons(firstRow);
		createButtons(secondRow);
		createButtons(thirdRow);
	}
	
	void createButtons(char[] keys){
		JButton[] keyRow = new JButton[keys.length];
		
		JPanel p = new JPanel(new GridLayout(1,keys.length));
		
		for (int i = 0; i < keys.length; ++i){
			keyRow[i] = new JButton(keys[i] + "");
			p.add(keyRow[i]);
		}
		
		addButtonListeners(keyRow);
		buttonPanel.add(p);
		
	}
	
	void addButtonListeners(JButton[] buttons){
		EnigmaHandler eh = new EnigmaHandler(this);
		
		for (JButton b: buttons) {
			b.addActionListener(eh);
		}
	}
	
	
}
