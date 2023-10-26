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
	person.setName("Poojitha");
	person.setAddress("Mysore");
	
	PanCard card=new PanCard();
	card.setId(101);
	card.setName("poojithajm");
	card.setAge(18);
	
	
	PersonDao personDao=new PersonDao();
	PanCardDao panCardDao=new PanCardDao();
	
	
	
	panCardDao.savePanCard(1,card);
	
	
	
	
	
	
	
	
	
	
	
	
}
}
