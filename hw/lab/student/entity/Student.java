package lab.student.entity;

import lab.student.exception.GradeBoundaryOutException;

public class Student {
	private String studentId;
	private String name;
	private String major;
	private int grade;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String studentId, String name, String major, int grade) {
		setStudentId(studentId);
		setName(name);
		setMajor(major);
		try {
			setGrade(grade);
		} catch(GradeBoundaryOutException e) {
			System.out.println(e.getMessage());
		}
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getGrade() {
		return grade;
	}

	// grade : 1~4
	public void setGrade(int grade) throws GradeBoundaryOutException {
		if (grade <= 0 || grade > 4) {
			String errMsg = "학년은 1 ~ 4 사이여야 합니다.";
			throw new GradeBoundaryOutException(errMsg);
		}
		this.grade = grade;
	}
	
	public void showStudentInfo() {
		System.out.println(this.name + " / " + this.major + " / " + this.grade + "학년");
	}

}
