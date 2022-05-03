package sample;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Group group1 = new Group();
		group1.setGroupName("First group");
		
		Student student1 = new Student("Alexander", "Ledenov", Gender.MALE, 1, "First group");
		Student student2 = new Student("Dmytro", "Korsakov", Gender.MALE, 2, "First group");
		Student student3 = new Student("Kateryna", "Ledenova", Gender.FEMALE, 3, "First group");
		Student student4 = new Student("Irina", "Selvashuk", Gender.FEMALE, 4, "First group");
		Student student5 = new Student("Alevtina", "Korotka", Gender.FEMALE, 5, "First group");
		Student student6 = new Student("Alexander", "Sachenko", Gender.MALE, 6, "First group");
		Student student7 = new Student("Ivan", "Naumenko", Gender.MALE, 7, "First group");
		Student student8 = new Student("Anton", "Ivanov", Gender.MALE, 8, "First group");
		Student student9 = new Student("Nikolay", "Naumenko", Gender.MALE, 9, "First group");
		Student student10 = new Student("Andrey", "Antonenko", Gender.MALE, 0, "First group");
		Student student11 = new Student("Miroslav", "Kozachenko", Gender.MALE, 11, "First group");
		
		//add students to a group
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
		
		//search student by lastname
		try {
            group1.searchStudentByLastName("Kozak");
        } catch (StudentNotFoundException e){
            e.printStackTrace();
        }

        System.out.println();
    	
		//sort students by lastname
    	group1.sortStudentsByLastName();
    	System.out.println("Sorted " + group1.toString()); 
    	
    	System.out.println();
    	//delete students by id
    	System.out.println(group1.toString()); 
        group1.removeStudentByID(1);
        System.out.println(group1.toString()); 
        
        //add student with keyboard
        ScanStudentData scan = new ScanStudentData();
        
        System.out.println();
		try {
			group1.addStudent(scan.dataReader());
			group1.addStudent(scan.dataReader());
			System.out.println(group1.toString()); 
		} catch (GroupOverflowException e) {
			e.printStackTrace();
		}
        
		//group to csv
		GroupFileStorage gr = new GroupFileStorage();
		try {
			gr.saveGroupToCSV(group1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println();
		
		//read from csv file
		File file = new File(group1.getGroupName() + ".csv");
		Group group2 = new Group();
		try {
			group2 = gr.loadGroupFromCSV(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
		
		//search file by name
		File search = gr.findFileByGroupName("Test", new File ("C:\\java_oop\\Homework Human"));
		File search2 = gr.findFileByGroupName("First group", new File ("C:\\java_oop\\Homework Human"));

	}
}
