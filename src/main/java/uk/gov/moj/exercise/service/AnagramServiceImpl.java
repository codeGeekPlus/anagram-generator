package uk.gov.moj.exercise.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public class AnagramServiceImpl implements AnagramService {

	private HashMap<String, ArrayList<String>> anagrams = null;
	ArrayList<String> anagramList = null;

	@Override
	public HashMap<String, ArrayList<String>> generateAnagrams(String word) {

		ArrayList<String> inputList = new ArrayList<String>(Arrays.asList(word.split("\\s*,\\s*")));
		anagrams = new HashMap<>();
		for (String word1 : inputList) {
			anagramList = new ArrayList<String>();
			anagrams.put(word1, display("", word1));
		}
		return anagrams;
	}

	private ArrayList<String> display(String s1, String s2) {

		if (s2.length() <= 1) {
			anagramList.add(s1 + s2);
		} else {
			for (int i = 0; i < s2.length(); i++) {
				String x = s2.substring(i, i + 1);
				String y = s2.substring(0, i);
				String z = s2.substring(i + 1);
				display(s1 + x, y + z);
			}
		}
		return anagramList;
	}

}
