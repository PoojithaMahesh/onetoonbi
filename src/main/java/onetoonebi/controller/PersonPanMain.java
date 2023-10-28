package onetoonebi.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetoonebi.dao.PanCardDao;
import onetoonebi.dao.PersonDao;
import onetoonebi.dto.PanCard;
import onetoonebi.dto.Person;

public class PersonPanMain {
public static void main(String[] args) {
	Person person=new Person();
	person.setId(1);
	person.setName("Pooji");
	person.setAddress("Mysore");
	
	
	PanCard card=new PanCard();
	card.setId(101);
	card.setName("poojitha");
	card.setAge(18);
	
	
	PersonDao personDao=new PersonDao();
	PanCardDao panCardDao=new PanCardDao();
//	personDao.savePerson(person);
//	
//	panCardDao.savePanCard(1, card);
//	panCardDao.updatePanCard(101, card);
	
//	personDao.updatePerson(1, person);
	
//	personDao.findPersonById(1);
//	panCardDao.findPanCardById(101);
//	panCardDao.deletePanCardById(101);
    personDao.deletePersonById(1);
	
	
	
	
	
	
}
}
