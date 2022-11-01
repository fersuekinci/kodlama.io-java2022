package kodlamaio.dataAccess;

import kodlamaio.entities.Instructor;

public class HibernateInstructorDao implements IInstructorDao{
    public void add(Instructor instructor) {
        System.out.println("Hibernate ile veritabanına eklendi");
    }
}
