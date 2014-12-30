package po;

import enumType.UserJob;

public class RegisterInfoPO implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 632735207793813857L;
	private String name;
	private String password;
	private UserJob role;
	public RegisterInfoPO(String name, String password, UserJob role) {
		this.name = name;
		this.password = password;
		this.role = role;
	}
	public RegisterInfoPO() {
		// TODO Auto-generated constructor stub
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
