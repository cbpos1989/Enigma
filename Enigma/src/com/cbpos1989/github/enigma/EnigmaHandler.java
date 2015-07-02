package com.cbpos1989.github.enigma;

import java.awt.Color;
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
		Color clr = Color.RED;
		
		//for(JLabel lbl: eGui.lig);
		switch(letter){
		case "Q": eGui.lightUpLabel(0, clr); break;
		case "W": eGui.lightUpLabel(1,clr); break;
		case "E": eGui.lightUpLabel(2,clr); break;
		case "R": eGui.lightUpLabel(3,clr); break;
		case "T": eGui.lightUpLabel(4,clr); break;
		case "Z": eGui.lightUpLabel(5,clr); break;
		case "U": eGui.lightUpLabel(6,clr); break;
		case "I": eGui.lightUpLabel(7,clr); break;
		case "O": eGui.lightUpLabel(8,clr); break;
		case "A": eGui.lightUpLabel(9,clr); break;
		case "S": eGui.lightUpLabel(10,clr); break;
		case "D": eGui.lightUpLabel(11,clr); break;
		case "F": eGui.lightUpLabel(12,clr); break;
		case "G": eGui.lightUpLabel(13,clr); break;
		case "H": eGui.lightUpLabel(14,clr); break;
		case "J": eGui.lightUpLabel(15,clr); break;
		case "K": eGui.lightUpLabel(16,clr); break;
		case "P": eGui.lightUpLabel(17,clr); break;
		case "Y": eGui.lightUpLabel(18,clr); break;
		case "X": eGui.lightUpLabel(19,clr); break;
		case "C": eGui.lightUpLabel(20,clr); break;
		case "V": eGui.lightUpLabel(21,clr); break;
		case "B": eGui.lightUpLabel(22,clr); break;
		case "N": eGui.lightUpLabel(23,clr); break;
		case "M": eGui.lightUpLabel(24,clr); break;
		case "L": eGui.lightUpLabel(25,clr); break;
		}
		System.out.print(letter + " ");
	}
}
