package service;
import java.util.ArrayList;
import java.util.Map;

import dao.Dao;
import dao.DbMethod;
import dao.GenericityDao;
import bean.UserBean;
import bean.NewUserBean;
public class updateUserInfo {
	public boolean updateUserInfo(NewUserBean user) {
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
		Object[] args={userAccount,userPassword,userName,userPhone,userAddress,userAccount};
		String sql="update user set userAccount='"+userAccount+"',userPassword='"+userPassword+"',userName='"+userName+"',userPhone='"+userPhone+"',userAddress='"+userAddress+"' where userAccount ='"+userAccount+"'";
		boolean isInsert=db.update(sql,args);
		System.out.println("更新语句:"+sql);
		if(isInsert)
			return true;
		return false;
	}
}
