package com.salinas.matias.juan.morse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.salinas.matias.juan.morse.entity.Encoder;

class EncoderTest {

	private Encoder encoder; 
	
	@BeforeEach
	void before() {
		this.encoder = new Encoder();
	}
	
	@Test
	void testWordToMorseLower() {
		String expected = ".... --- .-.. .-     -- . .-.. ..";
		String actual = this.encoder.wordToMorse("hola meli");
		assertEquals(expected, actual);
	}
	
	@Test
	void testWordToMorseUpper() {
		String expected = ".... --- .-.. .-     -- . .-.. ..";
		String actual = this.encoder.wordToMorse("HOLA MELI");
		assertEquals(expected, actual);
	}
	
	@Test
	void bitsToMorse() {
		String expected = ".... . .-.. .-.. ---     .-- --- .-. .-.. -..";
		String actual = this.encoder.bitsToMorse("1010101 000 1 000 101110101 000 101110101 000 11101110111 0000000 101110111 000 11101110111 000 1011101 000 101110101 000 1110101");
		assertEquals(expected, actual);
	}
	
	@Test
	void bitsToMorseM() {
		// Hola Meli "I", ".."
		// 1010101 000 11101110111 000 101110101 000 10111 0000000 1110111 000 1 000 101110101 000 101
		String expected = ".... --- .-.. .-     -- . .-.. ..";
		String actual = this.encoder.bitsToMorse("1010101 000 11101110111 000 101110101 000 10111 0000000 1110111 000 1 000 101110101 000 101");
		assertEquals(expected, actual);
	}
	
	

}
