package sample;
import java.util.Scanner;

public class ScanStudentData {
	
	public Student dataReader() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name");
		String name = sc.nextLine();
		System.out.println("Enter lastname");
		String lastName = sc.nextLine();
		System.out.println("Enter gender");
		Gender gender = Gender.valueOf(sc.nextLine());
		System.out.println("Enter ID");
		int id = sc.nextInt();
		String groupName = sc.nextLine();
		System.out.println("Enter groupname");
		
		Student student = new Student (name, lastName, gender, id, groupName);
		
		return student;
	}
}
