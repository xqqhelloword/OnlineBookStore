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
		System.out.println("�˺�:"+user.getUserAccount()+"\n����:"+user.getUserPassword()+"\n���֣�"+user.getUserName()+"\n�绰��"+user.getUserPhone()+"\n��ַ:"+user.getUserAddress());
		//DbMethod db=new DbMethod();
		//ArrayList<Map<String,Object>> arr=db.search("select userId from user where userAccount='"+userAccount+"' and userPassword='"+userPassword+"'",1,"userId");
		//if(arr.size()>0)
		//	return true;
		/***δ�����ݿ�������ӣ���ע�͵�*********/
		return true;
	}

}
