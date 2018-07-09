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
import bean.Ebook;
import bean.Obook;
import bean.Pbook;
import bean.User;
import bean.UserBean;

public class DbMethod {
	private Connection conn;
	public DbMethod(){
		conn=connDB.getConnection();
	}
	public ArrayList<Map<String,Object>> search(String sql,int attrNum,String... names ) {//String... argsΪ为不定长参数，即有多少个参数不确定,attrNum为查询语句中属性个数
		// TODO Auto-generated method stub
		ResultSet rs = null;
		ArrayList<Map<String,Object>> objArrayL=new ArrayList<Map<String,Object>>();
		Statement ps=null;
		System.out.println("查询语句:"+sql);
		try{
			ps = conn.createStatement();
		 rs=ps.executeQuery(sql);
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
		}finally{
			connDB.frees( ps, rs);
		}
		for(int i=0;i<objArrayL.size();i++){
			for(int j=0;j<objArrayL.get(i).size();j++){
				System.out.println(names[j]+":"+objArrayL.get(i).get(names[j]).toString()+"   ");
			}
			System.out.print("\n");
		}
			return objArrayL;
		}
	public ArrayList<Pbook> searchPbook(){
			ArrayList<Pbook> objArrayL=new ArrayList<Pbook>();
			ResultSet rs = null;
			Statement ps=null;
			String sql="select * from pbook ";
			System.out.println("searchPook查询语句:"+sql);
			try{
				ps = conn.createStatement();
			 rs=ps.executeQuery(sql);
			while(rs.next()){
				Pbook pb=new Pbook();
				pb.setIdPbook(rs.getString("idPbook"));
				pb.setPbookAbstract(rs.getString("PbookAbstract"));
				pb.setPbookClickTimes(rs.getString("PbookClickTimes"));
				pb.setPbookName(rs.getString("PbookName"));
				pb.setPbookPictureUrl(rs.getString("PbookPictureUrl"));
				pb.setPbookPrice(rs.getString("PbookPrice"));
				pb.setPbookPublisher(rs.getString("PbookPublisher"));
				pb.setPbookPublishTime(rs.getString("PbookPublishTime"));
				pb.setPbookSoldNumber(rs.getString("PbookSoldNumber"));
				pb.setPbookStockNumber(rs.getString("PbookStockNumber"));
				pb.setPbookWriter(rs.getString("PbookWriter"));
				objArrayL.add(pb);
			}
			}catch(SQLException e){
				e.printStackTrace();
				System.out.println("\nsearch pbook Fail--[sqlException]:"+" "+e.getMessage()+"\n");
				
			}finally{
				connDB.frees( ps, rs);
			}	
			
			return objArrayL;
	}
	public ArrayList<Ebook> searchebook(){
		ArrayList<Ebook> objArrayL=new ArrayList<Ebook>();
		ResultSet rs = null;
		Statement ps=null;
		String sql="select * from ebook ";
		System.out.println("searcheook查询语句:"+sql);
		try{
			ps = conn.createStatement();
		 rs=ps.executeQuery(sql);
		while(rs.next()){
			Ebook pb=new Ebook();
			pb.setIdebook(rs.getString("idebook"));
			pb.setEbookAbstract(rs.getString("ebookAbstract"));
			pb.setEbookClickTimes(rs.getString("ebookClickTimes"));
			pb.setEbookPictureUrl(rs.getString("ebookPictureUrl"));
			pb.setEbookPrice(rs.getString("ebookPrice"));
			pb.setEbookSoldNumber(rs.getString("ebookSoldNumber"));
			pb.setEbookWriter(rs.getString("ebookWriter"));
			pb.setEbookNameS(rs.getString("ebookName"));
			objArrayL.add(pb);
		}
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("\nsearchebook Fail--[sqlException]:"+" "+e.getMessage()+"\n");
			
		}finally{
			connDB.frees( ps, rs);
		}	
		return objArrayL;
}
	public ArrayList<Obook> searchobook(){
		ArrayList<Obook> objArrayL=new ArrayList<Obook>();
		ResultSet rs = null;
		Statement ps=null;
		String sql="select * from obook ";
		System.out.println("searchObook查询语句:"+sql);
		try{
			ps = conn.createStatement();
		 rs=ps.executeQuery(sql);
		while(rs.next()){
			Obook pb=new Obook();
			pb.setIdobook(rs.getString("idobook"));
			pb.setObookAbstract(rs.getString("obookAbstract"));
			pb.setObookClickTimes(rs.getString("obookClickTimes"));
			pb.setObookName(rs.getString("obookName"));
			pb.setObookPictureUrl(rs.getString("obookPictureUrl"));
			pb.setObookPrice(rs.getString("obookPrice"));
			pb.setObookPublisher(rs.getString("obookPublisher"));
			pb.setObookPublishTime(rs.getString("obookPublishTime"));
			pb.setObookSoldNumber(rs.getString("obookSoldNumber"));
			pb.setObookStockNumber(rs.getString("obookStockNumber"));
			pb.setObookWriter(rs.getString("obookWriter"));
			objArrayL.add(pb);
		}
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("\nsearchobook Fail--[sqlException]:"+" "+e.getMessage()+"\n");
			
		}finally{
			connDB.frees( ps, rs);
		}	
		return objArrayL;
}
	public ArrayList<Pbook> searchTopList() {
		ArrayList<Pbook> topList=new ArrayList<Pbook>();
		ResultSet rs = null;
		Statement ps=null;
		String sql="select * from pbook order by PbookSoldNumber desc limit 0,2";
		System.out.println("searchPook查询语句:"+sql);
		try{
			ps = conn.createStatement();
		 rs=ps.executeQuery(sql);
		while(rs.next()){
			Pbook pb=new Pbook();
			pb.setIdPbook(rs.getString("idPbook"));
			pb.setPbookAbstract(rs.getString("PbookAbstract"));
			pb.setPbookClickTimes(rs.getString("PbookClickTimes"));
			pb.setPbookName(rs.getString("PbookName"));
			pb.setPbookPictureUrl(rs.getString("PbookPictureUrl"));
			pb.setPbookPrice(rs.getString("PbookPrice"));
			pb.setPbookPublisher(rs.getString("PbookPublisher"));
			pb.setPbookPublishTime(rs.getString("PbookPublishTime"));
			pb.setPbookSoldNumber(rs.getString("PbookSoldNumber"));
			pb.setPbookStockNumber(rs.getString("PbookStockNumber"));
			pb.setPbookWriter(rs.getString("PbookWriter"));
			topList.add(pb);
		}
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("\nsearch pbook Fail--[sqlException]:"+" "+e.getMessage()+"\n");
			
		}finally{
			connDB.frees( ps, rs);
		}	
		return topList;

		// TODO Auto-generated method stub
	}
	public  boolean insert(String sql, Object... args) {
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
			System.out.println("\n[insertsqlException]:"+" "+e.getMessage()+"\n");
			return false;
		}finally {
			connDB.frees( ps, null);
		}
		return false;

	}
	public  boolean update(String sql, Object... args) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = connDB.getConnection();
			ps = conn.prepareStatement(sql);
//			for (int i = 0; i < args.length; i++) {
//				ps.setObject(i + 1, args[i]);
//			}
			if(ps.executeUpdate()==1)
				return true;	
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("\n[updatesqlException]:"+" "+e.getMessage()+"\n");
			return false;
		}finally {
			connDB.frees( ps, null);
		}
		return false;

	}
	public void closeConn() {
		try {
			if(!this.conn.isClosed()){
				this.conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
