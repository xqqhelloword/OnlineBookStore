package service;

import dao.DbMethod;
import bean.UserBean;

public class LoginService {

	public boolean login(UserBean user) {
		if(this.LoginSearch(user))
		{
		// TODO Auto-generated method stub
		return true;
		}
		return false;
	}

	private boolean LoginSearch(UserBean user) {
		// TODO Auto-generated method stub
		String userAccount=user.getUserAccount();
		String userPassword=user.getUserPassword();
		System.out.println("’À∫≈:"+userAccount+"\n√‹¬Î:"+userPassword);
		DbMethod db=new DbMethod();
		boolean result=db.search("select * from user where userAccount='"+userAccount+"' and userPassword='"+userPassword+"'");
		if(result)
			return true;
		return false;
	}

}
