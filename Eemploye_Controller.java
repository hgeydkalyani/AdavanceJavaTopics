package com.controller;

import java.util.Scanner;

import com.service.Eemploye_Service;

public class Eemploye_Controller {

	
		// TODO Auto-generated method stub
		public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        Eemploye_Service service = new Eemploye_Service();

	        while (true) {
	            System.out.println("\n===== Employee Management System =====");
	            System.out.println("1. Add Employee");
	            System.out.println("2. Delete Employee");
	            System.out.println("3. Find Employee by ID");
	            System.out.println("4. List All Employees");
	            System.out.println("5. Update Employee");
	            System.out.println("6. Exit");
	            System.out.print("Enter your choice: ");
	            int choice = sc.nextInt();

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter Employee ID: ");
	                    int id = sc.nextInt();
	                    sc.nextLine(); // consume newline
	                    System.out.print("Enter Employee Name: ");
	                    String name = sc.nextLine();
	                    System.out.print("Enter Employee City: ");
	                    String city = sc.nextLine();
	                    service.addEmployee(id, name, city);
	                    break;

	                case 2:
	                    System.out.print("Enter Employee ID to delete: ");
	                    int deleteId = sc.nextInt();
	                    service.removeEmployee(deleteId);
	                    break;

	                case 3:
	                    System.out.print("Enter Employee ID to search: ");
	                    int searchId = sc.nextInt();
	                    service.findEmployee(searchId);
	                    break;

	                case 4:
	                    service.listAllEmployees();
	                    break;

	                case 5:
	                    System.out.print("Enter Employee ID to update: ");
	                    int updateId = sc.nextInt();
	                    sc.nextLine();
	                    System.out.print("Enter New Name: ");
	                    String newName = sc.nextLine();
	                    System.out.print("Enter New City: ");
	                    String newCity = sc.nextLine();
	                    service.updateEmployee(updateId, newName, newCity);
	                    break;

	                case 6:
	                    System.out.println("Exiting... Thank you!");
	                    sc.close();
	                    System.exit(0);
	                    break;

	                default:
	                    System.out.println("Invalid choice! Please try again.");
	            }
	        }
	}
}
