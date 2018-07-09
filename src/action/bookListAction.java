package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.json.JSONUtil;

import service.getBookList;

import bean.Ebook;
import bean.Obook;
import bean.Pbook;
import bean.bookListBean;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class bookListAction extends ActionSupport implements ModelDriven<bookListBean> {
	List<Map<String,Object>> data=new ArrayList<Map<String,Object>>();
	public List<Map<String, Object>> getData() {
		return data;
	}
	public void setData(List<Map<String, Object>> data) {
		this.data = data;
	}
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	Map<String,Object> map=new HashMap<String, Object>();
	public bookListAction(){
		
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
		 //Map<String, Object> map1 = new HashMap<String, Object>();  
		System.out.println("client time:"+bl.getT());
		List<Map<String,Object>> EBookList=new ArrayList<Map<String,Object>>();
		EBookList=gbl.getEBookList();
		List<Map<String,Object>> PBookList=new ArrayList<Map<String,Object>>();
		PBookList=gbl.getPBookList();
		List<Map<String,Object>> OBookList=new ArrayList<Map<String,Object>>();
		OBookList=gbl.getOBookList();
		List<Map<String,Object>> SoldTopList=new ArrayList<Map<String,Object>>();
		SoldTopList=gbl.getTopSoldList();
		map.put("EBookList",EBookList);
		map.put("PBookList",PBookList);
		map.put("OBookList",OBookList);
		map.put("SoldTopList",SoldTopList );
		gbl.closeDM();
			System.out.println("EB长度:"+map.get("PBookList"));
		return SUCCESS;
	}
	@Override
	public bookListBean getModel() {
		
		// TODO Auto-generated method stub
		return this.bl;
	}
	
}
