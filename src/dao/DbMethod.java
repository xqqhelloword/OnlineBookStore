package dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import db.connDB;
import bean.UserBean;

public class DbMethod {
	public ArrayList<Map<String,Object>> search(String sql,int attrNum,String... names ) {//String... argsΪ����������,attrNumΪ��ѯ����в�ѯ��������Եĸ���
		// TODO Auto-generated method stub
		ArrayList<Map<String,Object>> objArrayL=new ArrayList<Map<String,Object>>();
		Connection conn=connDB.getConnection();
		Statement ps=null;
		System.out.println("查询语句:"+sql);
		try{
			ps = conn.createStatement();
		ResultSet rs=ps.executeQuery(sql);
		while(rs.next()){
			Map<String,Object> MapObj=new HashMap<String,Object>();
			int count=0;
			int count1=0;
			while(count<attrNum)
			MapObj.put(names[count1++], rs.getObject(names[count++]).toString());
			objArrayL.add(MapObj);
		}
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("\nsearch Fail--[sqlException]:"+" "+e.getMessage()+"\n");
		}
		for(int i=0;i<objArrayL.size();i++){
			for(int j=0;j<objArrayL.get(i).size();j++){
				System.out.println(names[j]+":"+objArrayL.get(i).get(names[j]).toString()+"   ");
			}
			System.out.print("\n");
		}
			return objArrayL;
		}
}
