package sample;
import java.util.Scanner;

public class ScanStudentData {
	
	public Student dataReader() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("������� ���");
		String name = sc.nextLine();
		System.out.println("������� �������");
		String lastName = sc.nextLine();
		System.out.println("������� ���");
		Gender gender = Gender.valueOf(sc.nextLine());
		System.out.println("������� ����� �������");
		int id = sc.nextInt();
		String groupName = sc.nextLine();
		System.out.println("������� ��� ������");
		
		Student student = new Student (name, lastName, gender, id, groupName);
		
		return student;
	}
}
