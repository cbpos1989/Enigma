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
	private int i = 0;
	private int j = 0;
	private JToggleButton[] tBtn = new JToggleButton[2];
	
	public int buttonCounter = 0;
	
	public PlugBoardHandler(PlugBoardMenu pbm){
		this.pbm = pbm;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
	
		tBtn[buttonCounter] = (JToggleButton)event.getSource();
		if(tBtn[buttonCounter].isSelected()){
			if (buttonCounter < 2){
				//selectedButtons[buttonCounter] = tBtn;
				buttonCounter++;
				System.out.print("Selected ");
				this.buttonPressed(event.getActionCommand());
			} else {
				tBtn[buttonCounter].setSelected(false);
				System.out.print("No more buttons ");
			}
		} else {
			buttonCounter--;
			tBtn[buttonCounter] = null;
			System.out.print("Deselected ");
		}
		
		System.out.print(buttonCounter + " \n");
	}
	
	void buttonPressed(String letter){
		char letterChar = letter.charAt(0);
		System.out.print(letter + " ");
		selectedButtons[buttonCounter - 1] = letterChar;
	}
	
	void addLetterToArray(){
		if(buttonCounter < 1){
			System.out.print("Need to select two buttons");
		} else {
			for (char c: selectedButtons){
				plugPairs[i][j] = c;
				j++;
			}
			
			//increment row and reset columns
			i++;
			j = 0;
		}
		
		//reset selected chars
		selectedButtons[0] = 0;
		selectedButtons[1] = 0;
		
		//set selectedToggle button back to default state
		tBtn[0].setSelected(false);
		tBtn[1].setSelected(false);
		
		//reset selected buttons
		tBtn[0] = null;
		tBtn[1] = null;
		
		//reset button counter
		buttonCounter = 0;
	}
	
	void printArray(){
		for(char[] c: plugPairs){
			System.out.print(c);
		}
	}


}
