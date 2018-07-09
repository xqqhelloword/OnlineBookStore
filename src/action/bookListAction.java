package action;

import java.util.ArrayList;
import java.util.Map;

import bean.bookListBean;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class bookListAction extends ActionSupport implements ModelDriven<bookListBean> {
	private ArrayList<ArrayList<Map<String,Object>>> arrL=new ArrayList<ArrayList<Map<String,Object>>>();
	public ArrayList<ArrayList<Map<String, Object>>> getArrL() {
		return arrL;
	}
	public void setArrL(ArrayList<ArrayList<Map<String, Object>>> arrL) {
		this.arrL = arrL;
	}
	private bookListBean bl=new bookListBean();
	public bookListBean getBl() {
		return bl;
	}
	public void setBl(bookListBean bl) {
		this.bl = bl;
	}

	public String bookListRs(){
		System.out.println("client time:"+bl.getTime());
		ArrayList<Map<String,Object>> EBookList=new ArrayList<Map<String,Object>>();
		ArrayList<Map<String,Object>> PBookList=new ArrayList<Map<String,Object>>();
		ArrayList<Map<String,Object>> OBookList=new ArrayList<Map<String,Object>>();
		arrL.add(EBookList);
		arrL.add(PBookList);
		arrL.add(OBookList);
		return SUCCESS;
	}
	@Override
	public bookListBean getModel() {
		
		// TODO Auto-generated method stub
		return null;
	}
	
}
