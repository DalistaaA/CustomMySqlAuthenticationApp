package com.mysqlauthentication.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysqlauthentication.dao.TopicDao;
import com.mysqlauthentication.entities.Topic;
import com.mysqlauthentication.service.TopicService;

@Service
public class TopicServiceImpl implements TopicService{

	@Autowired
	private TopicDao topicDao;
	
	@Override
	public List<Topic> getAllTopics() {
		return topicDao.getAllTopics();
	}

	@Override
	public Topic getTopicById(int topicId) {
		Topic topic = topicDao.getTopicById(topicId);
		return topic;
	}

	@Override
	public boolean addTopic(Topic topic) {
		return false;
	}

	@Override
	public void updateTopic(Topic topic) {
		
	}

	@Override
	public void deleteTopic(int topicId) {
		
	}

}
