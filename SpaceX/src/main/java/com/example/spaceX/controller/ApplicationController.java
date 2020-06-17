package com.example.spaceX.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.example.spaceX.model.ImageStatistics;
import com.example.spaceX.model.Tweet;
import com.example.spaceX.model.WordStatistics;
import com.example.spaceX.parser.TweetParser;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

@Controller
public class ApplicationController {
	
	private final static String TWITTER__BASE_URL="https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/api/1.1/search/tweets.json?q=";
	private final static String SPACE_X="spaceX&count=90";
	
	public Gson gson = new Gson();
	
	public TweetParser parser= new TweetParser();
	
	
	@RequestMapping("/spaceXTweets")
	@ResponseBody
	public List<Tweet> getSpaceXTweets() throws JSONException, URISyntaxException {
		
		URI uri= new URI(TWITTER__BASE_URL+SPACE_X);
		RestTemplate restTemplate = new RestTemplate();
		Map tweets= restTemplate.getForEntity(uri, Map.class).getBody();
		
		JSONObject tweetsAsJSON = new JSONObject(tweets);
		return parser.parseTweet(tweetsAsJSON);
	}
	
	
	@RequestMapping("/spaceXTweets/stats/images")
	@ResponseBody
	public ImageStatistics getSpaceXTweetsWithImages() throws URISyntaxException, JSONException {
		
		URI uri= new URI(TWITTER__BASE_URL+SPACE_X);
		RestTemplate restTemplate = new RestTemplate();
		Map tweets= restTemplate.getForEntity(uri, Map.class).getBody();
		
		JSONObject tweetsAsJSON = new JSONObject(tweets);
		
		return parser.parseTweetsWithImages(tweetsAsJSON);
	}
	
	@RequestMapping("/spaceXTweets/stats/commonWords")
	@ResponseBody
	public List<WordStatistics> getSpaceXTweetsCommonWords() throws URISyntaxException, JSONException {
	
		URI uri= new URI(TWITTER__BASE_URL+SPACE_X);
		RestTemplate restTemplate = new RestTemplate();
		Map tweets= restTemplate.getForEntity(uri, Map.class).getBody();
		
		JSONObject tweetsAsJSON = new JSONObject(tweets);
		
		return parser.parseTweetCommonWords(tweetsAsJSON);
	}
}
