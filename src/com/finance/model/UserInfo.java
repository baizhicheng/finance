package com.finance.model;

import java.sql.Date;
import java.lang.Double;

public class UserInfo {
	
	private Integer id;
	private String uname;
	private String psd;
	private String account;
	private Date birth;
	private String sex;
	private String address;
	private String phone;
	private String idcard;
	private Double balance;
	
	
/*	public UserInfo(int id,String uname,String psd,String account,Date birth,String sex,String address,String phone,String idcard,Double balance){
		this.id=id;
		this.uname = uname;
		this.psd = psd;
		this.account = account;
		this.birth = birth;
		this.sex = sex;
		this.address = address;
		this.phone = phone;
		this.idcard = idcard;
		this.balance = balance;
	}*/
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPsd() {
		return psd;
	}
	public void setPsd(String psd) {
		this.psd = psd;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
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
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}


}
