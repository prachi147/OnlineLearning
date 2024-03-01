package com.model.CoursesRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.courses.Course;
import com.model.courses.Topic;

public interface TopicRepository extends JpaRepository<Topic, Long>{

	List<Topic> findTopicByCoursesId(Course coursesId);
}
