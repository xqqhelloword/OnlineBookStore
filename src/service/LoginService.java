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
		System.out.println("�˺�:"+userAccount+"\n����:"+userPassword);
		//DbMethod db=new DbMethod();
		//ArrayList<Map<String,Object>> arr=db.search("select userId from user where userAccount='"+userAccount+"' and userPassword='"+userPassword+"'",1,"userId");
		//if(arr.size()>0)
		//	return true;
		/***���漸��ע��Ϊ��ѯ���ݿ���룬��δ���ԣ���ע�͵�*********/
		return true;
	}

}
