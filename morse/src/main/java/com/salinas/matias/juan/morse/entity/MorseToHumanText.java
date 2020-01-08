package com.salinas.matias.juan.morse.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author Juan M. Salinas
 *
 */
public class MorseToHumanText {
	
	@ApiModelProperty(value = "The text to translate", example = ".... --- .-.. .-     -- . .-.. ..")
	private String originalText;
	
	@ApiModelProperty(value = "The text translated", example = "HOLA MELI")
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
