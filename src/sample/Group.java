package sample;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Group {
	
	private String groupName;
	
	private Student[] students = new Student[10];

	public Group(String groupName, Student[] students) {
		super();
		this.groupName = groupName;
		this.students = students;
	}

	public Group() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Student[] getStudents() {
		return students;
	}

	public void setStudents(Student[] students) {
		this.students = students;
	}

	public void addStudent(Student student) throws GroupOverflowException {
        boolean isFull = false;
        
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
                System.out.println("������� " + students[i].getName() + " �������� � " + groupName);
                isFull = true;
                break;
            }
        }
        if (!isFull) {
            throw new GroupOverflowException("������ �����������");
        }
    }
	
	public Student searchStudentByLastName (String lastName) throws StudentNotFoundException {
		boolean isExist = false;
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null) {
				if (students[i].getLastName().equals(lastName)) {
					System.out.println("������� " + students[i].getLastName() + " ������ � ������");
					isExist = true;
                    return students[i];
				}
			}
		}
		
		if (!isExist) {
            throw new StudentNotFoundException("������� �� ������ � ������");
        }
		return null;
	}
	
	public boolean removeStudentByID (int id) {
		for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                if (students[i].getId() == id) {
                    System.out.println("������� " + students[i].getLastName() + " ����� �� ������");
                    students[i] = null;
                    return true;
                }
            }
        }
        return false;
	}
	
	public void sortStudentsByLastName() {
		Arrays.sort(students, new StudentLastnameComparator());
	}
	
	@Override
	public String toString() {
		return "Group [groupName=" + groupName + ", students=" + Arrays.toString(students) + "]";
	}

}
