package onetoonebi.dao;

import java.awt.datatransfer.SystemFlavorMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetoonebi.dto.Person;

public class PersonDao {

	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
	}
	
public void savePerson(Person person) {
	EntityManager entityManager=getEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	entityTransaction.begin();
	entityManager.persist(person);
	entityTransaction.commit();
}	
	
public void updatePerson(int id,Person person) {
	EntityManager entityManager=getEntityManager();
	Person dbPerson=entityManager.find(Person.class, id);
	if(dbPerson!=null) {
//		person is present then i can update the person details
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		person.setId(id);
		person.setCard(dbPerson.getCard());
		entityManager.merge(person);
		entityTransaction.commit();
	}else {
		System.out.println("Sorry that id is not present");
	}
	
	
	
}
public void findPersonById(int id) {
	EntityManager entityManager=getEntityManager();
	Person dbPerson=entityManager.find(Person.class, id);
	if(dbPerson!=null) {
		System.out.println(dbPerson);
	}else {
		System.out.println("Sorry that id is not present");
	}
	
}

public void deletePersonById(int id) {
	EntityManager entityManager=getEntityManager();
	Person dbPerson=entityManager.find(Person.class, id);
	if(dbPerson!=null) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(dbPerson);
		entityTransaction.commit();
	}else {
		System.out.println("Sorry that id is not present");
	}
}

















}
