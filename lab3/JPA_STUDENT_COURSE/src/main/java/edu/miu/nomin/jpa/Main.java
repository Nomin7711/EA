package edu.miu.nomin.jpa;

import edu.miu.nomin.jpa.entity.Course;
import edu.miu.nomin.jpa.entity.DistanceEducation;
import edu.miu.nomin.jpa.entity.OnCampus;
import edu.miu.nomin.jpa.entity.Student;
import jakarta.persistence.*;
import jakarta.persistence.criteria.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        EntityManager em = getEntityManager();

        //Select all students
        String queryString = "SELECT s FROM Student s";
        TypedQuery<Student> query = em.createQuery(queryString, Student.class);
        Stream<Student> stream = query.getResultStream();
        System.out.println("Student list: ");
        stream.forEach(System.out::println);

        //1.JPQL: Find students with GPA > 3.5 in courses with capacity > 30
        String queryStr = "SELECT s FROM Student s JOIN s.courseAttending c WHERE s.gpa > :gpa AND TYPE(c) = OnCampus AND c.capacity > :capacity";

        TypedQuery<Student> query1 = em.createQuery(queryStr, Student.class);
        query1.setParameter("gpa", 3.5);
        query1.setParameter("capacity", 30);
        List<Student> students = query1.getResultList();
        students.forEach(System.out::println);

        //2. NamedQuery "CanGraduate": Find students with GPA ≥ 3.0, 9+ courses taken, not currently enrolled
        TypedQuery<Student> query2 = em.createNamedQuery("Student.CanGraduate", Student.class);
        System.out.println("Students with gpa >= 3 and 9+ courses taken: ");
        query2.getResultStream().forEach(System.out::println);

        //3.CriteriaAPI: Find students with GPA < 3.0 in DE courses with "Najeeb"
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Student> cq = cb.createQuery(Student.class);
        Root<Student> rootStudent = cq.from(Student.class);
        cq.select(rootStudent);
        Predicate gpaPredicate = cb.lessThan(rootStudent.get("gpa"), 3.0);
        Join<Student, Course> joinCourse = rootStudent.join("courseAttending");;
        Predicate profNamePredicate = cb.equal(joinCourse.get("professorName"), "Najeeb");
        cq.where(gpaPredicate, profNamePredicate);
        TypedQuery<Student> query3 = em.createQuery(cq);
        List<Student> students3 = query3.getResultList();
        System.out.println("Students with gpa < 3 and DE courses with Najeeb: ");
        students3.forEach(System.out::println);

        em.close();

    }

    private static EntityManager getEntityManager() {
        OnCampus onCampusCourse1 = new OnCampus("MPP", new Date(2024, 11, 20), "Renuka", "Room 101", 30);
        DistanceEducation distanceCourse = new DistanceEducation("EA", new Date(2024, 9, 20), "Najeeb", "Dr. Lee", List.of(new Date(2024, 9, 25), new Date(2024, 9, 30)));
        OnCampus onCampusCourse2 = new OnCampus("Algorithm", new Date(2024, 10, 20), "Nair", "Room 102", 20);

        Student student1 = new Student("Nomin", (float)3.5);
        Student student2 = new Student("Jane", (float)3.8);
        Student student3 = new Student("Harry", (float)3.2);
        Student student4 = new Student("Potter", (float)2.0);

        student1.setCourseAttending(onCampusCourse1);
        student1.setCoursesAttended(distanceCourse);
        student1.setCoursesAttended(onCampusCourse2);

        student2.setCourseAttending(distanceCourse);
        student2.setCoursesAttended(onCampusCourse1);

        student3.setCourseAttending(distanceCourse);
        student3.setCoursesAttended(onCampusCourse2);

        student4.setCourseAttending(distanceCourse);

        onCampusCourse1.setStudent(student1);
        onCampusCourse1.setEnrolledStudents(student2);

        distanceCourse.setStudent(student2);
        distanceCourse.setStudent(student3);
        distanceCourse.setEnrolledStudents(student1);

        onCampusCourse2.setEnrolledStudents(student1);
        onCampusCourse2.setEnrolledStudents(student3);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("My_Pu");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(onCampusCourse1);
        em.persist(distanceCourse);
        em.persist(onCampusCourse2);
        em.persist(student1);
        em.persist(student2);
        em.persist(student3);
        em.persist(student4);
        em.getTransaction().commit();
        return em;
    }
}
