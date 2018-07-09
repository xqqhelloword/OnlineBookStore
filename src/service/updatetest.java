package service;
import java.util.ArrayList;
import java.util.Map;

import dao.DbMethod;
import bean.UserBean;
import bean.NewUserBean;
public class updatetest {
	public boolean updatetest(NewUserBean user) {
		if(this.updatetestSearch(user))
		{
		// TODO Auto-generated method stub
		return true;
		}
		return false;
	}

	private boolean updatetestSearch(NewUserBean user) {
		// TODO Auto-generated method stub
		String userAccount=user.getUserAccount();
		String userPassword=user.getUserPassword();
		String userName=user.getUserName();
		String userPhone=user.getUserPhone();
		String userAddress=user.getUserAddress();
		System.out.println("用户账号:"+userAccount+"\n密码:"+userPassword+"\n用户名:"+userName+"\n电话号码:"+userPhone+"\n用户地址:"+userAddress);
		DbMethod db=new DbMethod();
		Object[] args={userAccount,userPassword,userName,userPhone,userAddress};
		String sql="update user set userAccount=?,userPassword=?,userName=?,userPhone=?,userAddress=? where user Account =?";
		boolean isInsert=db.update(sql,args);
		if(isInsert)
			return true;
		return false;
	}
}
