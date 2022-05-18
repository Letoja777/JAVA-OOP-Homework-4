package sample;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GroupFileStorage {
	
	public void saveGroupToCSV(Group gr) throws IOException {

		try (PrintWriter pw = new PrintWriter(new File(gr.getGroupName() + ".csv"))) {
			
			for (Student stud : gr.getStudents()) {
				pw.println(stud.getName() + ";" + stud.getLastName() + ";" + stud.getGender() + ";" + stud.getId() + ";"
						+ stud.getGroupName());
			}
		}
	}
	
	public Group loadGroupFromCSV(File file) throws IOException {
		
		Group group = new Group();
		group.setGroupName(file.getName().substring(0, file.getName().indexOf('.')));
		String str = "";

		try (Scanner sc = new Scanner(file)) {
			while (sc.hasNextLine()) {
				str += sc.nextLine() + System.lineSeparator();
			}
		}

		System.out.println(str);
		System.out.println();
		
//		String[] students = str.split(";");
		String[] students = str.split(System.lineSeparator());
		
		for (int i = 0; i < students.length; i++) {
			String stOne = students[i]; // first string from massive
			String[] st = stOne.split("[;]");

			try {
				Student stud = new Student(st[0], st[1], Gender.valueOf(st[2]), Integer.valueOf(st[3]), 
						file.getName().substring(0, file.getName().indexOf('.')));
				group.addStudent(stud);
			} catch (GroupOverflowException e) {
				e.printStackTrace();
			}
		}
		return group;
	}
	
	
	public File findFileByGroupName(String groupName, File workFolder) {
		File[] listOfFiles = workFolder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile() && listOfFiles[i].getName().equals(groupName + ".csv")) {
				System.out.println("File " + groupName + ".csv was found in folder" + workFolder);
				return listOfFiles[i];
			}
		}
		System.out.println("File " + groupName + ".csv wasn't found in folder " + workFolder);
		return null;
		
	}
}
