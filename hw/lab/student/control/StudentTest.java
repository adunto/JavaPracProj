package lab.student.control;
import lab.student.entity.Student;
import lab.student.exception.*;

public class StudentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student kim = new Student("kms0101", "��μ�", "��ǻ�Ͱ���", 3);
		kim.showStudentInfo();
		// 5 �г����� ����
		try {
			kim.setGrade(5);
		} catch(GradeBoundaryOutException e) {
			System.out.println(e.getMessage());
		}
	}

}
