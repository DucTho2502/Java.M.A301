package entities;

public class Teacher extends Person{
	
	
	double basicSalary;
	double subsidy;

	public Teacher() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Teacher(String fullName, String gender, String phone, String email, double basicSalary, double subsidy) {
		super(fullName, gender, phone, email);
		this.basicSalary = basicSalary;
		this.subsidy = subsidy;
	}


	public double getBasicSalary() {
		return basicSalary;
	}


	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}


	public double getSubsidy() {
		return subsidy;
	}


	public void setSubsidy(double subsidy) {
		this.subsidy = subsidy;
	}


	@Override
	public String toString() {
		return "Teacher [basicSalary=" + basicSalary + ", subsidy=" + subsidy + ", fullName=" + fullName + ", gender="
				+ gender + ", phone=" + phone + ", email=" + email + "]";
	}

	public double calculateSalary() {
		return this.basicSalary + this.subsidy;
	}
}
