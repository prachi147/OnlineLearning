package com.model.cotroller;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.model.Contact;
import com.model.Coursesservice.CourseService;
import com.model.Coursesservice.JobOrientedService;
import com.model.Repository.ContactRepository;
import com.model.courses.Course;
import com.model.courses.JobOriented;
import com.model.service.ContactService;


@Controller
public class ContactController {

	@Autowired
	ContactService contactService;
	
	@Autowired
	ContactRepository  contactRepository;
	
	@Autowired
	CourseService courseService;
	
	@Autowired
	JobOrientedService jobOrientedService;
	
	/*
	 * @GetMapping("/") public String viewIndex(Model model) { List<Course> courses
	 * = courseService.getAllCourses(); model.addAttribute("courses", courses);
	 * model.addAttribute("contact", new Contact()); List<JobOriented> jobOrienteds
	 * = jobOrientedService.getCourses(); model.addAttribute("jobOrienteds",
	 * jobOrienteds); return "index"; }
	 */
	
	// contact form
	@GetMapping("/contact")
	public String viewContact(Model model) {
	
		model.addAttribute("contact", new Contact());
		
		return "contact";
	}
	
	// add contact open form
	@GetMapping("/contactdetail")
	public String contactList(Model model)
	
	
{
		List<Contact> contact = contactService.findAllContact();
		 model.addAttribute("contact1", contact);
		 model.addAttribute("contact", new Contact());
		 
        System.out.println(contact);
    
		return "info";
		
	}
	
	// to save the contact inquiry
	@PostMapping("/save") 
	  public String  submitForm(@Valid @ModelAttribute("contact") Contact contact,BindingResult bindingResult , RedirectAttributes redirAttrs) {
	  
	  
	 if (bindingResult.hasErrors()) {
	 
	 return "contact"; 
	 } 
	 else
	 {
	 
	 contactService.save(contact); 
	 redirAttrs.addFlashAttribute("success", "Our team will contact you soon , Thank you for visiting.");
	 return "redirect:/contact"; 
	    }
	 }
	  
	// update contact
	  @PostMapping("/savee") 
	  public String  editForm(@Valid @ModelAttribute("contact") Contact contact,BindingResult
	  bindingResult) {
	  
	  
	 if (bindingResult.hasErrors()) {
	 
	 return "updatecontact"; 
	 } 
	 else
	 {
	 
	 contactService.save(contact); 
	 return "redirect:/contactdetail"; 
	    }
	 }
	  
	  // delete ontact
	 @GetMapping("/deletee/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
	    Contact c = contactRepository.findById(id)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	    contactRepository.delete(c);
	    return "redirect:/contactdetail";
	}
	
	 
	 // update 
	@GetMapping("/edi/{id}")
	public String showEditProductPage(@PathVariable("id") long id , Model model,Contact contact) {
		 model.addAttribute("contact", contact);
	    contactService.get(id);
	 
	     
	    return "updatecontact";
	}	
	
}
