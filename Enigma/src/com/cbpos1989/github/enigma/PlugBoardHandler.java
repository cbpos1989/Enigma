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
	private char[][] plugPairs = new char[13][2];
	private int i = 0;
	private int indexRow = 0;
	private JToggleButton[] tBtn = new JToggleButton[2];
	private JToggleButton[][] toggleButtons = new JToggleButton[13][2];
	
	
	
	private Color aqua = new Color(122,250,208);
	private Color purple = new Color(127,0,225);
	private Color darkGreen = new Color(0,102,51);
	private Color turquoise = new Color(12,170,179);
	private Color seaFoam = new Color(167,217,188);
	private Color beige = new Color(217,213,167);
	
	public int buttonCounter = 0;
	
	public PlugBoardHandler(PlugBoardMenu pbm ){
		this.pbm = pbm;
	}

	public char[] getSelectedButtons() {
		return selectedButtons;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
	
		
		JToggleButton tButton = (JToggleButton)event.getSource();
	
		if(tButton.isSelected()){
			if (buttonCounter < 2 && tBtn[0] == null){
				tBtn[0] = tButton;
				buttonCounter++;
				System.out.print("Selected ");
				this.buttonPressed(event.getActionCommand());
			} else if(buttonCounter < 2 && tBtn[1] == null){
				tBtn[1] = tButton;
				buttonCounter++;
				System.out.print("Selected ");
				this.buttonPressed(event.getActionCommand());
			}else {
				tButton.setSelected(false);
				System.out.print("No more buttons ");
			}
		} else {
			
			for(int i = 0; i < tBtn.length; ++i){
				if(tBtn[i] == tButton){
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
	
	void removeButtonFromArray(JToggleButton tBtn){
		for(int i = 0; i < toggleButtons.length; ++i){
			for(int j = 0; j < 2; ++j){
				if(toggleButtons[i][j] == tBtn){
					System.out.print("Deselected ");
				
					toggleButtons[i][j] = null;
				}
			}
		}
	}
	
	void addButtonToArray(){
		int j = 0;
		
		for (JToggleButton tb: tBtn){
			checkButtonArray(tb);
			toggleButtons[indexRow][j] = tb;
			j++;
		}
		
		pbm.lightUpBoard(toggleButtons);
		
		if(indexRow < 12){
			indexRow++;
		} else {
			indexRow = 0;
			checkButtonArrayOverwrite();
		}
		
		//set selectedToggle button back to default state
		tBtn[0].setSelected(false);
		tBtn[1].setSelected(false);
	
		//reset selected buttons
		tBtn[0] = null;
		tBtn[1] = null;
	}
	
	void addLetterToArray(){
		int j = 0;
		
		if(buttonCounter < selectedButtons.length){
			System.out.print("Need to select two buttons");
			
		} else {
			
			
			for (char c: selectedButtons){
				checkCharArray(c);
				plugPairs[i][j] = c;
				j++;
			}
			
			
			//increment row, reset if hits limit of pairs
			if(i < 12){
				i++;
			} else {
				i = 0;
				checkCharArrayOverwrite();
			}
			
			
			//reset selected chars
			selectedButtons[0] = 0;
			selectedButtons[1] = 0;
			
			//reset button counter
			buttonCounter = 0;
			
			printArray();
		}
		
	
	}
	
	//Ensures that one button will not be linked with another twice over in the array
	void checkButtonArray(JToggleButton tBtn){
		for(int i = 0; i < toggleButtons.length; ++i){
			for(int j = 0; j < 2; ++j){
				if(toggleButtons[i][j] == tBtn){
					toggleButtons[i][0] = null;
					toggleButtons[i][1] = null;
				}
			}
		}
	}
		
	void checkButtonArrayOverwrite(){
		outer:
		for(int i = 0; i < toggleButtons.length; ++i){
			for(int j = 0; j < 2;){
				if(toggleButtons[i][j] !=  null){
					this.indexRow++;
					System.out.println("indexRow has been incremneted " + this.indexRow);
					break;
				} else {
					System.out.println("indexRow has not been incremneted " + this.indexRow);
					break outer;
				}
			}
		}
	}
		
	
	//Ensures that one char will not be linked with another twice over in the array
	void checkCharArray(char checkLetter){
		for(int i = 0; i < plugPairs.length; ++i){
			for(int j = 0; j < 2; ++j){
				if(plugPairs[i][j] == checkLetter){
					plugPairs[i][0] = '\u0000';
					plugPairs[i][1] = '\u0000';
				}
			}
		}
	}
	
	void checkCharArrayOverwrite(){
		outer:
		for(int i = 0; i < plugPairs.length; ++i){
			for(int j = 0; j < 2;){
				if(plugPairs[i][j] !=  '\u0000'){
					this.i++;
					System.out.println("i has been incremneted " + this.i);
					break;
				} else {
					System.out.println("i has not been incremneted " + this.i);
					break outer;
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
			case 4: return beige;
			case 5: return Color.MAGENTA; 
			case 6: return Color.ORANGE; 
			case 7: return Color.PINK; 
			case 8: return Color.YELLOW; 
			case 9: return aqua; 
			case 10: return purple; 
			case 11: return seaFoam; 
			case 12: return darkGreen;
			case 13: return turquoise; 
			default: return Color.BLACK;
		}
	}
	
	//Testing purposes
	void printArray(){
		for(int i = 0; i < plugPairs.length; ++i){
			for(int j = 0; j < 2; ++j){
				System.out.print(plugPairs[i][j]);
			}
		}
		System.out.println("");
	}


}
