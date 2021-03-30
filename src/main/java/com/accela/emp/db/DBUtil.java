package com.accela.emp.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {
	private static String driverName;
	private static String url;
	private static String dbUserName;
	private static String dbPass;

	private void loadProperties() {
		try (InputStream input = getClass().getClassLoader().getSystemResourceAsStream("config.properties")) {
			Properties prop = new Properties();
			prop.load(input);
			driverName = prop.getProperty("db.driver");
			url = prop.getProperty("db.url");
			dbUserName = prop.getProperty("db.user");
			dbPass = prop.getProperty("db.password");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	protected Connection getDBConnection() {
		Connection con = null;
		loadProperties();
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(url, dbUserName, dbPass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	protected ResultSet getResultsetForQuery(Connection con, String sql) {
		Statement stmt;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	protected int executeQuery(Connection con, PreparedStatement stmt) {
		int updateStr = 0;
		try {
			updateStr = stmt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updateStr;
	}

}
