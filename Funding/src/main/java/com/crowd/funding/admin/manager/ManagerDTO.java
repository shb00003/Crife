package com.crowd.funding.admin.manager;

public class ManagerDTO {
	
	private String admin_id;
	private String admin_pw;
	private String admin_name;
	private String admin_email;
	private int admin_type;
	
	
	@Override
	public String toString() {
		return "managerDTO [admin_id=" + admin_id + ", admin_pw=" + admin_pw + ", admin_name=" + admin_name
				+ ", admin_email=" + admin_email + ", admin_type=" + admin_type + "]";
	}


	public String getAdmin_id() {
		return admin_id;
	}


	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}


	public String getAdmin_pw() {
		return admin_pw;
	}


	public void setAdmin_pw(String admin_pw) {
		this.admin_pw = admin_pw;
	}


	public String getAdmin_name() {
		return admin_name;
	}


	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}


	public String getAdmin_email() {
		return admin_email;
	}


	public void setAdmin_email(String admin_email) {
		this.admin_email = admin_email;
	}


	public int getAdmin_type() {
		return admin_type;
	}


	public void setAdmin_type(int admin_type) {
		this.admin_type = admin_type;
	}
	
}
