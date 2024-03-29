package model;

import com.mysql.cj.jdbc.Blob;

public class User {

	private int userid;
	private String username;
	private String password;
	private String fullName;
	private String IC;
	private String phone;
	private String employmentStatus;
	private String employmentSector;
	private String role;

	public User() {

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int id) {
		this.userid = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getIC() {
		return IC;
	}

	public void setIC(String iC) {
		IC = iC;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmploymentStatus() {
		return employmentStatus;
	}

	public void setEmploymentStatus(String employmentStatus) {
		this.employmentStatus = employmentStatus;
	}

	public String getEmploymentSector() {
		return employmentSector;
	}

	public void setEmploymentSector(String employmentSector) {
		this.employmentSector = employmentSector;
	}
}
