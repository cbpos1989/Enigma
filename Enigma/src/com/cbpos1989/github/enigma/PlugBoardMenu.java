package com.cbpos1989.github.enigma;


import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Class that implements the GUI components of the Plugboard.
 * 
 * @author Colm O'Sullivan
 * @version 1.0  
 * @dependencies None
 */

public class PlugBoardMenu extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4609782909317340049L;
	private char firstRow[] = {'Q','W','E','R','T','Z','U','I','O'};
	private char secondRow[] = {'A','S','D','F','G','H','J','K'};
	private char thirdRow[] = {'P','Y','X','C','V','B','N','M','L'};
	private JToggleButton[] toggleButtonsDefault = new JToggleButton[26];
	private Color defaultColour;
	private int indexRow = 0;
	private PlugBoardHandler pbh;
	
	/**
	 * Create the frame.
	 */
	public PlugBoardMenu() {
		this.pbh = new PlugBoardHandler(this);
		//this.setModalityType(ModalityType.TOOLKIT_MODAL);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 700, 300);
		GridLayout mainLayout = new GridLayout(1,1,10,10);
		getContentPane().setLayout(mainLayout);
		initialiseGui();
	}
	
	void initialiseGui(){
		//Plugboard Panel
		JPanel plugPanel = new JPanel();
		plugPanel.setLayout(new GridLayout(5,1,10,10));
		plugPanel.setBackground(Color.DARK_GRAY);
		getContentPane().add(plugPanel);
		
		JLabel plugboardLabel = new JLabel("Enigma Plugboard");
		plugboardLabel.setForeground(Color.LIGHT_GRAY);
		plugboardLabel.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 16));
		plugboardLabel.setHorizontalAlignment(SwingConstants.CENTER);
		plugPanel.add(plugboardLabel);
		
		createPlugs(firstRow, plugPanel);
		createPlugs(secondRow, plugPanel);
		createPlugs(thirdRow, plugPanel);
		
		JButton linkButton = new JButton("Link Letters");
		linkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				char[] selectedButtons = pbh.getSelectedButtons();
				
				if(selectedButtons[0] != 0 && selectedButtons[1] != 0){
					pbh.addLetterToArray();
					pbh.addButtonToArray();
					pbh.printArray();
				} else {
					Component plugBoardMessage = null;
					JOptionPane.showMessageDialog(plugBoardMessage,
						    "Select plugs before trying to link them",
						    "PlugBoard Warning",
						    JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		linkButton.setMargin(new Insets(2, 2, 2, 2));
		linkButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		linkButton.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 14));
		plugPanel.add(linkButton);
		
		
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
			addPlugsToArray(plugRow[i]);
			p.add(plugRow[i]);
		}
		
		addPlugListeners(plugRow);
		panel.add(p);
	}
	
	void addPlugsToArray(JToggleButton tBtn){
		toggleButtonsDefault[indexRow] = tBtn;
		defaultColour = tBtn.getBackground();
		indexRow++;
	}
	
	void addPlugListeners(JToggleButton[] buttons){
		for (JToggleButton b: buttons) {
			b.addActionListener(pbh);
		}
	}

	void lightUpBoard(JToggleButton[][] toggleButtons){
		
		for(JToggleButton tBtn: toggleButtonsDefault){
			tBtn.setBackground(defaultColour);
		}
		
		
		for(int i = 0, j = 0; i < toggleButtons.length; ++i){
			if(toggleButtons[i][j] != null){
				lightUpPlugs(toggleButtons[i][j],toggleButtons[i][++j],pbh.colourPicker(i + 1));
				j = 0;
			}
		}
	}
	
	void lightUpPlugs(JToggleButton tBtnOne,JToggleButton tBtnTwo, Color colour){
		tBtnOne.setBackground(colour);
		tBtnTwo.setBackground(colour);
		
	}
	
	void turnOffPlugLight(JToggleButton tBtn, Color colour){
		tBtn.setBackground(colour);
	}
}
