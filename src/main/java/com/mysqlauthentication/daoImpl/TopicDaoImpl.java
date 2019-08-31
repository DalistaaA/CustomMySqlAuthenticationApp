package com.mysqlauthentication.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mysqlauthentication.dao.TopicDao;
import com.mysqlauthentication.entities.Topic;

@Transactional
@Repository
@Service
public class TopicDaoImpl implements TopicDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Topic> getAllTopics() {
		String HQL ="FROM Topic as t ORDER BY t.topicId";
		return (List<Topic>) entityManager.createQuery(HQL).getResultList();
	}

	@Override
	public Topic getTopicById(int topicId) {
		return entityManager.find(Topic.class, topicId);
	}

	@Override
	public void addTopic(Topic topic) {
		entityManager.persist(topic);
	}

	@Override
	public void updateTopic(Topic topic) {
		Topic topicFromdb = getTopicById(topic.getTopicId());
		if(topicFromdb !=null) {
			topicFromdb.setTittle(topic.getTittle());
			topicFromdb.setCategory(topic.getCategory());
			entityManager.flush();
		}
		else {
			System.out.println("Topic doesn't exist which you want update");
		}
	}

	@Override
	public void deleteTopic(int topicId) {
		Topic topic = getTopicById(topicId);
		if(topic !=null) {
			entityManager.remove(topic);
		}
		else {
			System.out.println("Topic doesn't exist which you want delete");
		}
	}
	
	@Override
	public boolean topicExists(String tittle, String category) {
		String hql = "FROM Topic as t WHERE t.tittle =? and t.category =?";
		int count = entityManager.createQuery(hql).setParameter(1, tittle).setParameter(2, category).getResultList().size();
		return count > 0 ? true : false;
	}

}
