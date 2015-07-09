/**
 * 
 */
package com.cbpos1989.github.enigma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JToggleButton;

/**
 * Class that handles the logic of the Plugboard.
 * 
 * @author Colm O'Sullivan
 * @version 1.0  
 * @dependencies None
 */

public class PlugBoardHandler implements ActionListener{
	private PlugBoardMenu pbm;
	private char[] selectedButtons = new char[2];
	private char[][] plugPairs = {{'A','A'},{'B','B'},{'C','C'},{'D','D'},{'E','E'},{'F','F'},{'G','G'},{'H','H'},{'I','I'},{'J','J'},{'K','K'},{'L','L'},{'M','M'},{'N','N'},{'O','O'},{'P','P'},{'Q','Q'},{'R','R'},{'S','S'},{'T','T'},{'U','U'},{'V','V'},{'W','W'},{'X','X'},{'Y','Y'},{'Z','Z'}};
	
	
	public int buttonCounter = 0;
	
	public PlugBoardHandler(PlugBoardMenu pbm){
		this.pbm = pbm;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
	
		JToggleButton tBtn = (JToggleButton)event.getSource();
		if(tBtn.isSelected()){
			if (buttonCounter < 2){
				//selectedButtons[buttonCounter] = tBtn;
				buttonCounter++;
				System.out.print("Selected ");
				this.buttonPressed(event.getActionCommand());
			} else {
				tBtn.setSelected(false);
				System.out.print("No more buttons ");
			}
		} else {
			//selectedButtons[buttonCounter -1] = null;
			buttonCounter--;
			System.out.print("Deselected ");
		}
		
		System.out.print(buttonCounter + " \n");
	}
	
	void buttonPressed(String letter){
		char letterChar = letter.charAt(0);
		System.out.print(letter + " ");
		selectedButtons[buttonCounter] = letterChar;
	}
	
	void addLetterToArray(){
		
	}


}
