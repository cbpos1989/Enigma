/**
 * 
 */
package com.cbpos1989.github.enigma;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

/**
 * Class that handles the logic of the App.
 * 
 * @author Colm O'Sullivan
 * @version 1.0  
 * @dependencies None
 */
public class EnigmaHandler implements ActionListener{
	private EnigmaGUI eGui;
	private Rotor rotorRight;
	private Rotor rotorMiddle; 
	private Rotor rotorLeft;
	private boolean hasRotors;
	private PlugBoardHandler pbh;
	
	public EnigmaHandler(EnigmaGUI eGui, PlugBoardHandler pbh){
		this.eGui = eGui;
		this.hasRotors = false;
		this.pbh = pbh;
	
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(hasRotors){
			this.keyPressed(event.getActionCommand());
		} else {
			Component rotorMessage = null;
			JOptionPane.showMessageDialog(rotorMessage,
				    "Commit choosen rotors before coding message",
				    "Rotor Warning",
				    JOptionPane.WARNING_MESSAGE);
		}
	}
	
	void keyPressed(String letter){
		char codingLetter = letter.charAt(0);
		
		if (EnigmaGUI.isDecoding) {
			codingLetter = decodeLetter(codingLetter);
		} else {
			codingLetter = codeLetter(codingLetter);
		}

		System.out.print("//End//\n");
		this.lightUpLabel(codingLetter);
		
		checkRotorPosition(rotorRight);
		checkRotorPosition(rotorMiddle);
		checkRotorPosition(rotorLeft);
	
	}
	
	private char codeLetter(char codingLetter){
		//Pass in through the plugBoard
		System.out.print("//Plugboard In//");
		codingLetter = pbh.plugBoardSwitch(codingLetter);
		System.out.print(codingLetter + " ");
		
		//First Pass through the rotor's
		System.out.print("//1st Pass//");
		codingLetter = rotorRight.codeLetter(codingLetter);
		System.out.print(codingLetter + " ");
		
		codingLetter = rotorMiddle.codeLetter(codingLetter);
		System.out.print(codingLetter + " ");
		
		codingLetter = rotorLeft.codeLetter(codingLetter);
		System.out.print(codingLetter + " ");
		
		
		//Second pass back through the rotor's in opposite direction
		System.out.print("//2nd Pass//");
		codingLetter = rotorLeft.codeLetter(codingLetter);
		System.out.print(codingLetter + " ");
		
		codingLetter = rotorMiddle.codeLetter(codingLetter);
		System.out.print(codingLetter + " ");
		
		codingLetter = rotorRight.codeLetter(codingLetter);
		System.out.print(codingLetter + " ");
		
		//Pass out through the plugBoard
		System.out.print("//Plugboard Out//");
		codingLetter = pbh.plugBoardSwitch(codingLetter);
		System.out.print(codingLetter + " ");
		
		return codingLetter;
	}
	
	private char decodeLetter(char codingLetter){
		//Pass in through Plugboard
		System.out.print("//Plugboard In//");
		codingLetter = pbh.plugBoardSwitch(codingLetter);
		System.out.print(codingLetter + " ");
		
		//First Pass through the rotor's
		System.out.print("//1st Pass//");
		codingLetter = rotorRight.decodeLetter(codingLetter);
		System.out.print(codingLetter + " ");
		
		codingLetter = rotorMiddle.decodeLetter(codingLetter);
		System.out.print(codingLetter + " ");
		
		codingLetter = rotorLeft.decodeLetter(codingLetter);
		System.out.print(codingLetter + " ");
		
		//Second pass back through the rotor's in opposite direction
		System.out.print("//2nd Pass//");
		codingLetter = rotorLeft.decodeLetter(codingLetter);
		System.out.print(codingLetter + " ");
		
		codingLetter = rotorMiddle.decodeLetter(codingLetter);
		System.out.print(codingLetter + " ");
		
		codingLetter = rotorRight.decodeLetter(codingLetter);
		System.out.print(codingLetter + " ");
		
		//Pass out through Plugboard
		System.out.print("//Plugboard Out//");
		codingLetter = pbh.plugBoardSwitch(codingLetter);
		System.out.print(codingLetter + " ");
		
		return codingLetter;
		
	}
	
	public void createRotors(int rightRtr, int middleRtr, int leftRtr){
		rotorRight = new Rotor(1,rightRtr, eGui);
		rotorMiddle = new Rotor(2,middleRtr, eGui);
		rotorLeft = new Rotor(3,leftRtr, eGui);
		hasRotors = true;
	}
	
	void lightUpLabel(char letter){
	Color clr = Color.YELLOW;
		
		//Reset Lights before lighting up a new letter
		for(int i =0; i < 26; ++i){
			eGui.lightUpLabel(i, Color.WHITE);
		}
		
		switch(letter){
		case 'Q': eGui.lightUpLabel(0, clr); break;
		case 'W': eGui.lightUpLabel(1,clr); break;
		case 'E': eGui.lightUpLabel(2,clr); break;
		case 'R': eGui.lightUpLabel(3,clr); break;
		case 'T': eGui.lightUpLabel(4,clr); break;
		case 'Z': eGui.lightUpLabel(5,clr); break;
		case 'U': eGui.lightUpLabel(6,clr); break;
		case 'I': eGui.lightUpLabel(7,clr); break;
		case 'O': eGui.lightUpLabel(8,clr); break;
		case 'A': eGui.lightUpLabel(9,clr); break;
		case 'S': eGui.lightUpLabel(10,clr); break;
		case 'D': eGui.lightUpLabel(11,clr); break;
		case 'F': eGui.lightUpLabel(12,clr); break;
		case 'G': eGui.lightUpLabel(13,clr); break;
		case 'H': eGui.lightUpLabel(14,clr); break;
		case 'J': eGui.lightUpLabel(15,clr); break;
		case 'K': eGui.lightUpLabel(16,clr); break;
		case 'P': eGui.lightUpLabel(17,clr); break;
		case 'Y': eGui.lightUpLabel(18,clr); break;
		case 'X': eGui.lightUpLabel(19,clr); break;
		case 'C': eGui.lightUpLabel(20,clr); break;
		case 'V': eGui.lightUpLabel(21,clr); break;
		case 'B': eGui.lightUpLabel(22,clr); break;
		case 'N': eGui.lightUpLabel(23,clr); break;
		case 'M': eGui.lightUpLabel(24,clr); break;
		case 'L': eGui.lightUpLabel(25,clr); break;
		}
	}
	
	//Carries out the function of shifting the letters on the rotor's depend on position and if a notch was hit.
	void checkRotorPosition(Rotor rotor){
		switch(rotor.getRotorPosition()){
		case 1: rotor.shiftLetterArray(); break;
		case 2: if(rotorRight.getRotorNotchCounter() == rotorRight.getRotorNotch()){
					rotor.shiftLetterArray();
				}; break;
		case 3: if(rotorMiddle.getRotorNotchCounter() == rotorMiddle.getRotorNotch()){
					rotor.shiftLetterArray();
				}; break;
		}
	}
}
