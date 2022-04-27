package sample;

public class Human {
	private String name;
	private String lastname;
	private Gender gender;
	
	public Human(String name, String lastname, Gender gender) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.gender = gender;
	}

	public Human() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastname;
	}

	public void setLastName(String lastname) {
		this.lastname = lastname;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Human [name=" + name + ", lastname=" + lastname + ", gender=" + gender + "]";
	}
	
	
	
	
}
