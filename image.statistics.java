package com.example.spaceX.model;


public class ImageStatistics {
	
	private static final long serialVersionUID = 1L;
	private String queryText;
	private int totalTweets;
	private int tweetsWithImages;
	
	
	public ImageStatistics(String queryText, int totalTweets, int tweetsWithImages) {
		super();
		this.queryText = queryText;
		this.totalTweets = totalTweets;
		this.tweetsWithImages = tweetsWithImages;
	}
