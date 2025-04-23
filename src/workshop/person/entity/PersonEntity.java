package workshop.person.entity;

public class PersonEntity {

	private String name;
	private char gender;
	private String ssn; // 주민등록번호
	private String address;
	private String phone;
	
	public PersonEntity() {
	}

	public PersonEntity(String name, String ssn, String address, String phone) {
//		this.name = name;
//		this.address = address;
//		this.phone = phone;
		
		setName(name);
		setSsn(ssn);
		setAddress(address);
		setPhone(phone);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
		
		// 9910291234567
		char sixthChar = ssn.charAt(6);
		if (sixthChar == '1' || sixthChar == '3') {
			this.gender = '남';
		}
		else if (sixthChar == '2' || sixthChar == '4') {
			this.gender = '여';
		}
		
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
