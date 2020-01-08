package com.salinas.matias.juan.morse.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author Juan M. Salinas
 *
 */
public class BitsToMorseText {
	
	@ApiModelProperty(value = "The secuence of bits to translate", example = "1010101 000 11101110111 000 101110101 000 10111 0000000 1110111 000 1 000 101110101 000 101")
	private String originalText;
	
	@ApiModelProperty(value = "The text translated", example = ".... --- .-.. .-     -- . .-.. ..")
	private String textTranslated;
	
	public String getOriginalText() {
		return originalText;
	}
	public void setOriginalText(String originalText) {
		this.originalText = originalText;
	}
	public String getTextTranslated() {
		return textTranslated;
	}
	public void setTextTranslated(String textTranslated) {
		this.textTranslated = textTranslated;
	}

}
