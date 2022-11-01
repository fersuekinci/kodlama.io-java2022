package kodlamaio.dataAccess;

import kodlamaio.entities.Course;

public class JdbcCourseDao implements ICourseDao {
    public void add(Course course) {
        System.out.println("JDBC ile veritabanına eklendi");
    }
}
