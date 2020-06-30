package com.example.spaceX.parser;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import com.example.spaceX.exceptions.WrongJsonFormatException;
import com.example.spaceX.exceptions.WrongURIException;
import com.example.spaceX.model.ImageStatistics;

public class ImageStatisticsParser extends SpaceXParser{

	private JSONObject initialTweet;
	private List<Object> statisticsList;
	
	
	public ImageStatisticsParser(String uri) throws WrongURIException{
		initialTweet=initialize(uri);
	}
	
	@Override
	public List<Object> parse() throws WrongJsonFormatException
	{
		statisticsList = new ArrayList<Object>();
		ImageStatistics statistics;
		int total=0;
		int withImages=0;
		JSONArray arr;
		try {
			arr = initialTweet.getJSONArray("statuses");
		} catch (JSONException e) {
			throw new WrongJsonFormatException("JSON format for this tweet is incorrect");
		}
		for (int i = 0; i < arr.length(); i++)
		{
			total+=1;
			try {
				if(arr.getJSONObject(i).optJSONObject("extended_entities")!=null) {
					withImages+=1;
				}
			} catch (JSONException e) {
				throw new WrongJsonFormatException("JSON format for extended entities is incorrect");
			}
		}
		statistics=new ImageStatistics("spaceX", total, withImages);
		statisticsList.add(statistics);
		return statisticsList;
	}

}
