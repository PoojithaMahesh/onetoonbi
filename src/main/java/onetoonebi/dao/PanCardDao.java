package onetoonebi.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetoonebi.dto.PanCard;
import onetoonebi.dto.Person;

public class PanCardDao {
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
	}
	
public void savePanCard(int personId, PanCard panCard) {
	EntityManager entityManager=getEntityManager();
	Person person=entityManager.find(Person.class, personId);
	
	if(person!=null) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		panCard.setPerson(person);
		entityManager.persist(panCard);
//		updating the person details
		person.setCard(panCard);
		
		entityTransaction.commit();
	}else {
//		person is not present
		System.out.println("Sorry that person is not present");
	}	
}

public void updatePanCard(int id,PanCard card) {
	EntityManager entityManager=getEntityManager();
	PanCard dbCard=entityManager.find(PanCard.class, id);
	if(dbCard!=null) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		card.setId(id);
		card.setPerson(dbCard.getPerson());
		entityManager.merge(card);
		entityTransaction.commit();
	}else {
		System.out.println();
	}
	
	
	
}
public void findPanCardById(int id) {
	EntityManager entityManager=getEntityManager();
	PanCard dbCard=entityManager.find(PanCard.class, id);
	if(dbCard!=null) {
		System.out.println(dbCard);
	}else {
		System.out.println();
	}
}

public void deletePanCardById(int id) {
	EntityManager entityManager=getEntityManager();
	PanCard dbCard=entityManager.find(PanCard.class, id);
	if(dbCard!=null) {
		EntityTransaction  entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		
		Person person=dbCard.getPerson();
//		person 1
		person.setCard(null);
		
		entityManager.remove(dbCard);
		entityTransaction.commit();
	}else {
		System.out.println("Sorry id is noy present");
	}
}



	
}
