package in.ineuron.controller;

import java.util.Scanner;

import in.ineuron.dto.Student;
import in.ineuron.service.IStudentService;
import in.ineuron.serviceFactory.StudentServiceFactory;

public class TestApp {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		while(true) {
		System.out.println();
		System.out.println("enter 1 for creating record ");
		System.out.println("enter 2 for reading  record ");
		System.out.println("enter 3 for updating record ");
		System.out.println("enter 4 for deleting record ");
		System.out.println("enter 5 for exit ");
		String option = scan.next();
		switch(option)
		{
		case "1":
		insertOperation(); break;
		case "2":
		selectOperation(); break;
		case "3":
		updateOperation(); break;
		case "4":
		deleteOperation(); break;
		case "5": 
		System.out.println("******* Thanks for using the application *****");
		System.exit(0);
		default :
		System.out.println("invalid option try again with valid options ");
		}
		}
		
	}
	
	public static void insertOperation()
	{
		IStudentService studentService = StudentServiceFactory.getStudentService();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Student Id :: ");
		int id = scan.nextInt();
		
		System.out.println("Enter Student Name :: ");
		String name = scan.next();
		
		System.out.println("Enter Student Age :: ");
		int age = scan.nextInt();
		
		System.out.println("Enter Student Address :: ");
		String address = scan.next();
		
		
		String status = studentService.addStudent(id,name,age,address);
	    if(status.equals("success"))
	    {
	    	System.out.println("Record Insertion Success");	
	    }
	    else
	    {
	    	System.out.println("Record Insertion Failed");
	    }
	    	
		
	}
	
	public static void selectOperation()
	{
		IStudentService studentService = StudentServiceFactory.getStudentService();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Student id :: ");
		int id = scan.nextInt();
		
		 Student student = studentService.searchStudent(id);
		 
		 if (student != null) {
			System.out.println(student);
			System.out.println("Id\tName\tage\tAddress");
			System.out.println(student.getId()+"\t"+student.getName()+"\t"+student.getAge()+"\t"+student.getAddress());
			}
			else {
			System.out.println("Record not found for the given Id :: " +id);
			}
		}
		
		public static void updateOperation()
		{
			IStudentService studentService = StudentServiceFactory.getStudentService();
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter Student id :: ");
			int id = scan.nextInt();
			Student student = studentService.searchStudent(id);
			if (student != null) {
				Student newStudent = new Student();
				
				newStudent.setId(id);
				
				System.out.println("Old Student Name is " + student.getName() + " Enter the new name :: ");
				String newName = scan.next();
				if(newName.equals("") || newName == "")
				{
					newStudent.setName(student.getName());
				}
				else
				{
					newStudent.setName(newName);
				}
				
				System.out.println("Old Student Age is " + student.getAge() + " Enter the new Age :: ");
				String newAge = scan.next();
				if(newAge.equals("") || newAge == "")
				{
					newStudent.setAge(student.getAge());
				}
				else
				{
					newStudent.setAge(Integer.parseInt(newAge));
				}
				
				System.out.println("Old Student Address is " + student.getAddress() + " Enter the new Address :: ");
				String newAddress = scan.next();
				if(newAddress.equals("") || newAddress == "")
				{
					newStudent.setAddress(student.getAddress());
				}
				else
				{
					newStudent.setAddress(newAddress);
				}
				
				String msg = studentService.updateStudent(newStudent);
				
				if(msg.equals("success"))
				{
					System.out.println("Record updated Successfully");
				}
				else
				{
					System.out.println("Record updation Failed");
				}
				
			}
			else {
		    	System.out.println("Student record is not available for the given id " + id + "for updation");
		    }
			
		}
		
		public static void deleteOperation()
		{
			IStudentService studentService = StudentServiceFactory.getStudentService();
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter Student id  :: ");
			int id = scan.nextInt();
			String status = studentService.deleteStudent(id);
			if(status.equals("success"))
			{
				System.out.println("Record Deleted Successfully");
			}
			else {
				System.out.println("Reord Deletion Failed");
			}
			
			
			
		}
		
	}


