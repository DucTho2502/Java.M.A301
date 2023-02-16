package service;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import entities.Person;
import entities.Student;
import entities.Teacher;
import validate.Validate;

public class Service {
	
	public static Scanner sc = new Scanner(System.in);
	
	public Validate validate = new Validate();
	
	public void addStudent(List<Person> listPersons, List<Student> listStudents) {
		String name = validate.getString("Input name: ", false, "empty");
		String gender = validate.getString("Input gender(M/F): ", false, "empty");
		String phone = validate.getString("Input phone number: ", false, "empty");
		String email = validate.inputEmail();
		String id = validate.getString("Input student ID : ", false, "empty");
		double theory = validate.checkDouble("Enter theory: ");
		double practice = validate.checkDouble("Enter pratice: ");
		
		Student student = new Student(name, gender, phone, email, id, theory, practice);
		listPersons.add(student);
		listStudents.add(student);
	}
	
	public void addTeacher(List<Person> listPersons) {
		String name = validate.getString("Input name: ", false, "empty");
		String gender = validate.getString("Input gender(M/F): ", false, "empty");
		String phone = validate.getString("Input phone number: ", false, "empty");
		String email = validate.inputEmail();
		double basicSalary = validate.checkDouble("Enter basic salary: ");
		double subsidy = validate.checkDouble("Enter subsidy: ");
		
		Teacher teacher = new Teacher(name, gender, phone, email, basicSalary, subsidy);
		listPersons.add(teacher);
	}
	

	public static Student findByStudentId(List<Person> persons, String studentId) {
        for (Person person : persons) {
            if (person instanceof Student) {
                Student student = (Student) person;
                if (student.getStudentId().equalsIgnoreCase(studentId)) {
                    return student;
                }
            }
        }
        System.out.println("Student ID not found!");
        return null;
    }
	
	public void updateStudent(Student student) {
		String name = validate.getString("Input name: ", false, "empty");
		String gender = validate.getString("Input gender(M/F): ", false, "empty");
		String phone = validate.getString("Input phone number: ", false, "empty");
		String email = validate.inputEmail();
		double theory = validate.checkDouble("Enter theory: ");
		double practice = validate.checkDouble("Enter pratice: ");
		
		student.setFullName(name);
		student.setGender(gender);
		student.setPhone(phone);
		student.setEmail(email);
		student.setTheory(theory);
		student.setPractice(practice);
		
		System.out.println("Update successfully.");
	}
	
	
}
