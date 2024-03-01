package com.model.courses;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Topic {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long topicId;
    private String topicName;
	private String description;
	
	
@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	
	@JoinColumn(name = "courses_id", nullable = false )
	
	 Course coursesId;

	public Topic() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Topic(Long topicId, String topicName, String description, String topicImg, Course coursesId) {
		super();
		this.topicId = topicId;
		this.topicName = topicName;
		this.description = description;
		this.coursesId = coursesId;
	}

	public Long getTopicId() {
		return topicId;
	}

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	public Course getCoursesId() {
		return coursesId;
	}

	public void setCoursesId(Course coursesId) {
		this.coursesId = coursesId;
	}

	@Override
	public String toString() {
		return "Topic [topicId=" + topicId + ", topicName=" + topicName + ", description=" + description
				+ ", coursesId=" + coursesId + "]";
	}

	
	
	
	
	
	
}
