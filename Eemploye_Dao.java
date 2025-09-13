package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Eemploye_Dao {
	
	public Connection Connect() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection(
		        "jdbc:mysql://localhost:3306/demo", "root", "Kalyani@123");
		return c;
	}

  
	public void Insertdata(int id, String name, String city) throws Exception {
		Connection c = Connect();
		String query = "INSERT INTO employee VALUES(?,?,?)";
		PreparedStatement stm = c.prepareStatement(query);
		stm.setInt(1, id);
		stm.setString(2, name);
		stm.setString(3, city);
		int row = stm.executeUpdate();
		System.out.println(row + " record inserted");
		c.close();
	}

    
	public void Deletedata(int id) throws Exception {
		Connection c = Connect();
		String query = "DELETE FROM employee WHERE id = ?";
		PreparedStatement stm = c.prepareStatement(query);
		stm.setInt(1, id);
		int row = stm.executeUpdate();
		System.out.println(row + " record deleted");
		c.close();
	}

    
	public void SelectAlldata() throws Exception {
		Connection c = Connect();
		String query = "SELECT * FROM employee";
		PreparedStatement stm = c.prepareStatement(query);
		ResultSet rs = stm.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String city = rs.getString("city");
			System.out.println("ID: " + id + ", Name: " + name + ", City: " + city);
		}
		c.close();
	}

    // ✅ Select one employee by id
	public void SelectData(int id) throws Exception {
		Connection c = Connect();
		String query = "SELECT * FROM employee WHERE id=?";
		PreparedStatement stm = c.prepareStatement(query);
		stm.setInt(1, id);
		ResultSet rs = stm.executeQuery();
		if (rs.next()) {
			System.out.println("ID: " + rs.getInt("id") + 
			                   ", Name: " + rs.getString("name") + 
			                   ", City: " + rs.getString("city"));
		} else {
			System.out.println("No employee found with id " + id);
		}
		c.close();
	}

    
	public void Upadatedata(int id, String name, String city) throws Exception {
		Connection c = Connect();
		String query = "UPDATE employee SET name = ?, city = ? WHERE id = ?";
		PreparedStatement stm = c.prepareStatement(query);
		stm.setString(1, name);
		stm.setString(2, city);
		stm.setInt(3, id);
		int data = stm.executeUpdate();
		System.out.println(data + " record updated");
		c.close();
	}
}
