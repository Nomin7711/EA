package edu.miu.nomin.jpa;

import edu.miu.nomin.jpa.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

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
            tx.begin();
            em.remove(updatedUser);
            tx.commit();
            System.out.println("Removed user => " + em.find(User.class, user.getId()));

        }finally {
            em.close();
            emf.close();
        }


    }
}
