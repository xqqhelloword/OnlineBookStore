package action;
import java.util.HashMap;
import java.util.Map;

import service.registerService;
import service.updateUserInfo;
import bean.NewUserBean;
import bean.UserBean;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
public class registerAction extends ActionSupport implements ModelDriven<NewUserBean>{
	private NewUserBean newUserBean=new NewUserBean();
	private Map<String, Object> dataMap;
	public registerAction() {
		// TODO Auto-generated constructor stub
	}
	public NewUserBean getNewUserBean() {
		return newUserBean;
	}
	public void setNewUserBean(NewUserBean newUserBean) {
		this.newUserBean = newUserBean;
	}
	public Map<String, Object> getDataMap() {
		return dataMap;
	}
	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}
	@Override
	public NewUserBean getModel() {
		// TODO Auto-generated method stub
		return newUserBean;
	}
	public String RegisterExcute(){
		if(!new registerService().register(newUserBean)){
			dataMap=new HashMap<String,Object>();
			dataMap.put("RegisterResult", "注册失败");
			System.out.println("return register result:"+dataMap.get("RegisterResult"));
			return SUCCESS;
		}
		dataMap=new HashMap<String,Object>();
		dataMap.put("RegisterResult", "注册成功");
		System.out.println("return register result:"+dataMap.get("RegisterResult"));
		return SUCCESS;
	}
	public String updateExcute(){
		if(!new updateUserInfo().updateUserInfo(newUserBean)){
			dataMap=new HashMap<String,Object>();
			dataMap.put("UpdateResult", "修改失败");
			System.out.println("return update result:"+dataMap.get("UpdateResult"));
			return SUCCESS;
		}
		dataMap=new HashMap<String,Object>();
		dataMap.put("UpdateResult", "修改成功");
		System.out.println("return update result:"+dataMap.get("UpdateResult"));
		return SUCCESS;
	}
}
