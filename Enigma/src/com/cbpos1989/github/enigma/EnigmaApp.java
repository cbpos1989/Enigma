/**
 * 
 */
package com.cbpos1989.github.enigma;

import javax.swing.JOptionPane;

/**
 * @author cbpos1989
 *
 */
public class EnigmaApp {
	
	
	public static void main(String[] args){
		System.out.println("Working");
		EnigmaApp eApp = new EnigmaApp();
		eApp.initialiseMenu();
	}
	
	void initialiseMenu(){
		final EnigmaGUI eGui = new EnigmaGUI();
		eGui.setVisible(true);
		
		eGui.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		        if (JOptionPane.showConfirmDialog(eGui, 
		            "Are you sure you want to quit app?", "Quiting Enigma App", 
		            JOptionPane.YES_NO_OPTION,
		            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
		            System.exit(0);
		        }
		    }
		});
	}
}
