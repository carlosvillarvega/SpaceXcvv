package com.example.spaceX.parser;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import com.example.spaceX.exceptions.WrongJsonFormatException;
import com.example.spaceX.exceptions.WrongURIException;
import com.example.spaceX.model.Tweet;

public class TweetParser extends SpaceXParser{
	
	private JSONObject initialTweet;
	private List<Object> parsedTweets;
	
	public TweetParser(String uri) throws WrongURIException {
		initialTweet=initialize(uri);
	}

	@Override
	public List<Object> parse() throws WrongJsonFormatException {
		parsedTweets = new ArrayList<Object>();
		JSONArray arr = null;
		try {
			arr = initialTweet.getJSONArray("statuses");
		} catch (JSONException e) {
			throw new WrongJsonFormatException("JSON format for this tweet is incorrect");
		}
		for (int i = 0; i < arr.length(); i++)
		{
			try {
				String creationDate = arr.getJSONObject(i).getString("created_at");
			    int id = arr.getJSONObject(i).getInt("id");
			    String text = arr.getJSONObject(i).getString("text");
			    String metadata = arr.getJSONObject(i).optJSONObject("metadata").getString("iso_language_code");
			    Tweet newTweet = new Tweet(creationDate, id, text, metadata);
			    parsedTweets.add(newTweet);
			} catch (JSONException e) {
				throw new WrongJsonFormatException("JSON format for these attributes is incorrect");
			}
		    
		}
		return parsedTweets;
	}
}
