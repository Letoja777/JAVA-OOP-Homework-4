package sample;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Group group1 = new Group();
		group1.setGroupName("������ ������");
		
		Student student1 = new Student("Alexander", "Ledenov", Gender.MALE, 1, "������ ������");
		Student student2 = new Student("Dmytro", "Korsakov", Gender.MALE, 2, "������ ������");
		Student student3 = new Student("Kateryna", "Ledenova", Gender.FEMALE, 3, "������ ������");
		Student student4 = new Student("Irina", "Selvashuk", Gender.FEMALE, 4, "������ ������");
		Student student5 = new Student("Alevtina", "Korotka", Gender.FEMALE, 5, "������ ������");
		Student student6 = new Student("Alexander", "Sachenko", Gender.MALE, 6, "������ ������");
		Student student7 = new Student("Ivan", "Naumenko", Gender.MALE, 7, "������ ������");
		Student student8 = new Student("Anton", "Ivanov", Gender.MALE, 8, "������ ������");
		Student student9 = new Student("Nikolay", "Naumenko", Gender.MALE, 9, "������ ������");
		Student student10 = new Student("Andrey", "Shevchenko", Gender.MALE, 10, "������ ������");
		Student student11 = new Student("Miroslav", "Kozachenko", Gender.MALE, 10, "������ ������");
		
		System.out.println(student1.getName() + " "+ student1.getLastName() + ", "+ student2.getGender());
		
		//���������� � ������ 11 ���������
		try {
            group1.addStudent(student1);
            group1.addStudent(student2);
            group1.addStudent(student3);
            group1.addStudent(student4);
            group1.addStudent(student5);
            group1.addStudent(student6);
            group1.addStudent(student7);
            group1.addStudent(student8);
            group1.addStudent(student9);
            group1.addStudent(student10);
            group1.addStudent(student11);
         } catch (GroupOverflowException e){
            e.printStackTrace();
        }
		
		//����� �� �������
		try {
            group1.searchStudentByLastName("Kozak");
        } catch (StudentNotFoundException e){
            e.printStackTrace();
        }
		
		//������� �������� �� ������
		System.out.println(group1.toString()); //������ �� ��������
        group1.removeStudentByID(1);
        System.out.println(group1.toString()); //������ ����� ��������
	}

}
