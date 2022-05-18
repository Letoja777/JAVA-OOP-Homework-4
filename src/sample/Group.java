package sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Group {
	private String groupName;

	private List<Student> students = new ArrayList<>();

	public Group(String groupName, List<Student> students) {
		super();
		this.groupName = groupName;
		this.students = students;
	}

	public Group(String groupName) {
		this.groupName = groupName;
	}

	public Group() {
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public int hashCode() {
		return Objects.hash(groupName, students);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Group other = (Group) obj;
		return Objects.equals(groupName, other.groupName) && Objects.equals(students, other.students);
	}

	public boolean checkStudentEquals(Student student) {
		if (student == null) {
			return false;
		}
		for (Student stud : students) {
			student.setGroupName(this.groupName);
			if (stud.equals(student)) {
				return true;
			}
		}
		return false;
	}

	public void addStudent(Student student) throws GroupOverflowException {

			if (!checkStudentEquals(student)) {
				int groupSize = 10;
				if (students.size() < groupSize) {
					students.add(student);
					student.setGroupName(groupName);
					System.out.println(student.getLastName() + " был добавлен в группу "+ student.getGroupName());
				} else {
					throw new GroupOverflowException("Группа уже заполнена!");
				}
			} else {
				System.out.println(student + " уже присутствует в группе!");
			}
	}

	public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
		Student search = null;
		for (Student stud : this.students) {
			if (stud.getLastName().equals(lastName)) {
				System.out.println("Студент " + lastName + " найден в группе!");
				search = stud;
			}
		}
		if (search == null) {
			throw new StudentNotFoundException("Студент " + lastName + " не найден в группе!");
		}
		return search;
	}

	public boolean removeStudentByID(int id) {
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getId() == id) {
				System.out.println("Студент " + students.get(i).getLastName() + students.get(i).getName() + " был удалён из группы.");
				students.remove(i);
				return true;
			}
		}
		return false;
	}

	public void sortStudentsByLastName() {
		Collections.sort(getStudents(),new StudentLastnameComparator());
	}
	
	@Override
	public String toString() {
		return "Group [groupName= " + groupName + ", students= " + students + "]";
	}
}