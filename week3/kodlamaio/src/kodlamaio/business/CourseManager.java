package kodlamaio.business;

import kodlamaio.core.logging.Logger;
import kodlamaio.dataAccess.ICourseDao;
import kodlamaio.entities.Course;

import java.util.List;

public class CourseManager {
    private ICourseDao courseDao;
    private Logger[] loggers;

    private List<Course> courses;

    public CourseManager(ICourseDao courseDao, Logger[] loggers, List<Course> courses) {
        this.courseDao = courseDao;
        this.loggers = loggers;
        this.courses = courses;
    }

    public void add(Course course) throws Exception {
        if(course.getPrice()<0) {
            throw new Exception("course price cannot be lower than 0");
        }
        for(Course each : courses) {
            if(course.getName().equals(each.getName())) {
                throw new Exception("course name cannot be repeated");
            }
        }

        courseDao.add(course);
        courses.add(course);

        for(Logger logger : loggers) {
            logger.log(course.getName());
        }
    }
}
