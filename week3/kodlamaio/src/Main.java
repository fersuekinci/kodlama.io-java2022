
// eğitmen , kategori , kurs -----------------------
// jdbc , hibernate --------------------------------
// çoklu loglama -----------------------------------
// * kurs ismi tekrar edemez -----------------------
// * kategori ismi tekrar edemez -------------------
// * bir kursun fiyatı 0'dan küçük olamaz ----------


import kodlamaio.business.CategoryManager;
import kodlamaio.business.CourseManager;
import kodlamaio.core.logging.DatabaseLogger;
import kodlamaio.core.logging.FileLogger;
import kodlamaio.core.logging.Logger;
import kodlamaio.core.logging.MailLogger;
import kodlamaio.dataAccess.HibernateCategoryDao;
import kodlamaio.dataAccess.JdbcCourseDao;
import kodlamaio.entities.Category;
import kodlamaio.entities.Course;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Course course1 = new Course(1,"math",1000);
        //Course course2 = new Course(2,"math",2000);

        Category category1 = new Category(1, "language");
       //Category category2 = new Category(2,"language");

        Logger[] loggers = {new DatabaseLogger(), new FileLogger(), new MailLogger()};

        List<Course> courses = new ArrayList<>();
        List<Category> categories = new ArrayList<>();

        CourseManager courseManager = new CourseManager(new JdbcCourseDao(), loggers, courses);
        courseManager.add(course1);
        //courseManager.add(course2);

        CategoryManager categoryManager = new CategoryManager(new HibernateCategoryDao(), loggers, categories);
        categoryManager.add(category1);
        //categoryManager.add(category2);
    }
}