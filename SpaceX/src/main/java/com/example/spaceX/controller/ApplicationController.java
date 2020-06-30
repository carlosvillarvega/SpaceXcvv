package com.example.spaceX.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.spaceX.exceptions.WrongJsonFormatException;
import com.example.spaceX.exceptions.WrongURIException;
import com.example.spaceX.parser.ImageStatisticsParser;
import com.example.spaceX.parser.TweetParser;
import com.example.spaceX.parser.WordStatisticsParser;

@Controller
public class ApplicationController{
	
	private final static String TWITTER__BASE_URL="https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/api/1.1/search/tweets.json?q=";
	private final static String SPACE_X="spaceX&count=90";
	
	
	@RequestMapping("/spaceXTweets")
	@ResponseBody
	public List<Object> getSpaceXTweets() throws WrongJsonFormatException, WrongURIException{
		
		return new TweetParser(TWITTER__BASE_URL+SPACE_X).parse();
	}
	
	
	@RequestMapping("/spaceXTweets/stats/images")
	@ResponseBody
	public List<Object> getSpaceXTweetsWithImages() throws WrongJsonFormatException, WrongURIException{

		return new ImageStatisticsParser(TWITTER__BASE_URL+SPACE_X).parse();
	}
	
	@RequestMapping("/spaceXTweets/stats/commonWords")
	@ResponseBody
	public List<Object> getSpaceXTweetsCommonWords() throws WrongJsonFormatException, WrongURIException{
	
		return new WordStatisticsParser(TWITTER__BASE_URL+SPACE_X).parse();
	}
}
