package com.techelevator;

public class ForumTopic {
	
	private Long id;
	private String title;
	
	public ForumTopic(Long id, String title) {
		this.id = id;
		this.title = title;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
}
