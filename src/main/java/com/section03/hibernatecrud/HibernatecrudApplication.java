package com.section03.hibernatecrud;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.section03.hibernatecrud.dao.studentDao;
import com.section03.hibernatecrud.dao.studentDaoImplementation;
import com.section03.hibernatecrud.entity.student;

@SpringBootApplication
public class HibernatecrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernatecrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(studentDao studentDao) {

		return runner -> {
			// createStudent(studentDao);
			// findStudent(studentDao);

			findAllStudents(studentDao);
		};
	}

	
	private void createStudent(studentDao studentDao) {
		// create the student object
		System.out.println("Creating new student object");
		Scanner scan = new Scanner(System.in);
		System.out.println("enter first name, last name and email");
		String fname = scan.nextLine();
		String lname = scan.nextLine();
		String mail = scan.nextLine();
		student tempStudent = new student(fname, lname, mail);
		scan.close();
		
		// save the student object
		System.out.println("Saving the student....");
		studentDao.save(tempStudent);
		
		// display id of the saved student
		System.out.println("Saved student. Generated id" + tempStudent.getId());
		
	}
	
	private void findStudent(studentDao studentDao) {
		// finding student by id
		System.out.println("finding student with id 2 ");
		student theStudent = studentDao.findStudentbyId(2); // returns an object of student & return null if not found
		// display the student
		if (theStudent == null) {
			System.out.println("Student not found");
		} else
		System.out.println(theStudent.getFirstName());
	}
	
	
	private void findAllStudents(studentDao studentDao) {
		List<student> allstudent = studentDao.findAllStudent();
		System.out.println(allstudent.get(1).getFirstName());// get() is a list method to get the element at the specified index
		
		for(student s : allstudent){

			System.out.println(s);// prints the list of students
		}
	
	}
}
