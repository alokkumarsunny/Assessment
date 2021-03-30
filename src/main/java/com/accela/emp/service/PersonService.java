package com.accela.emp.service;

import java.util.List;

import com.accela.emp.db.PersonDao;
import com.accela.emp.model.Person;

public class PersonService {

	public int getPersonCount() {
		PersonDao personDaoObj = new PersonDao();
		return personDaoObj.getPersonCount();
	}

	public List<Person> getAllPerson() {
		PersonDao personDaoObj = new PersonDao();
		return personDaoObj.getPersonList();
	}

	public int addPerson(Person person) {
		PersonDao personDaoObj = new PersonDao();
		return personDaoObj.addPerson(person);
	}

	public int editPerson(Person person) {
		PersonDao personDaoObj = new PersonDao();
		return personDaoObj.editPerson(person);
	}

	public int deletePerson(int personId) {
		PersonDao personDaoObj = new PersonDao();
		return personDaoObj.deletePerson(personId);
	}

}
