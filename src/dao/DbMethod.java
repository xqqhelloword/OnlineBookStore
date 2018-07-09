package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import db.connDB;
import bean.UserBean;

public class DbMethod {
	public ArrayList<Map<String,Object>> search(String sql,int attrNum,String... names ) {//String... argsΪ为不定长参数，即有多少个参数不确定,attrNum为查询语句中属性个数
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
			System.out.println("\n Fail--[sqlException]:"+" "+e.getMessage()+"\n");
		}
		for(int i=0;i<objArrayL.size();i++){
			for(int j=0;j<objArrayL.get(i).size();j++){
				System.out.println(names[j]+":"+objArrayL.get(i).get(names[j]).toString()+"   ");
			}
			System.out.print("\n");
		}
			return objArrayL;
		}
	
	public  boolean insert(String sql, Object... args) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = connDB.getConnection();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}
			if(ps.executeUpdate()==1)
				return true;	
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("\n[sqlException]:"+" "+e.getMessage()+"\n");
			return false;
		}finally {
			connDB.freeAll(conn, ps, null);
		}
		return false;

	}
	public  boolean update(String sql, Object... args) {
		/*Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = connDB.getConnection();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}
			if(ps.executeUpdate()==1)
				return true;	
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("\n[sqlException]:"+" "+e.getMessage()+"\n");
			return false;
		}finally {
			connDB.freeAll(conn, ps, null);
		}*/
		return false;

	}
}
