package com.salinas.matias.juan.morse.service.contract;

/***
 * 
 * @author Juan M. Salinas
 *
 */
public interface MorseService {
	
	public String morseToWord(String morseMessage);
	
	public String wordToMorse(String message);
	
	public String bitsToMorse(String bitSecuence);

}
