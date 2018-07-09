package service;

import java.util.ArrayList;
import java.util.Map;

import dao.DbMethod;

public class getBookList {
	private DbMethod dm;
	public getBookList(){
		this.dm=new DbMethod();
	}
	public ArrayList<Map<String,Object>> getEBookList(){//电子书
		String sql="select * from ebook";
		ArrayList<Map<String,Object>> eBookList=new ArrayList<Map<String,Object>>();
		String[] names={"",""};
		eBookList=dm.search(sql, 5,names );
		return eBookList;
	}
	public ArrayList<Map<String,Object>> getPBookList(){//实体书
		String sql="select * from pbook";
		ArrayList<Map<String,Object>> PBookList=new ArrayList<Map<String,Object>>();
		String[] names={"",""};
		PBookList=dm.search(sql, 5,names );
		return PBookList;
	}
	public ArrayList<Map<String,Object>> getOBookList(){//二手书
		String sql="select * from obook";
		ArrayList<Map<String,Object>> OBookList=new ArrayList<Map<String,Object>>();
		String[] names={"",""};
		OBookList=dm.search(sql, 5,names );
		return OBookList;
	}
	public void closeDM(){
		this.dm.closeConn();
	}
}
