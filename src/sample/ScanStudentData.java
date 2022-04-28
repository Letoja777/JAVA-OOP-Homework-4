package sample;
import java.util.Scanner;

public class ScanStudentData {
	
	public Student dataReader() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("¬ведите им€");
		String name = sc.nextLine();
		System.out.println("¬ведите фамилию");
		String lastName = sc.nextLine();
		System.out.println("¬ведите пол");
		Gender gender = Gender.valueOf(sc.nextLine());
		System.out.println("¬ведите номер зачЄтки");
		int id = sc.nextInt();
		String groupName = sc.nextLine();
		System.out.println("¬ведите им€ группы");
		
		Student student = new Student (name, lastName, gender, id, groupName);
		
		return student;
	}
}
