package edu.miu.nomin.jpa;

import edu.miu.nomin.jpa.entity.User;
import jakarta.persistence.*;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("App started");
        User user = new User("Jack", "Jack01", "hello123.");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyPerUnit");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try{
            //Create
            tx.begin();
            em.persist(user);
            tx.commit();

            //Read
            User foundUser = em.find(User.class, user.getId());
            System.out.println("Found user => " + foundUser);

            //Update
            foundUser.setName("Jack Johnson");
            tx.begin();
            User updatedUser = em.merge(foundUser);
            tx.commit();
            System.out.println("Updated user => " + em.find(User.class, updatedUser.getId()));

            //Delete
//            tx.begin();
//            em.remove(updatedUser);
//            tx.commit();
//            System.out.println("Removed user => " + em.find(User.class, user.getId()));

            //Check username and password
            String username = "Jack01";
            String password = "hello123.";
            System.out.println("user found : " + checkUserExists(em, username, password));

            //return total number of users
            System.out.println("user count : " + getTotalUsers(em));

        }finally {
            em.close();
            emf.close();
        }


    }
    //method to check if a User with a given username and password exists and return true or false.
    public static boolean checkUserExists(EntityManager em, String username, String password) {
        String queryString = "SELECT u FROM User u WHERE u.username = :username AND u.password = :password";
        TypedQuery<User> query = em.createQuery(queryString, User.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        Stream<User> users = query.getResultStream();
        Long count = users.count();
        return count > 0;
    }

    // method to return the total number of users in the database.
    public static long getTotalUsers(EntityManager em) {
        String queryString = "SELECT COUNT(u) FROM User u";
        Long count = (Long) em.createQuery(queryString).getSingleResult();
        return count;
    }
}
