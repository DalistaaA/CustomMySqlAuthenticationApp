package com.mysqlauthentication.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.mysqlauthentication.entities.Topic;
@Service
public interface TopicService {

	@Secured({"ROLE_ADMIN","ROLE_USER"})
	public abstract List<Topic> getAllTopics();
	
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	public abstract Topic getTopicById(int topicId);
	
	@Secured({"ROLE_ADMIN"})
	public abstract boolean addTopic(Topic topic);
	
	@Secured({"ROLE_ADMIN"})
	public abstract void updateTopic(Topic topic);
	
	@Secured({"ROLE_ADMIN"})
	public abstract void deleteTopic(int topicId);
	
}
