package action;

import java.util.HashMap;
import java.util.Map;

import service.LoginService;

import bean.UserBean;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<UserBean> {
	private UserBean user;
	private Map<String, Object> dataMap;//����һ��json��ʽ���ݷ���ǰ�ˣ�����ǰ�˵�¼�����
	public LoginAction(){
		//dataMap.clear();
		dataMap=new HashMap<String, Object>();
		user=new UserBean();
	}
	public UserBean getUser() {
		return user;
	}
	public void setUser(UserBean user) {
		this.user = user;
	}
	public Map<String, Object> getDataMap() {
		return dataMap;
	}
	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}
	@Override
	public UserBean getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	public String LoginExcute(){
		boolean isLogin =new LoginService ().login(user);
		if(!isLogin)
		{
			dataMap.put("result", "fail");
			return "ERROR";
		}
		System.out.print("successLogin22222\n");
		dataMap.put("result", "success");
		//��¼������������һ��service�е�loginҵ��
		return "SUCCESS";
	}

}
