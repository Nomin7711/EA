package edu.miu.nomin.jpa;

import edu.miu.nomin.jpa.entity.Course;
import edu.miu.nomin.jpa.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

//A student can only be attending one course, a course can be attended by several students.
//The course room is stored in a table different from the course title and capacity.
//The course number is stored in the database as column CODE.
public class Main {
    public static void main(String[] args) {
        Course course = new Course("EA", "20", 29, 1234567);
        Student student1 = new Student("Nomin", (float)3.5);
        Student student2 = new Student("Jane", (float)3.8);
        Student student3 = new Student("Harry", (float)3.2);
        course.setStudent(student1);
        course.setStudent(student2);
        course.setStudent(student3);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("My_Pu");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(course);
        em.getTransaction().commit();
        em.close();

    }
}
