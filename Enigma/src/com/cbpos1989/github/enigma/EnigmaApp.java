/**
 * 
 */
package com.cbpos1989.github.enigma;

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
		EnigmaGUI eGui = new EnigmaGUI();
		eGui.setVisible(true);
	}
}
