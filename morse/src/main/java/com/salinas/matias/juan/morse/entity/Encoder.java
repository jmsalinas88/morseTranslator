package com.salinas.matias.juan.morse.entity;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
public class Encoder extends Morse{
	
	private static final String BIT_PULSE_SEPARATOR = "0";
	private static final String BIT_DOT = "1";
	private static final String BITS_DASH = "111";
	private static final String BITS_LETTER_SEPARATOR = "000";
	private static final String BITS_WORDS_SEPARATOR = "0000000";
	private static final String BITS_LETTER_WORD_PATTERN = "(000)|(0000000)";
	
	public Encoder(){
	    super(Constants.HUMAN_TO_MORSE_DICTIONARY);
	}

	/**
	 * Este metodo se encarga de traducir Humano a Morse.
	 * 
	 * @param message Mensaje Humano
	 * @return String Mensaje Morse
	 */
	public String wordToMorse(String message) {
		StringBuilder out = new StringBuilder();		
		
		List<String> wordSecuenceList = Stream.of(message.split(Constants.WHITE_SPACE))
									    .map(element -> new String(element))
									    .collect(Collectors.toList());
		
		for (int i = 0; i < wordSecuenceList.size(); i++) {
			
			String word = wordSecuenceList.get(i);
			List<String> characterList = word.chars().mapToObj(c -> String.valueOf((char)c)).collect(Collectors.toList());
			
			for (int j = 0; j < characterList.size(); j++) {
				if(j == (characterList.size()-1)) {
					out.append(this.dictionary.get(characterList.get(j).toUpperCase()));
				}else {
					out.append(this.dictionary.get(characterList.get(j).toUpperCase())).append(Constants.WHITE_SPACE);
				}
			}
			
			if(i != (wordSecuenceList.size()-1)) {
				out.append(String.join("", Collections.nCopies(Constants.SPACES_BETWEEN_MORSE_WORDS, Constants.WHITE_SPACE)));
			}
			
		}
		
		return out.toString();
	}
	
	/**
	 * Este metodo traduce una secuencia de bits a Morse, siguiendo el siguiente protocolo:
		punto (.)  = '1'
		raya (-) = '111'
		separador punto(.) y raya(-): '0'
		separador de letras: '000'
		separador de palabras: '0000000'  
	 * 
	 * Basado en: https://en.wikipedia.org/wiki/Morse_code
		 * Transmision
		 * 1. short mark, dot or "dit" (.): 1
		   2. longer mark, dash or "dah" (-): 111
		   3. intra-character gap (between the dots and dashes within a character): 0
		   4. short gap (between letters): 000
		   5. medium gap (between words): 0000000
		   Ejemplo:	
			Texto 		  H           E     L             L             O           [space] W             O               R           L             D       
			Morse         ····        ·     ·−··          ·−··          −−−                 ·−−           −−−             ·−·         ·−··          −··     
			Bits          1010101 000 1 000 101110101 000 101110101 000 11101110111 0000000 101110111 000 11101110111 000 1011101 000 101110101 000 1110101
	 * @param bitSecuence Secuencia de bits
	 * @return Morse
	 */
	public String bitsToMorse(String bitSecuence) {
		
		StringBuilder out = new StringBuilder();
		
		Map<String, String> bitMorseMapp =  new HashMap<String, String>();
		bitMorseMapp.put(BITS_WORDS_SEPARATOR, String.join("", Collections.nCopies(Constants.SPACES_BETWEEN_MORSE_WORDS, Constants.WHITE_SPACE)));
		bitMorseMapp.put(BITS_LETTER_SEPARATOR, Constants.WHITE_SPACE);
		bitMorseMapp.put(BIT_DOT, Constants.DOT);
		bitMorseMapp.put(BITS_DASH, Constants.DASH);
		
		List<String> bitSecuenceList = Stream.of(bitSecuence.split(Constants.WHITE_SPACE))
											    .map(element -> new String(element))
											    .collect(Collectors.toList());
		
		bitSecuenceList.forEach(element -> {
						
			Pattern pattern  = Pattern.compile(BITS_LETTER_WORD_PATTERN);
		    Matcher matcher = pattern.matcher(element);

			if(matcher.matches()) {
				out.append(bitMorseMapp.get(element));
			}else {
				Pattern charsplit = Pattern.compile(BIT_PULSE_SEPARATOR);
				List<String> bitList = charsplit.splitAsStream(element).map(c ->  new String(c)).collect(Collectors.toList());
				bitList.forEach(bit -> {
					out.append(bitMorseMapp.get(bit));
				});

			}
		});
		
		return out.toString();
	}
}
