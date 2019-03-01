package com.techelevator;

import java.util.Arrays;
import java.util.List;

public class ForumDao {

	private static List<ForumTopic> allTopics;
	
	public ForumDao() {
		allTopics = Arrays.asList(new ForumTopic[]{new ForumTopic(1L, "Should Pluto be a planet???"),
							      new ForumTopic(2L, "Are Vulcans real?"),
								  new ForumTopic(3L, "The Moon Landing was a hoax!!!")});
	}
	
	public List<ForumTopic> readAllTopics() {
		return allTopics;
	}
	
	public ForumTopic getForumTopicById(Long id) {
		if(id <= allTopics.size()) {
			return allTopics.get((int)(id - 1));
		} else {
			return null;
		}
	}
}
