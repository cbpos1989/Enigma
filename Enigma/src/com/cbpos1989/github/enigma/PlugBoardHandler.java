/**
 * 
 */
package com.cbpos1989.github.enigma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Icon;
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
	private JToggleButton[] selectedButtons = new JToggleButton[2];
	
	
	public int buttonCounter = 0;
	
	public PlugBoardHandler(PlugBoardMenu pbm){
		this.pbm = pbm;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
	
		JToggleButton tBtn = (JToggleButton)event.getSource();
		if(tBtn.isSelected()){
			if (buttonCounter < 2){
				selectedButtons[buttonCounter] = tBtn;
				buttonCounter++;
				System.out.print("Selected ");
				this.buttonPressed(event.getActionCommand());
			} else {
				tBtn.setSelected(false);
				System.out.print("No more buttons ");
			}
		} else {
			selectedButtons[buttonCounter -1] = null;
			buttonCounter--;
			System.out.print("Deselected ");
		}
		
		
//		if (buttonCounter > 1 && (selectedButtons[0] != tBtn || selectedButtons[1] != tBtn)){
//			//buttonCounter = 2;
//			tBtn.setSelected(false);
//			
//		} else if (buttonCounter > 1 && selectedButtons[1] == tBtn){
//			selectedButtons[buttonCounter -1] = null;
//			buttonCounter--;
//			System.out.print("Deselected ");
//		} else {
//			selectedButtons[buttonCounter] = tBtn;
//			buttonCounter++;
//			System.out.print("Selected ");
//			
//			this.buttonPressed(event.getActionCommand());
//		}
		
		System.out.print(buttonCounter + " \n");
	}
	
	void buttonPressed(String letter){
		System.out.print(letter + " ");
	}


}
