package vo;

import enumType.UserJob;

public class RegisterInfoVO {
	private String name;
	private String password;
	private UserJob job;
	public RegisterInfoVO(String name, String password, UserJob job) {
		super();
		this.name = name;
		this.password = password;
		this.job = job;
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
	public UserJob getJob() {
		return job;
	}
	public void setJob(UserJob job) {
		this.job = job;
	}
}
