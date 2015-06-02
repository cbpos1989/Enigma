package com.cbpos1989.github.enigma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 */

/**
 * @author Colm O'Sullivan
 *
 */
public class EnigmaHandler implements ActionListener{
	private EnigmaGUI eGui;
	
	public EnigmaHandler(EnigmaGUI eGui){
		this.eGui = eGui;
		
	}

	
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		this.keyPressed(event.getActionCommand());
	}
	
	void keyPressed(String letter){
		System.out.print(letter + " ");
	}
}
