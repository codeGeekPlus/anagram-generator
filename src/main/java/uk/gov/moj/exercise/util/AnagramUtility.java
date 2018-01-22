package uk.gov.moj.exercise.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AnagramUtility {

	static String canonicalize(String s) {
		return Stream.of(s.split(",")).sorted().collect(Collectors.joining());
	}

	static ArrayList<String> getWords(String word) {
		ArrayList<String> words = new ArrayList(Arrays.asList(word.split("\\s*,\\s*")));
		return words;
	}

}
