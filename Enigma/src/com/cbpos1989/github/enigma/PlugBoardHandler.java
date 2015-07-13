/**
 * 
 */
package com.cbpos1989.github.enigma;

import java.awt.Color;
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
	private char[][] plugPairs = new char[13][13];
	private int i = 0;
	private JToggleButton[] tBtn = new JToggleButton[2];
	
	private Color aqua = new Color(122,250,208);
	private Color skyBlue = new Color(204,229,255);
	private Color purple = new Color(127,0,225);
	private Color darkGreen = new Color(0,102,51);
	private Color navy = new Color(0,0,153);
	
	public int buttonCounter = 0;
	
	public PlugBoardHandler(PlugBoardMenu pbm ){
		this.pbm = pbm;
	}

	
	@Override
	public void actionPerformed(ActionEvent event) {
	
		
		JToggleButton temp = (JToggleButton)event.getSource();
		if(temp.isSelected()){
			if (buttonCounter < 2 && tBtn[0] == null){
				tBtn[0] = temp;
				buttonCounter++;
				System.out.print("Selected ");
				this.buttonPressed(event.getActionCommand());
			} else if(buttonCounter < 2 && tBtn[1] == null){
				tBtn[1] = temp;
				buttonCounter++;
				System.out.print("Selected ");
				this.buttonPressed(event.getActionCommand());
			}else {
				temp.setSelected(false);
				System.out.print("No more buttons ");
			}
		} else {
			
			for(int i = 0; i < tBtn.length; ++i){
				if(tBtn[i] == temp){
					System.out.print("Deselected ");
					tBtn[i] = null;
				}
			}
			buttonCounter--;
		}
		
		System.out.print(buttonCounter + " \n");
	}
	
	void buttonPressed(String letter){
		char letterChar = letter.charAt(0);
		System.out.print(letter + " ");
		selectedButtons[buttonCounter - 1] = letterChar;
	}
	
	void addLetterToArray(){
		int j = 0;
		if(buttonCounter < selectedButtons.length){
			System.out.print("Need to select two buttons");
			
		} else {
			for (char c: selectedButtons){
				checkArray(c);
				plugPairs[i][j] = c;
				j++;
			}
		
			
			//increment row, reset if hits limit of pairs
			if(i < 12){
				i++;
			} else {
				i = 0;
			}
			
			pbm.lightUpPlugs(tBtn[0], tBtn[1], colourPicker(i));
			
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
		
	
	}
	
	void checkArray(char checkLetter){
		for(int i = 0; i < plugPairs.length; ++i){
			for(int j = 0; j < 2; ++j){
				if(plugPairs[i][j] == checkLetter){
					plugPairs[i][0] = ' ';
					plugPairs[i][1] = ' ';
				}
			}
		}
	}
	
	//Search for passed in letter in 2D Array if found return its matching pair, otherwise return passed in letter.
	char plugBoardSwitch(char letter){
		
		for (int i = 0; i < plugPairs.length; ++i) {
			for(int j = 0; j < 2; ++j){
				if(plugPairs[i][j] == letter){
					if(j == 0){
						return plugPairs[i][j+1];
					} else {
						return plugPairs[i][j-1];
					}
				}
			}
		}
		
		return letter;
	}
	
	Color colourPicker(int index){
		switch(index){
			case 1: return Color.BLUE; 
			case 2: return Color.RED;
			case 3: return Color.CYAN; 
			case 4: return Color.GREEN;
			case 5: return Color.MAGENTA; 
			case 6: return Color.ORANGE; 
			case 7: return Color.PINK; 
			case 8: return Color.YELLOW; 
			case 9: return aqua; 
			case 10: return purple; 
			case 11: return skyBlue; 
			case 12: return darkGreen;
			case 13: return navy; 
			default: return Color.GREEN;
		}
	}
	
	//Testing purposes
	void printArray(){
		for(char[] c: plugPairs){
			System.out.println(c);
		}
	}


}
