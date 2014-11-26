package po;

import enumType.UserJob;

public class UserPO implements java.io.Serializable{
	private long id;
	private String name;
	private String password;
	private UserJob role;
	public UserPO(long id, String name, String password, UserJob role) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.role = role;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserJob getRole() {
		return role;
	}
	public void setRole(UserJob role) {
		this.role = role;
	}
}
