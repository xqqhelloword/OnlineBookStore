package service;

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
		System.out.println("账号:"+user.getUserAccount()+"\n密码:"+user.getUserPassword()+"\n名字："+user.getUserName()+"\n电话："+user.getUserPhone()+"\n地址:"+user.getUserAddress());
		//DbMethod db=new DbMethod();
		//ArrayList<Map<String,Object>> arr=db.search("select userId from user where userAccount='"+userAccount+"' and userPassword='"+userPassword+"'",1,"userId");
		//if(arr.size()>0)
		//	return true;
		/***未与数据库完成连接，故注释掉*********/
		return true;
	}

}
