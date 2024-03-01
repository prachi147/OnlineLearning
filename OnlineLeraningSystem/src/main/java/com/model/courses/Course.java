package com.model.courses;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
public class Course {

	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long coursesId;
	private String courseName;
	
	private String courseDuration;
	
	private String modes;
	
	private String courseImg;
	
@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	
	@JoinColumn(name = "job_id", nullable = false )
	
			JobOriented jobId;
	
			@OneToMany(fetch = FetchType.LAZY, mappedBy = "coursesId", cascade = CascadeType.ALL)
		private List<Topic> topic = new ArrayList<Topic>();

			public Course() {
				super();
				// TODO Auto-generated constructor stub
			}

			public Course(long coursesId, String courseName, String courseDuration, String modes, String courseImg,
					 JobOriented jobId, List<Topic> topic) {
				super();
				this.coursesId = coursesId;
				this.courseName = courseName;
				this.courseDuration = courseDuration;
				this.modes = modes;
				this.courseImg = courseImg;
				
				this.jobId = jobId;
				this.topic = topic;
			}

			public long getCoursesId() {
				return coursesId;
			}

			public void setCoursesId(long coursesId) {
				this.coursesId = coursesId;
			}

			public String getCourseName() {
				return courseName;
			}

			public void setCourseName(String courseName) {
				this.courseName = courseName;
			}

			public String getCourseDuration() {
				return courseDuration;
			}

			public void setCourseDuration(String courseDuration) {
				this.courseDuration = courseDuration;
			}

			public String getModes() {
				return modes;
			}

			public void setModes(String modes) {
				this.modes = modes;
			}

			public String getCourseImg() {
				return courseImg;
			}

			public void setCourseImg(String courseImg) {
				this.courseImg = courseImg;
			}


			public JobOriented getJobId() {
				return jobId;
			}

			public void setJobId(JobOriented jobId) {
				this.jobId = jobId;
			}

			public List<Topic> getTopic() {
				return topic;
			}

			public void setTopic(List<Topic> topic) {
				this.topic = topic;
			}

			@Override
			public String toString() {
				return "Course [coursesId=" + coursesId + ", courseName=" + courseName + ", courseDuration="
						+ courseDuration + ", modes=" + modes + ", courseImg=" + courseImg + ", jobId=" + jobId
						+ ", topic=" + topic + "]";
			}

			
	
	
}
