/**
 * 
 */
package com.cbpos1989.github.enigma;

/**
 * @author Colm O'Sullivan
 *
 */
public class Rotor {
	private char[] letterArray = new char[26];
	private int rotorPosition = 0;
	private int rotorNotch = 0;
	private int rotorNotchCounter = 0;

	public Rotor(int rotorPosition, int rotorNumber){
		this.rotorPosition = rotorPosition;
		
		switch(rotorNumber){
		case 1: char[] rotorArrayI = {'E','K','M','F','L','G','D','Q','V','Z','N','T','O','W','Y','H','X','U','S','P','A','I','B','R','C','J'};
				populateArray(rotorArrayI);
				setRotorNotch(7); break;
		case 2:	char[] rotorArrayII = {'A','J','D','K','S','I','R','U','X','B','L','H','W','T','M','C','Q','G','Z','N','P','Y','F','V','O','E'};
				populateArray(rotorArrayII);
				setRotorNotch(25); break;
		case 3:	char[] rotorArrayIII = {'B','D','F','H','J','L','C','P','R','T','X','V','Z','N','Y','E','I','W','G','A','K','M','U','S','Q','O'};
				populateArray(rotorArrayIII);
				setRotorNotch(11); break;
		case 4: char[] rotorArrayIV = {'E','S','O','V','P','Z','J','A','Y','Q','U','I','R','H','X','L','N','F','T','G','K','D','C','M','W','B'};
				populateArray(rotorArrayIV);
				setRotorNotch(6); break;
		case 5: char[] rotorArrayV = {'V','Z','B','R','G','I','T','Y','U','P','S','D','N','H','L','X','A','W','M','J','Q','O','F','E','C','K'};
				populateArray(rotorArrayV);
				setRotorNotch(1); break;
		}
	}
	
	public int getRotorNotch() {
		return this.rotorNotch;
	}
	
	public void setRotorNotch(int rtrNotch){
		this.rotorNotch = rtrNotch;
	}

	public int getRotorPosition() {
		return this.rotorPosition;
	}
	
	public int getRotorNotchCounter(){
		return this.rotorNotchCounter;
	}

	void populateArray(char[] charArray){
		for (int i = 0; i < charArray.length; ++i) {
			letterArray[i] = charArray[i];
		}
	}
	
	public char codeLetter(char c){
		switch(c){
			case 'A': c = letterArray[0]; break;
			case 'B': c = letterArray[1]; break;
			case 'C': c = letterArray[2]; break;
			case 'D': c = letterArray[3]; break;
			case 'E': c = letterArray[4]; break;
			case 'F': c = letterArray[5]; break;
			case 'G': c = letterArray[6]; break;
			case 'H': c = letterArray[7]; break;
			case 'I': c = letterArray[8]; break;
			case 'J': c = letterArray[9]; break;
			case 'K': c = letterArray[10]; break;
			case 'L': c = letterArray[11]; break;
			case 'M': c = letterArray[12]; break;
			case 'N': c = letterArray[13]; break;
			case 'O': c = letterArray[14]; break;
			case 'P': c = letterArray[15]; break;
			case 'Q': c = letterArray[16]; break;
			case 'R': c = letterArray[17]; break;
			case 'S': c = letterArray[18]; break;
			case 'T': c = letterArray[19]; break;
			case 'U': c = letterArray[20]; break;
			case 'V': c = letterArray[21]; break;
			case 'W': c = letterArray[22]; break;
			case 'X': c = letterArray[23]; break;
			case 'Y': c = letterArray[24]; break;
			case 'Z': c = letterArray[25]; break;
		}
		
		return c;
	}
	
	void shiftLetterArray(){
		char firstLetter = letterArray[0];
		
		for (int i = 1 ;i < letterArray.length; ++i) {
			 letterArray[i - 1] = letterArray[i];
		}
		
		letterArray[letterArray.length-1] = firstLetter;
		this.rotorNotchCounter++;
	}
}


