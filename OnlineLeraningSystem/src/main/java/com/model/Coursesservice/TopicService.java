package com.model.Coursesservice;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.CoursesRepository.TopicRepository;
import com.model.courses.Course;
import com.model.courses.Topic;

@Service
public class TopicService {

	@Autowired
	private TopicRepository repository;
	public List<Topic> getDetail() {
		
		return repository.findAll();
	}
	
	public void save(Topic topic) {
		repository.save(topic);
		
	}
	
	public void get(long topicId) {
		repository.findById(topicId).get();
		
	} 
	
		public List<Topic> getByCourseId(Course coursesId) {
				
		return  repository.findTopicByCoursesId(coursesId);
	}

		
}
