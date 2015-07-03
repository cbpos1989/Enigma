/**
 * 
 */
package com.cbpos1989.github.enigma;

/**
 * @author Colm O'Sullivan
 *
 */
public class Rotor {
	private char[] letterArray = {'E','K','M','F','L','G','D','Q','V','Z','N','T','O','W','Y','H','X','U','S','P','A','I','B','R','C','J'};

	public char codeLetter(char c){
		switch(c){
			case 'A': c = letterArray[0];
			case 'B': c = letterArray[1];
			case 'C': c = letterArray[2];
			case 'D': c = letterArray[3];
			case 'E': c = letterArray[4];
			case 'F': c = letterArray[5];
			case 'G': c = letterArray[6];
			case 'H': c = letterArray[7];
			case 'I': c = letterArray[8];
			case 'J': c = letterArray[9];
			case 'K': c = letterArray[10];
			case 'L': c = letterArray[11];
			case 'M': c = letterArray[12];
			case 'N': c = letterArray[13];
			case 'O': c = letterArray[14];
			case 'P': c = letterArray[15];
			case 'Q': c = letterArray[16];
			case 'R': c = letterArray[17];
			case 'S': c = letterArray[18];
			case 'T': c = letterArray[19];
			case 'U': c = letterArray[20];
			case 'V': c = letterArray[21];
			case 'W': c = letterArray[22];
			case 'X': c = letterArray[23];
			case 'Y': c = letterArray[24];
			case 'Z': c = letterArray[25];
		}
		
		shiftLetterArray();
		return c;
		
		
	}
	
	void shiftLetterArray(){
		char firstLetter = letterArray[0];
		
		for(int i = (letterArray.length -1);i >= 1; --i){
			letterArray[i-1] = letterArray[i];
		}
		
		letterArray[letterArray.length-1] = firstLetter;
	}

}


