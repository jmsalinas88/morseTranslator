package com.salinas.matias.juan.morse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import com.salinas.matias.juan.morse.entity.Decoder;

class DecoderTest {

	private Decoder decoder;
	private String expected; 
	private String input;
	
	
	@Test
	void morseToWord() {
		this.decoder = new Decoder();
		this.input = ".... --- .-.. .-     -- . .-.. ..";
		this.expected = "HOLA MELI";
		String actual = this.decoder.morseToWord(this.input);
		assertEquals(this.expected, actual);
		
	}

}
