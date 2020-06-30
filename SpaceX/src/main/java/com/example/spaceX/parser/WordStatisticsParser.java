package com.example.spaceX.parser;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import com.example.spaceX.exceptions.WrongJsonFormatException;
import com.example.spaceX.exceptions.WrongURIException;
import com.example.spaceX.model.WordStatistics;

public class WordStatisticsParser extends SpaceXParser {
	
	private JSONObject initialTweet;
	private List<WordStatistics> wordStatistics;
	
	public WordStatisticsParser(String uri) throws WrongURIException {
		initialTweet=initialize(uri);
	}
	
	@Override
	public List<Object> parse() throws WrongJsonFormatException {
		wordStatistics = new ArrayList<WordStatistics>();
		
		Map<String, Integer> dictionary = new HashMap<String, Integer>();
		
		JSONArray arr;
		try {
			arr = initialTweet.getJSONArray("statuses");
		} catch (JSONException e) {
			throw new WrongJsonFormatException("JSON format for this tweet is incorrect");
		}
		for (int i = 0; i < arr.length(); i++)
		{
		    String text;
			try {
				text = arr.getJSONObject(i).getString("text");
			} catch (JSONException e) {
				throw new WrongJsonFormatException("JSON format for the tweet text is incorrect");
			}
		    for (String string : text.split(" ")) {
		    	if(dictionary.containsKey(string)) {
					dictionary.put(string, dictionary.get(string)+1);
				} else {
					dictionary.put(string, 1);
				}
			}
		}
		for (String word: dictionary.keySet()) {
			WordStatistics stat= new WordStatistics(word, dictionary.get(word));
			wordStatistics.add(stat);
		}
		
		wordStatistics.sort(Comparator.comparing(WordStatistics::getAppearances).reversed());
			
		return (List<Object>)(Object)wordStatistics;
	}
		
	
}
