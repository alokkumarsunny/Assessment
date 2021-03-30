package com.accela.emp.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.accela.emp.model.Person;

public class PersonDao extends DBUtil {

	public int getPersonCount() {
		int count = 0;
		try {
			Connection con = getDBConnection();
			ResultSet rs = getResultsetForQuery(con, "select count(*) as count from tb_person");
			if (rs.next()) {
				count = rs.getInt("count");
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public List<Person> getPersonList() {
		List<Person> personList = new ArrayList<Person>();
		Person person = null;
		try {
			Connection con = getDBConnection();
			ResultSet rs = getResultsetForQuery(con, "SELECT * FROM tb_person");
			while (rs.next()) {
				person = new Person(rs.getInt("Id"), rs.getString("FirstName"), rs.getString("LastName"));
				personList.add(person);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return personList;
	}

	public int addPerson(Person person) {
		Connection con = getDBConnection();
		PreparedStatement stmt = null;
		int value = 0;
		try {
			stmt = con.prepareStatement("INSERT INTO tb_person VALUE(?,?,?)");
			stmt.setInt(1, person.getId());
			stmt.setString(2, person.getFirstName());
			stmt.setString(3, person.getLastName());
			value = executeQuery(con, stmt);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return value;
	}

	public int editPerson(Person person) {
		Connection con = getDBConnection();
		PreparedStatement stmt = null;
		int value = 0;
		try {
			stmt = con.prepareStatement("UPDATE tb_person SET FirstName = ? , LastName = ? WHERE Id = ? ");
			stmt.setString(1, person.getFirstName());
			stmt.setString(2, person.getLastName());
			stmt.setInt(3, person.getId());
			value = executeQuery(con, stmt);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return value;
	}

	public int deletePerson(int personId) {
		Connection con = getDBConnection();
		PreparedStatement stmt = null;
		int value = 0;
		try {
			stmt = con.prepareStatement("DELETE FROM tb_person WHERE id = ? ");
			stmt.setInt(1, personId);
			value = executeQuery(con, stmt);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return value;
	}

}
