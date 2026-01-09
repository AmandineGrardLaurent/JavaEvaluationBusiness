package training.sales.application.service;

import java.util.List;

import training.sales.application.dao.CourseDAO;
import training.sales.application.model.Course;

/**
 * Service class for managing course-related operations.
 * Provides methods to retrieve courses from the database.
 */
public class CourseService {

    private CourseDAO courseDao = new CourseDAO();

    /**
     * Retrieves all courses from the database.
     *
     * @return a list of all Course objects
     */
    public List<Course> getAllCourses() {
        return courseDao.readAll();
    }

    /**
     * Retrieves courses filtered by type (on-site, online, or both).
     *
     * @param isOnSite true if the course is on-site
     * @param isOnline true if the course is online
     * @return a list of Course objects matching the type
     */
    public List<Course> getCoursesByType(boolean isOnSite, boolean isOnline) {
        return courseDao.readAllByType(isOnSite, isOnline);
    }

    /**
     * Retrieves courses that match a keyword in their name or description.
     *
     * @param keyword the keyword to search for
     * @return a list of Course objects matching the keyword
     */
    public List<Course> getCoursesByKeyword(String keyword) {
        return courseDao.readAllByKeyword(keyword);
    }
    
    /**
     * Checks whether a course exists based on its identifier.
     *
     * @param idCourse the identifier of the course to verify
     * @return true if the course exists, false otherwise
     */
    public boolean verifyCourseExists(int idCourse) {
    	return getAllCourses().stream()
    						  .anyMatch(course -> course.getId() == idCourse);
    }

}


