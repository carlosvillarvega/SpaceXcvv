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
	public String getQueryText() {
		return queryText;
	}
	public void setQueryText(String queryText) {
		this.queryText = queryText;
	}
	public int getTotalTweets() {
		return totalTweets;
	}
	public void setTotalTweets(int totalTweets) {
		this.totalTweets = totalTweets;
	}
	public int getTweetsWithImages() {
		return tweetsWithImages;
	}
	public void setTweetsWithImages(int tweetsWithImages) {
		this.tweetsWithImages = tweetsWithImages;
	}
	
	
	
}

