package com.oa.pma.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name = "users")
public class UserAccount {
	
	@Id
	@SequenceGenerator (name = "users_seq", sequenceName = "users_seq", allocationSize = 1)
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "users_seq")
	@Column(name ="id")
	private long id;
	
	@Column (name = "username")
	private String userName;
	
	private String nameSurname;
	
	private String email;
	
	private String password;
	
	private boolean enabled = true;
	
	public UserAccount() {
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getNameSurname() {
		return nameSurname;
	}
	
	public void setNameSurname(String nameSurname) {
		this.nameSurname = nameSurname;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
