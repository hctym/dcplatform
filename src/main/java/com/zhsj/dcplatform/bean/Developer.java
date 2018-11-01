package com.zhsj.dcplatform.bean;

public class Developer {

	private int id;
	private String name;
	private String account;
	private String password;
	private String mobile;
	private String email;
	private String isDelete;
	private String status;
	private int utime;
	private int ctime;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getUtime() {
		return utime;
	}
	public void setUtime(int utime) {
		this.utime = utime;
	}
	public int getCtime() {
		return ctime;
	}
	public void setCtime(int ctime) {
		this.ctime = ctime;
	}
	
	
	@Override
	public String toString() {
		return "Developer [id=" + id + ", name=" + name + ", account=" + account + ", password=" + password
				+ ", mobile=" + mobile + ", email=" + email + ", isDelete=" + isDelete + ", status=" + status
				+ ", utime=" + utime + ", ctime=" + ctime + "]";
	}
	
	
	
}
