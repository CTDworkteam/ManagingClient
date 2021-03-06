package vo;

import enumType.UserJob;

public class UserVO {
	private long id;
	private String name;
	private String password;
	private UserJob role;
	public UserVO(long id, String name, String password, UserJob role) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.role = role;
	}
	public UserVO() {
		// TODO 自动生成的构造函数存根
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
