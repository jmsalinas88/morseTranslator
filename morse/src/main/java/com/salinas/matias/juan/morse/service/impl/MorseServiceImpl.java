package com.salinas.matias.juan.morse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.salinas.matias.juan.morse.entity.Decoder;
import com.salinas.matias.juan.morse.entity.Encoder;
import com.salinas.matias.juan.morse.service.contract.MorseService;

/**
 * 
 * @author Juan M. Salinas
 *
 */
@Service
public class MorseServiceImpl implements MorseService{

	@Autowired	
	private Encoder encoder;
	@Autowired
	private Decoder decoder;
	
	@Override
	public String morseToWord(String morseMessage) {
		return this.decoder.morseToWord(morseMessage);
	}

	@Override
	public String wordToMorse(String message) {
		return this.encoder.wordToMorse(message);
	}

	@Override
	public String bitsToMorse(String bitSecuence) {
		return this.encoder.bitsToMorse(bitSecuence);
	}

}
