package com.example.spaceX.parser;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.client.RestTemplate;

import com.example.spaceX.exceptions.WrongURIException;

public abstract class SpaceXParser {

	JSONObject initialize(String uriStr) throws WrongURIException{
		URI uri = null;
		try {
			uri = new URI(uriStr);
		} catch (URISyntaxException e) {
			throw new WrongURIException(uriStr, "URI is not well built");
		}
		RestTemplate restTemplate = new RestTemplate();
		Map tweets= restTemplate.getForEntity(uri, Map.class).getBody();
		
		return new JSONObject(tweets);
	}
	
	abstract List<Object> parse() throws JSONException;
}
