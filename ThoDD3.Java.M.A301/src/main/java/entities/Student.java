package entities;

import java.util.List;

public class Student extends Person{
	
	String studentId;
	double theory;
	double practice;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String fullName, String gender, String phone, String email, String studentId, double theory, double practice) {
		super(fullName, gender, phone, email);
		this.studentId = studentId;
		this.theory = theory;
		this.practice = practice;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public double getTheory() {
		return theory;
	}

	public void setTheory(double theory) {
		this.theory = theory;
	}

	public double getPractice() {
		return practice;
	}

	public void setPractice(double practice) {
		this.practice = practice;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", theory=" + theory + ", practice=" + practice + ", fullName="
				+ fullName + ", gender=" + gender + ", phone=" + phone + ", email=" + email + "]" + ", final mark=" + calculateFinalMark();
	}	
	
	public double calculateFinalMark() {
		return (this.theory + this.practice)/2.0;
	}
}
