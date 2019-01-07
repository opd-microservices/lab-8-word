package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@ConfigurationProperties(prefix="wordConfig")
public class WordController {

	@Value("${words}") String words;
//    String words = "icicle,refrigerator,blizzard,snowball";
//	String words;
	
	@GetMapping("/")
	public @ResponseBody Word getWord() {
		System.out.println("=======================> received GET Call .........................");
		String[] wordArray = words.split(",");
		int i = (int)Math.round(Math.random() * (wordArray.length - 1));
		return new Word(wordArray[i]);
	}

	public String getWords() {
		System.out.println("getWords()================> words are ===========>" + words);
		return words;
	}

	public void setWords(String words) {
		this.words = words;
		System.out.println("setWords()================> as ===========>" + words);
	}
	
	
}