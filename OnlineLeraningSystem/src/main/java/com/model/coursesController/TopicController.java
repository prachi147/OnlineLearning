package com.model.coursesController;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.Contact;
import com.model.CoursesRepository.TopicRepository;
import com.model.Coursesservice.CourseService;
import com.model.Coursesservice.TopicService;
import com.model.courses.Course;
import com.model.courses.Topic;

@Controller
public class TopicController {

	@Autowired
	private TopicService topicService;
	
	@Autowired
	private TopicRepository topicRepository;
	
	@Autowired
	private CourseService courseService;
	
	
	// mak a page for get all topics 
	@RequestMapping("/getopics")
	public String gettopics() {
		List<Course> courses= courseService.getAllCourses();
		List<Topic> topic1= topicService.getDetail();
		return "alltopics";
	}
	
	@GetMapping("/addNewTopic")
	public String addTopic(Model model) {
		List<Course> courses = courseService.getAllCourses();
		System.out.println("Courses get "+courses);
		model.addAttribute("courses", courses);
		
		List<Topic> topic = topicService.getDetail();
		System.out.println("Topic Get "+topic);
		 model.addAttribute("topic", new Topic());
	
		model.addAttribute("topic1", topic);
	      return "addtopic";
	}
	
	
	
	// save the topic 
	@PostMapping("/addTopic")
	public String addTopic(@Valid @ModelAttribute("topic") Topic topic,Model model , BindingResult bindingResult) throws IOException 
	{
		System.out.println("Before topic detail : "+topic);
		
		if(bindingResult.hasErrors()) {
			return "add_new_courses";
		}else {
			List<Course> courses = courseService.getAllCourses();
			model.addAttribute("courses", courses);
			List<Topic> topic1 = topicService.getDetail();
			model.addAttribute("topic1", topic1);
			topicService.save(topic);
			System.out.println("-------------- detail topic ---------"+topic);
			System.out.println("Success fully added ");
			return "addtopic";
		}
		
	}
	
	

//	
	@RequestMapping("/delet/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
	   Topic c = topicRepository.findById(id)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	    topicRepository.delete(c);
	    return "redirect:/addNewTopic";
	}
	
	@RequestMapping("/edittt/{topicId}")
	public String showEditProductPage(@PathVariable("topicId") long topicId , Model model,Topic topic) {
		 model.addAttribute("topic", topic);
	    topicService.get(topicId);
	    List<Course> courses = courseService.getAllCourses();
	    model.addAttribute("courses", courses);
	    return "topicUpdate";
	}
	

}
