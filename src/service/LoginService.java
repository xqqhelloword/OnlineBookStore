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
		System.out.println("账号:"+userAccount+"\n密码:"+userPassword);
		//DbMethod db=new DbMethod();
		//ArrayList<Map<String,Object>> arr=db.search("select userId from user where userAccount='"+userAccount+"' and userPassword='"+userPassword+"'",1,"userId");
		//if(arr.size()>0)
		//	return true;
		/***上面几行注释为查询数据库代码，尚未测试，故注释掉*********/
		return true;
	}

}
