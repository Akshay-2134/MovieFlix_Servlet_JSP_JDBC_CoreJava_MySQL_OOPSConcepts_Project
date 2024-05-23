package com.jsp.movieflix_servlet_project.dto;

/**
 * @author Akshay Chauhan This is my encapsulation class which will help me for
 *         admin login
 */
public class Admin {
	private int adminId;
	private String adminName;
	private String adminEmail;
	private String adminPassword;
	private long adminPhone;

	public Admin() {
		super();
	}

	public Admin(int adminId, String adminName, String adminEmail, String adminPassword, long adminPhone) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminEmail = adminEmail;
		this.adminPassword = adminPassword;
		this.adminPhone = adminPhone;
	}

	public Admin(String adminEmail, String adminPassword) {
		super();
		this.adminEmail = adminEmail;
		this.adminPassword = adminPassword;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public long getAdminPhone() {
		return adminPhone;
	}

	public void setAdminPhone(long adminPhone) {
		this.adminPhone = adminPhone;
	}

	@Override
	public String toString() {
		return "adminId= " + adminId + " adminName= " + adminName + " adminEmail= " + adminEmail + " adminPassword= "
				+ adminPassword + " adminPhone= " + adminPhone;
	}

}
