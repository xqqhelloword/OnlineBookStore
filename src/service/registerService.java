package service;

import java.util.ArrayList;
import java.util.Map;

import dao.DbMethod;
import bean.UserBean;
import bean.NewUserBean;
public class registerService {
	public boolean register(NewUserBean user) {
		if(this.registerSearch(user))
		{
		// TODO Auto-generated method stub
		return true;
		}
		return false;
	}

	private boolean registerSearch(NewUserBean user) {
		// TODO Auto-generated method stub
		String userAccount=user.getUserAccount();
		String userPassword=user.getUserPassword();
		System.out.println("用户账号:"+user.getUserAccount()+"\n密码:"+user.getUserPassword()+"\n用户名"+user.getUserName()+"\n电话号码"+user.getUserPhone()+"\n用户地址:"+user.getUserAddress());
		DbMethod db=new DbMethod();
		ArrayList<Map<String,Object>> arr=db.search("select userId from user where userAccount='"+userAccount+"' and userPassword='"+userPassword+"'",1,"userId");
		if(arr.size()>0)
			return true;
		return true;
	}

}
