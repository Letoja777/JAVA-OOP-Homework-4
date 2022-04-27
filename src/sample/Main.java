package sample;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Group group1 = new Group();
		group1.setGroupName("Первая группа");
		
		Student student1 = new Student("Alexander", "Ledenov", Gender.MALE, 1, "Первая группа");
		Student student2 = new Student("Dmytro", "Korsakov", Gender.MALE, 2, "Первая группа");
		Student student3 = new Student("Kateryna", "Ledenova", Gender.FEMALE, 3, "Первая группа");
		Student student4 = new Student("Irina", "Selvashuk", Gender.FEMALE, 4, "Первая группа");
		Student student5 = new Student("Alevtina", "Korotka", Gender.FEMALE, 5, "Первая группа");
		Student student6 = new Student("Alexander", "Sachenko", Gender.MALE, 6, "Первая группа");
		Student student7 = new Student("Ivan", "Naumenko", Gender.MALE, 7, "Первая группа");
		Student student8 = new Student("Anton", "Ivanov", Gender.MALE, 8, "Первая группа");
		Student student9 = new Student("Nikolay", "Naumenko", Gender.MALE, 9, "Первая группа");
		Student student10 = new Student("Andrey", "Shevchenko", Gender.MALE, 10, "Первая группа");
		Student student11 = new Student("Miroslav", "Kozachenko", Gender.MALE, 10, "Первая группа");
		
		System.out.println(student1.getName() + " "+ student1.getLastName() + ", "+ student2.getGender());
		
		//Добавление в группу 11 студентов
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
		
		//Поиск по фамилии
		try {
            group1.searchStudentByLastName("Kozak");
        } catch (StudentNotFoundException e){
            e.printStackTrace();
        }
		
		//Удалить студента из группы
		System.out.println(group1.toString()); //группа до удаления
        group1.removeStudentByID(1);
        System.out.println(group1.toString()); //группа после удаления
	}

}
