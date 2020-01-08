package com.salinas.matias.juan.morse.entity;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.stereotype.Component;
import com.salinas.matias.juan.morse.Constants;

/**
 * 
 * @author Juan M. Salinas
 *
 */

@Component
public class Decoder extends Morse{
	
	public Decoder() {
		 super(Constants.MORSE_TO_HUMAN_DICTIONARY);
	}
	
	/**
	 * Este metodo se encarga de traducir Morse a Humano.
	 * @param Mensaje Morse
	 * @return Mensaje Humano
	 */
	public String morseToWord(String morseMessage){
		
		StringBuilder out = new StringBuilder();
		List<String> morseWordSecuenceList = Stream.of(morseMessage.split(String.join("", Collections.nCopies(Constants.SPACES_BETWEEN_MORSE_WORDS, Constants.WHITE_SPACE))))
											    	.map(element -> new String(element))
											    	.collect(Collectors.toList());
		
		for (int i = 0; i < morseWordSecuenceList.size(); i++) {
			String word = morseWordSecuenceList.get(i);
			List<String> morseSecuenceList = Stream.of(word.split(Constants.WHITE_SPACE))
												   .map(element -> new String(element))
												   .collect(Collectors.toList());

			morseSecuenceList.forEach(element -> {
				out.append(this.dictionary.get(element));
			});
			
			if(i != (morseWordSecuenceList.size()-1)) {
				out.append(String.join("", Collections.nCopies(Constants.SPACES_BETWEEN_HUMAN_WORDS, Constants.WHITE_SPACE)));
			}
		}
		return out.toString();
	}
	
}
