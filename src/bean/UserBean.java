package bean;

public class UserBean {
	private String userAccount;
	private String userPassword;
	//private String userName;
	public UserBean(){
		this.userAccount="��ʼ��";
		this.userPassword="��ʼ��";
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
}
