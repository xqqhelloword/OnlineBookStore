package service;

import static org.hamcrest.CoreMatchers.nullValue;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.bookorders;
import bean.user;
import dao.Dao2;

public class BookOrdersService {
	private Dao2 dao2;
	private bookorders bookorders;
	public BookOrdersService() {
		//super();
		this.dao2 = new Dao2();
		this.bookorders=null;
	}
	public ArrayList<Map<String,Object>> getorderlist(user user){
		System.out.println(2222);
		try {
			bookorders=(bookorders)dao2.getObject("bean.bookorders", "idUser", user.getIdUser());
			System.out.println(333);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String,Object> MapObj=new HashMap<String,Object>();
		MapObj.put("order", bookorders);
		ArrayList<Map<String,Object>> arrayList = new ArrayList<Map<String,Object>>();
		arrayList.add(MapObj);
		//System.out.println(bookorders.getBookName());
		bookorders order=(bookorders)arrayList.get(0).get("order");
		System.out.println(order.getBookName());
		return arrayList;
	}
	public ArrayList<Map<String,Object>> getOrderList(user user){
		System.out.println(2222);
		List<Object> list = new ArrayList<Object>();
		try {
			list=dao2.getObjectList("bean.bookorders", "idUser", user.getIdUser());
			System.out.println(333);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String,Object> MapObj=new HashMap<String,Object>();
		MapObj.put("order", list);
		ArrayList<Map<String,Object>> arrayList = new ArrayList<Map<String,Object>>();
		arrayList.add(MapObj);
		//System.out.println(bookorders.getBookName());
		List<Object> list2=(List<Object>)arrayList.get(0).get("order");
		bookorders order=(bookorders)list2.get(1);
		System.out.println(arrayList.get(0));
		System.out.println("测试输出："+order.getBookName());
		return arrayList;
	}
}
