package com.example.spaceX.model;

public class WordStatistics {
	
	public String word;
	public int appearances;
  public WordStatistics(String word, int appearances) {
		super();
		this.word = word;
		this.appearances = appearances;
	}
	
	
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public int getAppearances() {
		return appearances;
	}
	public void setAppearances(int appearances) {
		this.appearances = appearances;
	}
	
	

}

