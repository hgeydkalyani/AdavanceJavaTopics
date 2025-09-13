package com.service;



import com.dao.Eemploye_Dao;



public class Eemploye_Service {
	 private Eemploye_Dao dao = new Eemploye_Dao();

	    
	    public void addEmployee(int id, String name, String city) {
	        try {
	            if (name == null || name.isEmpty()) {
	                throw new IllegalArgumentException("Name cannot be empty");
	            }
	            dao.Insertdata(id, name, city);
	            System.out.println("Employee added successfully!");
	        } catch (Exception e) {
	            System.out.println("Error adding employee: " + e.getMessage());
	        }
	    }

	    
	    public void removeEmployee(int id) {
	        try {
	            dao.Deletedata(id);
	            System.out.println("Employee deleted successfully!");
	        } catch (Exception e) {
	            System.out.println("Error deleting employee: " + e.getMessage());
	        }
	    }

	  
	    public void findEmployee(int id) {
	        try {
	            dao.SelectData(id);
	        } catch (Exception e) {
	            System.out.println("Error finding employee: " + e.getMessage());
	        }
	    }

	   
	    public void listAllEmployees() {
	        try {
	            dao.SelectAlldata();
	        } catch (Exception e) {
	            System.out.println("Error listing employees: " + e.getMessage());
	        }
	    }

	  
	    public void updateEmployee(int id, String name, String city) {
	        try {
	            dao.Upadatedata(id, name, city);
	            System.out.println("Employee updated successfully!");
	        } catch (Exception e) {
	            System.out.println("Error updating employee: " + e.getMessage());
	        }
	    }
}
	    

  

