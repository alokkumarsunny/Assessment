package com.accela.emp.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.accela.emp.model.Person;

public class PersonServiceTest {
	  
    @Test
    public void testApp() {
    	Person perObj = new Person(4002, "KH", "MM");
    	PersonService personService = new PersonService();
    	int i = personService.addPerson(perObj);
    	personService.deletePerson(4002);
    	assertEquals(1, i);      
    }
    

}
