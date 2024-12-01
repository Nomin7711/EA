package edu.miu.nomin.jpa.service;

import edu.miu.nomin.jpa.entity.Car;
import edu.miu.nomin.jpa.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class CRUD_service implements AutoCloseable{
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction tx;
    public CRUD_service(String persistenceUnitName) {
        emf = Persistence.createEntityManagerFactory(persistenceUnitName);
        em = emf.createEntityManager();
    }
    private void startTransaction() {
        tx = em.getTransaction();
        tx.begin();
    }

    private void endTransaction() {
        tx.commit();
    }
    public void create(Car car){
        startTransaction();
        em.persist(car);
        endTransaction();
    }
    public void create(Person person){
        startTransaction();
        em.persist(person);
        endTransaction();
    }
    public Car read(long id) {
        startTransaction();
        Car car = em.find(Car.class, id);
        endTransaction();
        return car;
    }
    public Car update(Car car){
        startTransaction();
        Car updatedCar = em.merge(car);
        endTransaction();
        return updatedCar;
    }
    public void delete(Car car){
        startTransaction();
        em.remove(car);
        endTransaction();
    }
    @Override
    public void close() throws Exception {
        em.close();
        emf.close();
    }
}
