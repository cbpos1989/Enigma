package com.cbpos1989.github.enigma;


import java.awt.GridLayout;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpinnerListModel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


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
	final private EnigmaHandler eh;
	
	/**
	 * Create the frame.
	 */
	public EnigmaGUI() {
		eh = new EnigmaHandler(this);
		setBounds(100, 100, 535, 435);
		initialiseGui();
	}
	
	void initialiseGui(){
		
		
		GridLayout mainLayout = new GridLayout(3,1,100,0);
		getContentPane().setLayout(mainLayout);
		
		//Options Panel
		JPanel optionsPanel = new JPanel();
		optionsPanel.setLayout(new GridLayout(3,3,10,10));
		optionsPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
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
		final JSpinner leftRtrSpinner = new JSpinner(new SpinnerListModel(new String[] {"I", "II", "III", "IV", "V"}));
		leftRtrSpinner.setFont(new Font("Cooper Black", Font.BOLD, 16));
		optionsPanel.add(leftRtrSpinner);
		
		
	
		
		final JSpinner middleRtrSpinner = new JSpinner(new SpinnerListModel(new String[] {"I", "II", "III", "IV", "V"}));
		middleRtrSpinner.setFont(new Font("Cooper Black", Font.BOLD, 16));
		optionsPanel.add(middleRtrSpinner);
		
		final JSpinner rightRtrSpinner = new JSpinner(new SpinnerListModel(new String[] {"I", "II", "III", "IV", "V"}));
		rightRtrSpinner.setFont(new Font("Cooper Black", Font.BOLD, 16));
		optionsPanel.add(rightRtrSpinner);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.LIGHT_GRAY);
		optionsPanel.add(separator);
		
		JButton btnCommitRotors = new JButton("Commit Rotors");
		btnCommitRotors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int rightRtr = convertSpinnerValue(rightRtrSpinner);
				int middleRtr = convertSpinnerValue(middleRtrSpinner);
				int leftRtr = convertSpinnerValue(leftRtrSpinner);
				
				eh.createRotors(rightRtr, middleRtr, leftRtr);
			}
		});
		optionsPanel.add(btnCommitRotors);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.LIGHT_GRAY);
		optionsPanel.add(separator_1);
		
		//getSpinnerValue(rightRtrSpinner);
		
		//Light Panel
		JPanel lightPanel = new JPanel();
		lightPanel.setLayout(new GridLayout(3,9,5,15));
		lightPanel.setBorder(BorderFactory.createEmptyBorder(10, 45, 10, 0));
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
	
	Object getSpinnerValue(JSpinner spinner){
		try {
			spinner.commitEdit();
		} catch (ParseException pe) {
			  // Edited value is invalid, spinner.getValue() will return
		      // the last valid value, you could revert the spinner to show that:
		      JComponent editor = spinner.getEditor();
		      if (editor instanceof DefaultEditor) {
		          ((DefaultEditor)editor).getTextField().setValue(spinner.getValue());
		      }
		      // reset the value to some known value:
		      spinner.setValue(spinner.getPreviousValue());
		      // or treat the last valid value as the current, in which
		      // case you don't need to do anything.
		}
		
		return spinner.getValue();
	}
	
	int convertSpinnerValue(JSpinner spinner){
		switch(getSpinnerValue(spinner).toString()){
		case "I": 	return 1; 
		case "II": 	return 2; 
		case "III": return 3;
		case "IV":	return 4; 
		case "V": 	return 5; 
		default: 	return 0; //Should never be able to reach this point only added to keep complier happy
		}
		
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
			lightRow[i].setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 16));
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
			keyRow[i].setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 16));
			p.add(keyRow[i]);
		}
		
		addButtonListeners(keyRow);
		panel.add(p);
		
	}
	
	void addButtonListeners(JButton[] buttons){
		//eh = new EnigmaHandler(this);
		
		for (JButton b: buttons) {
			b.addActionListener(eh);
		}
	}
}