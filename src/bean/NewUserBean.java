package bean;

public class NewUserBean {
	private String userAccount;
	private String userPassword;
	private String userName;
	private String userPhone;
	private String userAddress;
	//private String userName;
	public NewUserBean(){
		this.userAccount="账号名";
		this.userPassword="登录密码";
		this.userAddress="收货地址";
		this.userName="用户名";
		this.userPhone="手机号";
 
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
	public String getUserName(){
		return userName;
	}
	public void setUserName(String userName ){
		this.userName=userName;
	}
	public String getUserAddress(){
		return userAddress;
	}
	public void setUserAddress(String userAddress){
		this.userAddress=userAddress;
	}
	public String getUserPhone(){
		return userPhone;
	}
	public void setUserPhone(String userPhone){
		this.userPhone=userPhone;
	}
}
