package com.model.coursesController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.model.CoursesRepository.JobOrientedRepository;
import com.model.Coursesservice.JobOrientedService;
import com.model.courses.JobOriented;

@Controller
public class JobOrientedController {
	
	@Autowired
	private JobOrientedRepository orientedRepository;
	@Autowired
	private JobOrientedService jobOrientedService;
	
	/* main jobs */
	// main jobs get all courses
	@RequestMapping("/jobs")
	public String completeCourse(Model model) {
		
		List<JobOriented> jobOrienteds= jobOrientedService.getCourses();
		model.addAttribute("jobOrienteds", jobOrienteds);
		System.out.println("jobOrienteds -----------------------"+jobOrienteds);
		return "JobOriented";
	}
	
	
	// showing the add new course
	@RequestMapping("/addjobcoursesp")
	public String topicList(Model  model) {
		
		List<JobOriented> jobOrienteds= jobOrientedService.getCourses();
		System.out.println("Show Courses"+jobOrienteds);
		model.addAttribute("jobOrienteds", new JobOriented());
		model.addAttribute("job1Orienteds", jobOrienteds);
		return "addJobCourse";
	}
	
	//  add new course handler
	@PostMapping("/addJobCourses")
	public String addJobCourses(@ModelAttribute("jobOriented") JobOriented jobOriented, Model model) {
		jobOrientedService.save(jobOriented);
		System.out.println("Job oriented detail....: "+jobOriented);
		return "redirect:/user/addjobcoursesp";
	}
	
	// edit or update the course
	@RequestMapping("/editttt/{jobId}")
	public String showEditProductPage(@PathVariable("jobId") long jobId , Model model,JobOriented jobOriented) {
		
		jobOrientedService.get(jobId);
		model.addAttribute("jobOriented", jobOriented);
		 
	  
	    return "updatejobCourse";
	}
	
	// delete the job/main course 
	@RequestMapping("/deletett/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model, JobOriented jobOriented) {
		JobOriented jo= orientedRepository.findById(id)
				.orElseThrow(()-> new IllegalArgumentException("Invalid : "+id));
		orientedRepository.delete(jo);
		return "redirect:/user/addjobcoursesp";
		
	}
	

}
