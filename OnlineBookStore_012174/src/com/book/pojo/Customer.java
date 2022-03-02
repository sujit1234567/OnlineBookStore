package com.book.pojo;

public class Customer {

	private int cid;
	private String fname;
	private String lname;
	private String caddress;
	private String cemail;
	private String contact;
	private String password;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(int cid, String fname, String lname, String caddress, String cemail, String contact,
			String password) {
		super();
		this.cid = cid;
		this.fname = fname;
		this.lname = lname;
		this.caddress = caddress;
		this.cemail = cemail;
		this.contact = contact;
		this.password = password;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getCaddress() {
		return caddress;
	}
	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}
	public String getCemail() {
		return cemail;
	}
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", fname=" + fname + ", lname=" + lname + ", caddress=" + caddress + ", cemail="
				+ cemail + ", contact=" + contact + ", password=" + password + "]";
	}
	
	
	
}
