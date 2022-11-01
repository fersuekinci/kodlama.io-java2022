package kodlamaio.dataAccess;

import kodlamaio.entities.Instructor;

public class JdbcInstructorDao implements IInstructorDao {
    public void add(Instructor instructor) {
        System.out.println("JDBC ile veritabanına eklendi");
    }
}
