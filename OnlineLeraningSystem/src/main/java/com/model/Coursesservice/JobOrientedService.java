package com.model.Coursesservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.CoursesRepository.JobOrientedRepository;
import com.model.courses.JobOriented;

@Service
public class JobOrientedService {

	@Autowired
	private JobOrientedRepository jobOrientedRepository;
	
	public List<JobOriented> getCourses() {
		return jobOrientedRepository.findAll();
	}

	public JobOriented save(JobOriented jobOriented) {
		
		 return  jobOrientedRepository.save(jobOriented);
	}

	public void get(long jobId) {
		
		
		jobOrientedRepository.findById(jobId).get();		
	}
}
