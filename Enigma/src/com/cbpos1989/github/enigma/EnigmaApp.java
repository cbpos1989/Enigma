/**
 * 
 */
package com.cbpos1989.github.enigma;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JOptionPane;

/**
 * @author cbpos1989
 *
 */
public class EnigmaApp {
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int screenHeight = (int)screenSize.getHeight();
	private int screenWidth = (int)screenSize.getWidth();
	
	public static void main(String[] args){
		System.out.println("Working");
		EnigmaApp eApp = new EnigmaApp();
		eApp.initialiseMenu();
	}
	
	void initialiseMenu(){
		final EnigmaGUI eGui = new EnigmaGUI();
		eGui.setBounds((screenWidth/2)-550, (screenHeight/2)-275, 550, 550);
		
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
