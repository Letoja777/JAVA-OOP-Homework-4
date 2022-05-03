package sample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Arrays;
import java.util.Scanner;

public class GroupFileStorage {
	
	//мой вариант
//	public void saveGroupToCSV(Group gr) throws IOException {
//		File file = new File(gr.getGroupName() + ".csv");
//        try (OutputStream os = new FileOutputStream(file)) {
//			byte[] bytes = gr.toString().getBytes();
//			os.write(bytes);
//			} catch (IOException e) {
//			e.printStackTrace();
//			}
//	}
	
	public void saveGroupToCSV(Group gr) throws IOException {

		try (PrintWriter pw = new PrintWriter(new File(gr.getGroupName() + ".csv"))) {
			
			for (int i = 0; i < gr.getStudents().length; i++) {
				if (gr.getStudents()[i] != null) {
					pw.println(gr.getStudents()[i].getName() + ";" + gr.getStudents()[i].getLastName() + ";"
							+ gr.getStudents()[i].getGender() + ";" + gr.getStudents()[i].getId() + ";"
							+ gr.getStudents()[i].getGroupName());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
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
