package uk.gov.moj.exercise.service;

import java.util.ArrayList;
import java.util.HashMap;

public interface AnagramService {

	HashMap<String, ArrayList<String>> generateAnagrams(String word);
}