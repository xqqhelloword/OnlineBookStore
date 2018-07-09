package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import service.getBookList;

import bean.bookListBean;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class bookListAction extends ActionSupport implements ModelDriven<bookListBean> {
	Map<String,ArrayList<Map<String,Object>>> dataMap;
	public bookListAction(){
		dataMap=new HashMap<String, ArrayList<Map<String,Object>>>();
	}
	public Map<String, ArrayList<Map<String, Object>>> getDataMap() {
		return dataMap;
	}
	public void setDataMap(Map<String, ArrayList<Map<String, Object>>> dataMap) {
		this.dataMap = dataMap;
	}
	private bookListBean bl=new bookListBean();
	public bookListBean getBl() {
		return bl;
	}
	public void setBl(bookListBean bl) {
		this.bl = bl;
	}

	public String bookListRs(){
		getBookList gbl=new getBookList();
		System.out.println("client time:"+bl.getTime());
		ArrayList<Map<String,Object>> EBookList=new ArrayList<Map<String,Object>>();
		EBookList=gbl.getEBookList();
		ArrayList<Map<String,Object>> PBookList=new ArrayList<Map<String,Object>>();
		PBookList=gbl.getPBookList();
		ArrayList<Map<String,Object>> OBookList=new ArrayList<Map<String,Object>>();
		OBookList=gbl.getOBookList();
		dataMap.put("EBookList",EBookList);
		dataMap.put("PBookList",PBookList);
		dataMap.put("OBookList",OBookList);
		gbl.closeDM();
		return SUCCESS;
	}
	@Override
	public bookListBean getModel() {
		
		// TODO Auto-generated method stub
		return null;
	}
	
}
