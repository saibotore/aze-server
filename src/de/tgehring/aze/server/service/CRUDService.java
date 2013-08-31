package de.tgehring.aze.server.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import de.tgehring.aze.server.entities.Person;
import de.tgehring.aze.server.entities.WorkingTime;

import java.util.List;

public class CRUDService {

    private static CRUDService instance = null;

    private static final String PERSISTENCE_UNIT_NAME = "azePersistenceUnit";

    private static EntityManagerFactory factory;

    private EntityManager em;

    private CRUDService() {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    public static CRUDService getInstance() {
        if(instance == null) {
            instance = new CRUDService();
        }
        return instance;
    }

    public void createPerson(Person person) {
        em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
        em.close();
    }

    public void updatePerson(Person person) {
        em = factory.createEntityManager();
        em.getTransaction().begin();
        em.merge(person);
        em.getTransaction().commit();
        em.close();
    }

    public void deletePerson(long id) {
        em = factory.createEntityManager();
        em.getTransaction().begin();
        Person person = em.find(Person.class, id);
        em.remove(person);
        em.getTransaction().commit();
        em.close();
    }

    public Person readPerson(long id) {
        em = factory.createEntityManager();
        em.getTransaction().begin();
        Person person = em.find(Person.class, id);
        em.getTransaction().commit();
        em.close();
        return person;
    }

    public List<Person> readPerson() {
        em = factory.createEntityManager();
        em.getTransaction().begin();
        List<Person> coins = em.createNamedQuery("Person.findAll").getResultList();
        em.getTransaction().commit();
        em.close();
        return coins;
    }

    public void createWorkingTime(WorkingTime workingTime) {
        em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(workingTime);
        em.getTransaction().commit();
        em.close();
    }

    public void updateWorkingTime(WorkingTime workingTime) {
        em = factory.createEntityManager();
        em.getTransaction().begin();
        em.merge(workingTime);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteWorkingTime(long id) {
        em = factory.createEntityManager();
        em.getTransaction().begin();
        WorkingTime workingTime = em.find(WorkingTime.class, id);
        em.remove(workingTime);
        em.getTransaction().commit();
        em.close();
    }

    public WorkingTime readWorkingTime(long id) {
        em = factory.createEntityManager();
        em.getTransaction().begin();
        WorkingTime workingTime = em.find(WorkingTime.class, id);
        em.getTransaction().commit();
        em.close();
        return workingTime;
    }

    public List<WorkingTime> readWorkingTime() {
        em = factory.createEntityManager();
        em.getTransaction().begin();
        List<WorkingTime> workingTimes = em.createNamedQuery("WorkingTime.findAll").getResultList();
        em.getTransaction().commit();
        em.close();
        return workingTimes;
    }
}
