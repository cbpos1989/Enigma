package com.cbpos1989.github.enigma;


import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;

/**
 * Class that implements the GUI components of the Plugboard.
 * 
 * @author Colm O'Sullivan
 * @version 1.0  
 * @dependencies None
 */

public class PlugBoardMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4609782909317340049L;
	private char firstRow[] = {'Q','W','E','R','T','Z','U','I','O'};
	private char secondRow[] = {'A','S','D','F','G','H','J','K'};
	private char thirdRow[] = {'P','Y','X','C','V','B','N','M','L'};
	private PlugBoardHandler pbh;
	private JPanel topPlugPanel;
	
	/**
	 * Create the frame.
	 */
	public PlugBoardMenu() {
		this.pbh = new PlugBoardHandler(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 300);
		GridLayout mainLayout = new GridLayout(2,1,10,10);
		getContentPane().setLayout(mainLayout);
		initialiseGui();
	}
	
	void initialiseGui(){
		//Top Plugboard Panel
		topPlugPanel = new JPanel();
		topPlugPanel.setLayout(new GridLayout(4,1,10,10));
		topPlugPanel.setBackground(Color.DARK_GRAY);
		getContentPane().add(topPlugPanel);
		
		JLabel plugboardLabel = new JLabel("Enigma Plugboard");
		plugboardLabel.setForeground(Color.LIGHT_GRAY);
		plugboardLabel.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 16));
		plugboardLabel.setHorizontalAlignment(SwingConstants.CENTER);
		topPlugPanel.add(plugboardLabel);
		
		//Top Plugboard Panel
		JPanel bottomPlugPanel = new JPanel();
		bottomPlugPanel.setLayout(new GridLayout(4,1,10,10));
		bottomPlugPanel.setBackground(Color.DARK_GRAY);
		getContentPane().add(bottomPlugPanel);
				
		createPlugs(firstRow, topPlugPanel);
		createPlugs(secondRow, topPlugPanel);
		createPlugs(thirdRow, topPlugPanel);
		
		createPlugs(firstRow, bottomPlugPanel);
		createPlugs(secondRow, bottomPlugPanel);
		createPlugs(thirdRow, bottomPlugPanel);
		
		JButton linkButton = new JButton("Link Letters");
		linkButton.setMargin(new Insets(2, 2, 2, 2));
		linkButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		linkButton.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 14));
		bottomPlugPanel.add(linkButton);
		
		setVisible(true);
	}

	
	
	void createPlugs(char[] chars, JPanel panel){
		JToggleButton[] plugRow = new JToggleButton[chars.length];
		JPanel p = new JPanel(new GridLayout(1,chars.length,5,5));
		p.setBackground(Color.DARK_GRAY);
		
		for (int i = 0; i < chars.length; ++i) {
			plugRow[i] = new JToggleButton(chars[i] + "");
			plugRow[i].setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 16));
			plugRow[i].setForeground(Color.BLACK);
			plugRow[i].setAlignmentY(CENTER_ALIGNMENT);
			p.add(plugRow[i]);
			
		}
		
		addPlugListeners(plugRow);
		panel.add(p);
	}
	
	void addPlugListeners(JToggleButton[] buttons){
		for (JToggleButton b: buttons) {
			b.addActionListener(pbh);
		}
	}
}
