package com.salinas.matias.juan.morse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.salinas.matias.juan.morse.entity.BitsToMorseText;
import com.salinas.matias.juan.morse.entity.HumanToMorseText;
import com.salinas.matias.juan.morse.entity.MorseToHumanText;
import com.salinas.matias.juan.morse.service.contract.MorseService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/translate")
public class MorseTranslateController {

	@Autowired
	private MorseService morseService;
	
	@ApiOperation(value = "Transalates Morse To Human", response = MorseToHumanText.class, tags = "/2text")
	@RequestMapping(method = RequestMethod.POST, path = "/2text",consumes = "application/json",produces = "application/json")
	public ResponseEntity<MorseToHumanText> morseToText(@RequestBody MorseToHumanText text) {
		text.setTextTranslated(this.morseService.morseToWord(text.getOriginalText()));
		return new ResponseEntity<MorseToHumanText>(text,HttpStatus.OK);
	}

	@ApiOperation(value = "Translates Human To Morse", response = HumanToMorseText.class, tags = "/2morse")
	@RequestMapping(method = RequestMethod.POST, path = "/2morse",consumes = "application/json",produces = "application/json")
	public ResponseEntity<HumanToMorseText> textToMorse(@RequestBody HumanToMorseText text) {
		text.setTextTranslated(this.morseService.wordToMorse(text.getOriginalText()));
		return new ResponseEntity<HumanToMorseText>(text,HttpStatus.OK);
	}

	@ApiOperation(value = "Transalates secuence of bits to Morse", response = BitsToMorseText.class, tags = "/bits2morse")
	@RequestMapping(method = RequestMethod.POST, path = "/bits2morse",consumes = "application/json",produces = "application/json")
	public ResponseEntity<BitsToMorseText> bitsToMorse(@RequestBody BitsToMorseText text) {
		text.setTextTranslated(this.morseService.bitsToMorse(text.getOriginalText()));
		return new ResponseEntity<BitsToMorseText>(text,HttpStatus.OK);
	}
	
}
