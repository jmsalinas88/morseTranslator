package com.salinas.matias.juan.morse;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.salinas.matias.juan.morse.entity.Encoder;

@SpringBootTest
class MorseApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	void wordToMorse() {
		Encoder encoder = new Encoder();
		System.out.println(encoder.wordToMorse("hola                        "));
	}
	
	@Test
	void bitsToMorse() {
		Encoder encoder = new Encoder();
		System.out.println(encoder.bitsToMorse("1010101 000 1 000 101110101 000 101110101 000 11101110111 0000000 101110111 000 11101110111 000 1011101 000 10111010 1000 1110101"));
	}

}
