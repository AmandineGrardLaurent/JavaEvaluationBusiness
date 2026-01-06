package training.sales.application.service;

import java.util.List;

import training.sales.application.dao.CourseDAO;
import training.sales.application.model.Course;

public class CourseService {
	
	private CourseDAO courseDao = new CourseDAO();
	

	public List<Course> getAllCourses() {	
		return courseDao.readAll();
	}
	
	public List<Course> getCoursesByType(boolean isOnSite, boolean isOnline){
		return courseDao.readAllByType(isOnSite, isOnline);
	}
	
	public List<Course> getCoursesByKeyword(String keyword){
		return courseDao.readAllByKeyword(keyword);
	}
}
