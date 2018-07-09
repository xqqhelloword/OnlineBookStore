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
	public ArrayList<Map<String,Object>> search(String sql,int attrNum,String... names ) {//String... argsΪ����������,attrNumΪ��ѯ����в�ѯ��������Եĸ���
		// TODO Auto-generated method stub
		ArrayList<Map<String,Object>> objArrayL=new ArrayList<Map<String,Object>>();
		Connection conn=connDB.getConnection();
		Statement ps=null;
		System.out.println("��ѯ���:"+sql);
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
	
	public static void update(String sql, Object... args) {// ʹ�ò��������� Ҳ���ǲ����ĸ����ǲ�ȷ���Ŀ��Դ��ݶ��
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = connDB.getConnection();
			ps = conn.prepareStatement(sql);

			// ��sql �е��βν��и�ֵ
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("\n[sqlException]:"+" "+e.getMessage()+"\n");
		}finally {
			connDB.freeAll(conn, ps, null);
		}

	}
}
