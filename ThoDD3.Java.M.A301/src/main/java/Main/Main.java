package Main;

import java.util.ArrayList;
import java.util.List;

import entities.Person;
import entities.Student;
import entities.Teacher;
import service.Service;
import validate.Validate;

public class Main {

	public static void main(String[] args) {
		Service service = new Service();
		Validate validate = new Validate();
		int choice;
		List<Person> listPerson = new ArrayList<Person>();
		List<Student> listStudents = new ArrayList<Student>();
		Student student = new Student("tho", "Male", "012345", "dangtho@gmail.com", "25", 8.0, 8.0);
		Student student1 = new Student("long", "Male", "012345", "dangtho@gmail.com", "15", 5.0, 5.0);
		Student student2 = new Student("tung", "Male", "012345", "dangtho@gmail.com", "1", 6.0, 6.0);
		Student student3 = new Student("huy", "Male", "012345", "dangtho@gmail.com", "2", 7.0, 8.0);
		Teacher teacher = new Teacher("long", "Male", "03456", "long@gmail.com", 1000.0, 100.0);
		Teacher teacher2 = new Teacher("long", "Male", "03456", "long@gmail.com", 800.0, 100.0);
		Teacher teacher1 = new Teacher("tuan", "Male", "03456", "tuan@gmail.com", 900.0, 100.0);
		Teacher teacher3 = new Teacher("yen", "Male", "03456", "yen@gmail.com", 1000.0, 300.0);
		listPerson.add(student);
		listPerson.add(student1);
		listPerson.add(student2);
		listPerson.add(student3);
		listPerson.add(teacher);
		listPerson.add(teacher1);
		listPerson.add(teacher2);
		listPerson.add(teacher3);
		listStudents.add(student);
		listStudents.add(student1);
		listStudents.add(student2);
		listStudents.add(student3);
		student.toString();
		do {
			System.out.println("==============Assignment_702============== ");
			System.out.println("1.Add a student.");
			System.out.println("2.Add a teacher.");
			System.out.println("3.Update student.");
			System.out.println("4.Display teacher");
			System.out.println("5.Report");
			System.out.println("6.Exit.");

			choice = Validate.checkInputIntLimit(1, 6);
			switch (choice) {
			case 1:
				service.addStudent(listPerson, listStudents);
				break;
			case 2:
				service.addTeacher(listPerson);
				break;
			case 3:
				String studentID = validate.getString("Input student id need to update: ", false, "empty");
				Student student4 = service.findByStudentId(listPerson, studentID);
				service.updateStudent(student4);
				break;
			case 4:
				for (Person person : listPerson) {
					if (person instanceof Teacher) {
						Teacher object = (Teacher) person;
						if (object.calculateSalary() > 1000) {
							System.out.println(object.toString());
						}
					}
				}
				break;
			case 5:
				for (Person person : listPerson) {
					if (person instanceof Student) {
						Student object = (Student) person;
						if (object.calculateFinalMark() >= 6) {
							System.out.println(object.toString());
						}
					}
				}
				break;
			case 6:
				System.exit(0);
			}
		} while (choice != 7);

	}

}
