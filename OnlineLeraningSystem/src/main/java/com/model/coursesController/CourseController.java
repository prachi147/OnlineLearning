package com.model.coursesController;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.model.Contact;
import com.model.CoursesRepository.CourseRepository;
import com.model.Coursesservice.CourseService;
import com.model.Coursesservice.JobOrientedService;
import com.model.Coursesservice.TopicService;
import com.model.courses.Course;
import com.model.courses.JobOriented;
import com.model.courses.Topic;

@Controller
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@Autowired
	private TopicService service;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private JobOrientedService js;
	
	
	// to get the course or explore button page 
	// check the ui 
		@RequestMapping("/courses")
		public String topicList(Model model) {
			
			List<Topic> topic= service.getDetail();
			model.addAttribute("topic", topic);
			return "course";
		}
		
		//main course page
	@RequestMapping("/allCourses")
	public String mainCourses(Model model) {
		
		 List<Course> courses = courseService.getAllCourses();
		 model.addAttribute("courses", courses);
		
	  System.out.println("_____________________________________________");
		return "AllCourses";
	}
	
	// add the courses
	@RequestMapping("/addNewCourses")
	public String viewContact(Model model) {
		List<JobOriented> jobOrienteds = js.getCourses();
		 model.addAttribute("jobOrienteds", jobOrienteds);
	List<Course> courses = courseService.getAllCourses();	
	model.addAttribute("courses",new Course());
	
	model.addAttribute("courses1", courses);
	return "add_new_courses";
	 //return "AllCourses";
	}
	
	@PostMapping("/addCourses")
	public  String submitForm(@Valid  @ModelAttribute("courses") Course courses,Model model,BindingResult bindingResult) throws IOException 
	{
	    System.out.println("Before courses_DEtail :"+courses);
	     if (bindingResult.hasErrors()) {       
	     return "add_new_courses";
	 } 
	    else {
	   	 
	     List<JobOriented> jobOrienteds = js.getCourses();
		 model.addAttribute("jobOrienteds", jobOrienteds);
	 	List<Course> courses1 = courseService.getAllCourses();	
	 	model.addAttribute("courses1", courses1);
	 	courseService.save(courses);
	 	System.out.println(".......Details : ......."+courses);
	 	return "add_new_courses";
	    }
	}
	
	// update the courses
	@RequestMapping("/edit/{coursesId}")
	public String showEditProductPage(@PathVariable("coursesId") long coursesId , Model model,Course courses) {
		 model.addAttribute("courses1", courses);
	    courseService.get(coursesId);
	    List<JobOriented> jobOrienteds = js.getCourses();
		 model.addAttribute("jobOrienteds", jobOrienteds);
	     
	    return "courseUpdate";
	}
	
	
	// delete the course
	@GetMapping("/deletet/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model , Course courses) {
	    Course c = courseRepository.findById(id)
	    
	    		.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	   
	    courseRepository.delete(c);
	    return "redirect:/user/addNewCourses";
	}
	
	

	
	
}
