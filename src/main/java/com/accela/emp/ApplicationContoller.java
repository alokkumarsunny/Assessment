package com.accela.emp;

import java.util.List;
import java.util.Scanner;
import com.accela.emp.model.Person;
import com.accela.emp.service.PersonService;

public class ApplicationContoller {

	public static void main(String[] args) {
		int selectChoose = 0;
		Scanner sc = new Scanner(System.in);
		PersonService personServiceObj = new PersonService();
		while (true) {
			System.out.println("Please select:");
			System.out.println("1. Add Person");
			System.out.println("2. Edit Person");
			System.out.println("3. Delete Person");
			System.out.println("4. Count Number of Persons");
			System.out.println("5. List Persons");
			System.out.println("6. Exist Application");
			System.out.print("Enter value : ");
			String value = sc.nextLine();
			try {
				selectChoose = Integer.parseInt(value);
			} catch (NumberFormatException ex) {
				System.out.println("Invalid selected");
				continue;
			}
			switch (selectChoose) {
			case 1:
				System.out.println("Add person");
				System.out.print("Enter personId: ");
				String personIdStr = sc.nextLine();
				int personId;
				try {
					personId = Integer.parseInt(personIdStr);
				} catch (NumberFormatException ex) {
					System.out.println("Invalid value please try again..");
					break;
				}
				System.out.print("Enter Person First Name: ");
				String personfNameStr = sc.nextLine();
				System.out.print("Enter Person Last Name: ");
				String personlNameStr = sc.nextLine();

				Person person = new Person(personId, personfNameStr, personlNameStr);

				int sucess = personServiceObj.addPerson(person);
				if (sucess == 1) {
					System.out.println("Person added sucessfully !!");
				} else {
					System.out.println("Failed please try again..");
				}
				break;
			case 2:
				System.out.println("Edit person");
				System.out.print("Enter personId: ");
				String editPersonIdStr = sc.nextLine();
				int editPersonId;
				try {
					editPersonId = Integer.parseInt(editPersonIdStr);
				} catch (NumberFormatException ex) {
					System.out.println("Invalid value please try again..");
					break;
				}
				System.out.print("Enter Person First Name: ");
				String editPersonfNameStr = sc.nextLine();
				System.out.print("Enter Person Last Name: ");
				String editPersonlNameStr = sc.nextLine();

				Person editPerson = new Person(editPersonId, editPersonfNameStr, editPersonlNameStr);

				int editSucess = personServiceObj.editPerson(editPerson);
				if (editSucess == 1) {
					System.out.println("Person updated sucessfully !!");
				} else {
					System.out.println("Failed please try again..");
				}
				break;
			case 3:
				System.out.println("Delete person");
				System.out.print("Enter personId: ");
				String deletePersonIdStr = sc.nextLine();
				int deletePersonId;
				try {
					deletePersonId = Integer.parseInt(deletePersonIdStr);
				} catch (NumberFormatException ex) {
					System.out.println("Invalid value please try again..");
					break;
				}
				int deleteSucess = personServiceObj.deletePerson(deletePersonId);
				if (deleteSucess == 1) {
					System.out.println("Person deleted sucessfully !!");
				} else {
					System.out.println("Failed please try again..");
				}

				break;
			case 4:
				System.out.println("Number of Person is : " + personServiceObj.getPersonCount());
				break;
			case 5:
				List<Person> personList = personServiceObj.getAllPerson();
				if (personList.size() == 0) {
					System.out.println("No Record Found.");
				} else {
					System.out.println("List of Person");
					System.out.println("------------------------------------");

					for (Person personObj : personList) {
						System.out.println("(Id:) " + personObj.getId() + " (First Name:) " + personObj.getFirstName()
								+ " (Last Name:) " + personObj.getLastName());
						System.out.println("------------------------------------");
					}
				}
				break;
			case 6:
				System.exit(0);
				sc.close();
				break;
			}
			System.out.println("*******************************************");
		}

	}

}
