package com.model.CoursesRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.courses.Course;
import com.model.courses.JobOriented;


public interface JobOrientedRepository extends JpaRepository<JobOriented, Long>{

	List<Course> findByJobId(JobOriented jobId);
	

}
