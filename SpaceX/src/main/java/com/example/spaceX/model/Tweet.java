package com.example.spaceX.model;

public class Tweet {
	public String creationDate;
	public int id;
	public String text;
	public String metadata;
	
	
	public Tweet(String creationDate, int id, String text, String metadata) {
		super();
		this.creationDate = creationDate;
		this.id = id;
		this.text = text;
		this.metadata=metadata;
	}
	
	
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}


	public String getMetadata() {
		return metadata;
	}


	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}
	
	
}
