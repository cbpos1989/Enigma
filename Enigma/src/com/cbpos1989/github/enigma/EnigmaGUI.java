package com.cbpos1989.github.enigma;


import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;


public class EnigmaGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7470739719745441939L;
	

	
	private char firstRow[] = {'Q','W','E','R','T','Z','U','I','O'};
	private char secondRow[] = {'A','S','D','F','G','H','J','K'};
	private char thirdRow[] = {'P','Y','X','C','V','B','N','M','L'};
	private JLabel[] lights = new JLabel[26];
	
	private int counter = 0;
	

	/**
	 * Create the frame.
	 */
	public EnigmaGUI() {
		
		setBounds(100, 100, 450, 300);
		initialiseGui();
	
	}
	
	
	void initialiseGui(){
		GridLayout mainLayout = new GridLayout(2,1,100,0);
		getContentPane().setLayout(mainLayout);
		
		//Light Panel
		JPanel lightPanel = new JPanel();
		lightPanel.setBorder(BorderFactory.createEmptyBorder(50,400,50,50));
		lightPanel.setLayout(new GridLayout(3,9,5,15));
		//lightPanel.setLayout(null);
		lightPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		getContentPane().add(lightPanel);
		
//		JLabel lblQ = new JLabel("Q");
//		lblQ.setHorizontalAlignment(SwingConstants.CENTER);
//		lblQ.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		lblQ.setBounds(10, 11, 25, 25);
//		lightPanel.add(lblQ);
//		addLightsToArray(lblQ);
//	
//		JLabel lblW = new JLabel("W");
//		lblW.setHorizontalAlignment(SwingConstants.CENTER);
//		lblW.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		lblW.setBounds(36, 11, 25, 25);
//		lightPanel.add(lblW);
		
		createLights(firstRow, lightPanel);
		createLights(secondRow, lightPanel);
		createLights(thirdRow, lightPanel);
		
		//Button Panel
		JPanel keyboardPanel = new JPanel();
		keyboardPanel.setLayout(new GridLayout(3,9,5,15));
		keyboardPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		getContentPane().add(keyboardPanel);
		
		createButtons(firstRow, keyboardPanel);
		createButtons(secondRow, keyboardPanel);
		createButtons(thirdRow, keyboardPanel);
		
		setVisible(true);
	}
	
	void sortCharArray(char[] charArray){
		//sort(char[] charArray);
	}
	
	void addLightsToArray(JLabel label){
		lights[counter] = label;
		counter++;
	}
	
	
	void lightUpLabel(int i, Color clr){
		lights[i].setForeground(clr);
	}
	
	void createLights(char[] chars, JPanel panel){
		JLabel[] lightRow = new JLabel[chars.length];
		JPanel p = new JPanel(new GridLayout(1,chars.length));
		
		for (int i = 0; i < chars.length; ++i) {
			lightRow[i] = new JLabel(chars[i] + "");
			p.add(lightRow[i]);
			addLightsToArray(lightRow[i]);
		}
		
		panel.add(p);
	}
	
	void createButtons(char[] keys, JPanel panel){
		JButton[] keyRow = new JButton[keys.length];
		
		JPanel p = new JPanel(new GridLayout(1,keys.length));
		
		for (int i = 0; i < keys.length; ++i) {
			keyRow[i] = new JButton(keys[i] + "");
			p.add(keyRow[i]);
		}
		
		addButtonListeners(keyRow);
		panel.add(p);
		
	}
	
	void addButtonListeners(JButton[] buttons){
		EnigmaHandler eh = new EnigmaHandler(this);
		
		for (JButton b: buttons) {
			b.addActionListener(eh);
		}
	}
}
