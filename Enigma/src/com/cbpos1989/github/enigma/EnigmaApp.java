/**
 * 
 */
package com.cbpos1989.github.enigma;


import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JOptionPane;

/**
 * Class that initialises the Enigma App.
 * 
 * @author cbpos1989
 * @version 1.0  
 * @dependencies None
 */
public class EnigmaApp {
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int screenHeight = (int)screenSize.getHeight();
	private int screenWidth = (int)screenSize.getWidth();
	private PlugBoardHandler pbh;
	private PlugBoardMenu pbm;
	
	public static void main(String[] args){
		System.out.println("<<<Starting Program>>>");
		EnigmaApp eApp = new EnigmaApp();
		eApp.initialiseMenu();
	}
	
	void initialiseMenu(){
		pbm = new PlugBoardMenu();
		pbm.setVisible(false);
		pbh = new PlugBoardHandler(pbm);
		final EnigmaGUI eGui = new EnigmaGUI(pbh,pbm);
		
		eGui.setBounds((screenWidth/2)-275, (screenHeight/2)-300, 550, 600);
		eGui.setVisible(true);
		
		
		eGui.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		        if (JOptionPane.showConfirmDialog(eGui, 
		            "Are you sure you want to quit app?", "Quiting Enigma App", 
		            JOptionPane.YES_NO_OPTION,
		            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
		        	endProgram();
		        }
		    }
		});
	}
	
	void endProgram(){
		System.out.println("!!!Exiting Program!!!");
		return;
	}
	
}
