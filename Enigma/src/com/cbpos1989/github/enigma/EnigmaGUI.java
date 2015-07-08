/**
 * 
 */
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
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DefaultEditor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.Container;

import javax.swing.Box;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.Insets;
import javax.swing.JRadioButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

/**
 * Class that implements all of the major GUI components.
 * 
 * @author Colm O'Sullivan
 * @version 1.0  
 * @dependencies None
 */

public class EnigmaGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7470739719745441939L;
	static boolean isDecoding = false;
	
	private char firstRow[] = {'Q','W','E','R','T','Z','U','I','O'};
	private char secondRow[] = {'A','S','D','F','G','H','J','K'};
	private char thirdRow[] = {'P','Y','X','C','V','B','N','M','L'};
	private JLabel[] lights = new JLabel[26];
	private int counter = 0;
	final private EnigmaHandler eh;
	private JTextField leftRtrTextField;
	private JTextField middleRtrTextField;
	private JTextField rightRtrTextField;
	
	/**
	 * Create the frame.
	 */
	public EnigmaGUI() {
		setBackground(Color.DARK_GRAY);
		eh = new EnigmaHandler(this);
		initialiseGui();
	}
	
	void initialiseGui(){
		GridLayout mainLayout = new GridLayout(2,1,0,0);
		
		getContentPane().setLayout(mainLayout);
		
		//Top Panel
		JPanel topPanel = new JPanel();
		topPanel.setBackground(Color.DARK_GRAY);
		topPanel.setLayout(new GridLayout(3,1,25,30));
		topPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		getContentPane().add(topPanel);
		
		//Headings Panel
		JPanel headingsPanel = new JPanel();
		headingsPanel.setBackground(Color.DARK_GRAY);
		headingsPanel.setLayout(new GridLayout(2,3,10,10));
		headingsPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		topPanel.add(headingsPanel);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		headingsPanel.add(horizontalStrut);
		
		JLabel titleLabel = new JLabel("Enigma Machine");
		titleLabel.setForeground(Color.LIGHT_GRAY);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 20));
		headingsPanel.add(titleLabel);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		headingsPanel.add(horizontalStrut_1);
		
		//Rotor Labels
		JLabel leftRtrLabel = new JLabel("Left Rotor");
		leftRtrLabel.setForeground(Color.LIGHT_GRAY);
		leftRtrLabel.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 16));
		leftRtrLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headingsPanel.add(leftRtrLabel);
		
		JLabel middleRtrLabel = new JLabel("Middle Rotor");
		middleRtrLabel.setForeground(Color.LIGHT_GRAY);
		middleRtrLabel.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 16));
		middleRtrLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headingsPanel.add(middleRtrLabel);
		
		JLabel rightRtrLabel = new JLabel("Right Rotor");
		rightRtrLabel.setForeground(Color.LIGHT_GRAY);
		rightRtrLabel.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 16));
		rightRtrLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headingsPanel.add(rightRtrLabel);
		
	
		//Rotor Options Panel
		JPanel optionsPanel = new JPanel();
		optionsPanel.setBackground(Color.DARK_GRAY);
		optionsPanel.setLayout(new GridLayout(1,6,10,10));
		optionsPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		topPanel.add(optionsPanel);
		
		//Rotor Spinners
		final JSpinner leftRtrSpinner = new JSpinner(new SpinnerListModel(new String[] {"I", "II", "III", "IV", "V"}));
		leftRtrSpinner.setFont(new Font("Cooper Black", Font.BOLD, 16));
		optionsPanel.add(leftRtrSpinner);
		
		leftRtrTextField = new JTextField();
		leftRtrTextField.setFont(new Font("Cooper Black", Font.BOLD, 16));
		leftRtrTextField.setHorizontalAlignment(SwingConstants.CENTER);
		leftRtrTextField.setPreferredSize(new Dimension(4, 20));
		optionsPanel.add(leftRtrTextField);
		leftRtrTextField.setColumns(10);
		leftRtrTextField.setText("A");
		
		final JSpinner middleRtrSpinner = new JSpinner(new SpinnerListModel(new String[] {"I", "II", "III", "IV", "V"}));
		middleRtrSpinner.setFont(new Font("Cooper Black", Font.BOLD, 16));
		optionsPanel.add(middleRtrSpinner);
		
		middleRtrTextField = new JTextField();
		middleRtrTextField.setHorizontalAlignment(SwingConstants.CENTER);
		middleRtrTextField.setFont(new Font("Cooper Black", Font.BOLD, 16));
		middleRtrTextField.setPreferredSize(new Dimension(4, 20));
		optionsPanel.add(middleRtrTextField);
		middleRtrTextField.setColumns(10);
		middleRtrTextField.setText("A");
		
		final JSpinner rightRtrSpinner = new JSpinner(new SpinnerListModel(new String[] {"I", "II", "III", "IV", "V"}));
		rightRtrSpinner.setFont(new Font("Cooper Black", Font.BOLD, 16));
		optionsPanel.add(rightRtrSpinner);
		
		rightRtrTextField = new JTextField();
		rightRtrTextField.setHorizontalAlignment(SwingConstants.CENTER);
		rightRtrTextField.setFont(new Font("Cooper Black", Font.BOLD, 16));
		rightRtrTextField.setMinimumSize(new Dimension(4, 20));
		optionsPanel.add(rightRtrTextField);
		rightRtrTextField.setColumns(10);
		rightRtrTextField.setText("A");
		
		
		//Options Commands Panel
		JPanel commandsPanel = new JPanel();
		commandsPanel.setBackground(Color.DARK_GRAY);
		commandsPanel.setLayout(new GridLayout(1,2,10,10));
		commandsPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		topPanel.add(commandsPanel);
		
		
		JButton btnCommitRotors = new JButton("Set Rotors");
		btnCommitRotors.setMargin(new Insets(2, 2, 2, 2));
		btnCommitRotors.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnCommitRotors.setPreferredSize(new Dimension(206, 23));
		btnCommitRotors.setMaximumSize(new Dimension(206, 23));
		btnCommitRotors.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 14));
		btnCommitRotors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int rightRtr = convertSpinnerValue(rightRtrSpinner);
				int middleRtr = convertSpinnerValue(middleRtrSpinner);
				int leftRtr = convertSpinnerValue(leftRtrSpinner);
				
				eh.createRotors(rightRtr, middleRtr, leftRtr);
			}
		});
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		commandsPanel.add(horizontalStrut_2);
		
		commandsPanel.add(btnCommitRotors);
		
		JRadioButton decodeRadioButton = new JRadioButton("Decode Message");
		decodeRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		decodeRadioButton.setForeground(Color.LIGHT_GRAY);
		decodeRadioButton.setBackground(Color.DARK_GRAY);
		decodeRadioButton.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(!isDecoding){
					isDecoding = true;
				} else {
					isDecoding = false;
				}
			}
		});
		decodeRadioButton.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 14));
		commandsPanel.add(decodeRadioButton);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		commandsPanel.add(horizontalStrut_4);
		
		//Bottom Panel
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBackground(Color.DARK_GRAY);
		bottomPanel.setLayout(new GridLayout(2,1,100,0));
		bottomPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		getContentPane().add(bottomPanel);
		
		//Light Panel
		JPanel lightPanel = new JPanel();
		lightPanel.setBackground(Color.DARK_GRAY);
		lightPanel.setLayout(new GridLayout(3,9,5,15));
		lightPanel.setBorder(BorderFactory.createEmptyBorder(10, 45, 10, 0));
		bottomPanel.add(lightPanel);
		
		createLights(firstRow, lightPanel);
		createLights(secondRow, lightPanel);
		createLights(thirdRow, lightPanel);
		
		//Button Panel
		JPanel keyboardPanel = new JPanel();
		keyboardPanel.setBackground(Color.DARK_GRAY);
		keyboardPanel.setLayout(new GridLayout(3,9,5,15));
		keyboardPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		bottomPanel.add(keyboardPanel);
		
		createButtons(firstRow, keyboardPanel);
		createButtons(secondRow, keyboardPanel);
		createButtons(thirdRow, keyboardPanel);
		
		setVisible(true);
	}
	
	
	public JTextField getTextField(int index){
		if(index == 1) {
			return this.rightRtrTextField;
		} else if (index == 2) {
			return this.middleRtrTextField;
		} else {
			return this.leftRtrTextField;
		}
	}
	
	public char getRotorText(JTextField textField){
		String textFieldStr = textField.getText();
		textFieldStr = textFieldStr.toUpperCase();
		return textFieldStr.charAt(0);
	}
	
	public void setRotorText(JTextField textField, int rotorValue){
		
		char rotorChar = (char) rotorValue;
		textField.setText(rotorChar + "");
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
		p.setBackground(Color.DARK_GRAY);
		
		for (int i = 0; i < chars.length; ++i) {
			lightRow[i] = new JLabel(chars[i] + "");
			lightRow[i].setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 16));
			lightRow[i].setForeground(Color.WHITE);
			p.add(lightRow[i]);
			addLightsToArray(lightRow[i]);
		}
		
		panel.add(p);
	}
	
	void createButtons(char[] keys, JPanel panel){
		JButton[] keyRow = new JButton[keys.length];
		
		JPanel p = new JPanel(new GridLayout(1,keys.length));
		p.setBackground(Color.DARK_GRAY);
		
		for (int i = 0; i < keys.length; ++i) {
			keyRow[i] = new JButton(keys[i] + "");
			keyRow[i].setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 16));
			p.add(keyRow[i]);
		}
		
		addButtonListeners(keyRow);
		panel.add(p);
		
	}
	
	void addButtonListeners(JButton[] buttons){
		for (JButton b: buttons) {
			b.addActionListener(eh);
		}
	}
}