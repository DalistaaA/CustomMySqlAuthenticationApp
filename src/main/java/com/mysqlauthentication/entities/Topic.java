package com.mysqlauthentication.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "topics", schema = "springsecuritydb")
public class Topic {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "topic_id")
	private int topicId;
	
	@Column(name = "category",length=800, nullable=false)
	private String category;
	
	@Column(name = "tittle",length=800, nullable=false)
	private String tittle;


	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

}
