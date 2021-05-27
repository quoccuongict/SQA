package com.insurrance.model;

public class User {

	private int id;
	private String username;
	private String password;
	private String fullname;
	private String role;
	
	public User() {
		super();
	}

	public User(int id, String username, String password, String fullname, String role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", fullname=" + fullname
				+ ", role=" + role + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof User) {
            User another = (User) obj;
            if (this.id == another.id &&
                this.username.equals(another.username) &&
                this.password.equals(another.password) &&
                this.fullname.equals(another.fullname) &&
                this.role.equals(another.role)) {
                    return true;
            }
        }
        return false;
	}
}
