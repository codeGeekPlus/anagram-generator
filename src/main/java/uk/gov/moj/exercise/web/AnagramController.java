package uk.gov.moj.exercise.web;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import uk.gov.moj.exercise.service.AnagramServiceImpl;

@RestController
public class AnagramController {

	@Autowired
	AnagramServiceImpl service;

	@RequestMapping(value = "/{word}", method = RequestMethod.GET)
	public HashMap<String, ArrayList<String>> getAnagramsForPathVariable(@PathVariable("word") String word) {
		return service.generateAnagrams(word);
	}

}
