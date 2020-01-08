package com.salinas.matias.juan.morse.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author Juan M. Salinas
 *
 */
public class HumanToMorseText {
	
		@ApiModelProperty(value = "The text to translate", example = "HOLA MELI")
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
