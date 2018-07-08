package action;

import java.util.HashMap;
import java.util.Map;

import service.LoginService;

import bean.UserBean;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<UserBean> {
	private UserBean user=new UserBean();
	private Map<String, Object> dataMap;//放置一条json格式数据返回前端（告诉前端登录结果）
	public LoginAction(){
		//dataMap.clear();
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
			dataMap=new HashMap<String, Object>();
			dataMap.put("result", "login fail");
		}
		dataMap=new HashMap<String, Object>();
		System.out.print("successLogin\n");
		dataMap.put("result", "login success");
		System.out.println(dataMap.get("result"));
		//登录请求处理，调用下一层service中的login业务
		return SUCCESS;
	}

}
