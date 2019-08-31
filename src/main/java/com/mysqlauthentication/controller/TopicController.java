package com.mysqlauthentication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.mysqlauthentication.entities.Topic;
import com.mysqlauthentication.service.TopicService;

@RestController
@RequestMapping("/user")
public class TopicController {

	@Autowired
	private TopicService topicService;
	
	@GetMapping("/topics/{id}")
	public ResponseEntity<Topic> getTopicById(@PathVariable("id") Integer id){
		Topic topic = topicService.getTopicById(id);
		return new ResponseEntity<Topic>(topic, HttpStatus.OK);
	}
	
	@GetMapping("/topics")
	public ResponseEntity<List<Topic>> getAllTopics(){
		List<Topic> list = topicService.getAllTopics();
		return new ResponseEntity<List<Topic>>(list, HttpStatus.OK);
	}
	
	@PostMapping("/topic")
	public ResponseEntity<String> addTopic(@RequestBody Topic topic, UriComponentsBuilder builder){
		boolean flag = topicService.addTopic(topic);
		if(flag==false) {
			return new ResponseEntity<String>("This topic is already exist", HttpStatus.CONFLICT);
		}
		else {
			return new ResponseEntity<String>( HttpStatus.OK);
		}
	}
	
	
}
