package sample;

public class Student extends Human {
	
	private int id; 
	private String groupName; 
	
	public Student(String name, String lastname, Gender gender, int id, String groupName) {
		super(name, lastname, gender);
		this.id = id;
		this.groupName = groupName;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + " , name=" + getName() + " , lastname=" + getLastName() + "]";
	}
}
