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
		
		shiftLetterArray();
		return c;
		
		
	}
	
	void shiftLetterArray(){
		char firstLetter = letterArray[0];
		
		
		for(int i = 1 ;i < letterArray.length; ++i){
			 letterArray[i - 1] = letterArray[i];
		}
		
		letterArray[letterArray.length-1] = firstLetter;
	}

}


