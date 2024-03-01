package com.model.CoursesRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.courses.Course;



public interface CourseRepository extends JpaRepository<Course, Long>{

	
	List<Course> findByCoursesId(Long courseId);
}
