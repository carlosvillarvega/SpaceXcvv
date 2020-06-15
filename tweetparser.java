package com.example.spaceX.parser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import com.example.spaceX.model.ImageStatistics;
import com.example.spaceX.model.Tweet;
import com.example.spaceX.model.WordStatistics;

public class TweetParser {
	
	public TweetParser() {}

	public List<Tweet> parseTweet(JSONObject tweet) throws JSONException {
		List<Tweet> tweets = new ArrayList<Tweet>();
		JSONArray arr = tweet.getJSONArray("statuses");
		for (int i = 0; i < arr.length(); i++)
		{
		    String creationDate = arr.getJSONObject(i).getString("created_at");
		    int id = arr.getJSONObject(i).getInt("id");
		    String text = arr.getJSONObject(i).getString("text");
		    Tweet newTweet = new Tweet(creationDate, id, text);
		    tweets.add(newTweet);
		}
		return tweets;
	}
	
	public ImageStatistics parseTweetsWithImages(JSONObject tweet) throws JSONException {
		ImageStatistics statistics;
		int total=0;
		int withImages=0;
		JSONArray arr = tweet.getJSONArray("statuses");
		for (int i = 0; i < arr.length(); i++)
		{
			total+=1;
			if(arr.getJSONObject(i).optJSONObject("extended_entities")!=null) {
				withImages+=1;
			}
		}
		statistics=new ImageStatistics("spaceX", total, withImages);
		return statistics;
	}
	
	public List<WordStatistics> parseTweetCommonWords(JSONObject tweet) throws JSONException {
		
		List<WordStatistics> wordStatistics = new ArrayList<WordStatistics>();
		
		Map<String, Integer> dictionary = new HashMap<String, Integer>();
		
		JSONArray arr = tweet.getJSONArray("statuses");
		for (int i = 0; i < arr.length(); i++)
		{
		    String text = arr.getJSONObject(i).getString("text");
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
		
		return wordStatistics;
	}
}
