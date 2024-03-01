package com.model.Coursesservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.CoursesRepository.CourseRepository;
import com.model.CoursesRepository.JobOrientedRepository;
import com.model.courses.Course;
import com.model.courses.JobOriented;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private JobOrientedRepository orientedRepository;
	
	public List<Course> getAllCourses() {
		
		return courseRepository.findAll();
	}

	
	public void save(Course courses) {
		 courseRepository.save(courses);
		 System.out.println("Course service :" +courses);
						}
	public List<Course> getCourseByCoursesId(Long coursesId) {
		return courseRepository.findByCoursesId(coursesId);
	}
	
	public List<Course> getCourseByJobId(JobOriented jobId) {
		return orientedRepository.findByJobId(jobId);
	}
	

	public void get(long coursesId) {
		courseRepository.findById(coursesId).get();
		
	} 


	
}
