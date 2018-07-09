package service;

import java.util.ArrayList;
import java.util.Map;

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
		System.out.println("用户名:"+userAccount+"\n密码:"+userPassword);
		DbMethod db=new DbMethod();
		ArrayList<Map<String,Object>> arr=db.search("select idUser,userName from user where userAccount='"+userAccount+"' and userPassword='"+userPassword+"'",2,"idUser","userName");
		System.out.println("arraySize:"+arr.size());
		db.closeConn();
		if(arr.size()>0)
			return true;
		return false;
	}

}
