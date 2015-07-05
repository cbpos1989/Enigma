package com.cbpos1989.github.enigma;


import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpinnerListModel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;


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
	private int rotorValue = 0;
	
	/**
	 * Create the frame.
	 */
	public EnigmaGUI() {
		setBounds(100, 100, 535, 435);
		initialiseGui();
	}
	
	void initialiseGui(){
		EnigmaHandler eh = new EnigmaHandler(this);
		
		GridLayout mainLayout = new GridLayout(3,1,100,0);
		getContentPane().setLayout(mainLayout);
		
		//Options Panel
		JPanel optionsPanel = new JPanel();
		optionsPanel.setLayout(new GridLayout(2,3,10,10));
		getContentPane().add(optionsPanel);
		
		//Rotor Labels
		JLabel leftRtrLabel = new JLabel("Left Rotor");
		leftRtrLabel.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 16));
		leftRtrLabel.setHorizontalAlignment(SwingConstants.CENTER);
		optionsPanel.add(leftRtrLabel);
		
		JLabel middleRtrLabel = new JLabel("Middle Rotor");
		middleRtrLabel.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 16));
		middleRtrLabel.setHorizontalAlignment(SwingConstants.CENTER);
		optionsPanel.add(middleRtrLabel);
		
		JLabel rightRtrLabel = new JLabel("Right Rotor");
		rightRtrLabel.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 16));
		rightRtrLabel.setHorizontalAlignment(SwingConstants.CENTER);
		optionsPanel.add(rightRtrLabel);
		
		//Rotor Spinners
		JSpinner leftRtrSpinner = new JSpinner(new SpinnerListModel(new String[] {"I", "II", "III", "IV", "V"}));
		leftRtrSpinner.setFont(new Font("Cooper Black", Font.BOLD, 16));
		optionsPanel.add(leftRtrSpinner);
		
		JSpinner MiddleRtrSpinner = new JSpinner(new SpinnerListModel(new String[] {"I", "II", "III", "IV", "V"}));
		MiddleRtrSpinner.setFont(new Font("Cooper Black", Font.BOLD, 16));
		optionsPanel.add(MiddleRtrSpinner);
		
		JSpinner RightRtrSpinner = new JSpinner(new SpinnerListModel(new String[] {"I", "II", "III", "IV", "V"}));
		RightRtrSpinner.setFont(new Font("Cooper Black", Font.BOLD, 16));
		optionsPanel.add(RightRtrSpinner);
	

		
		//Light Panel
		JPanel lightPanel = new JPanel();
		lightPanel.setLayout(new GridLayout(3,9,5,15));
		lightPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		getContentPane().add(lightPanel);
		
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