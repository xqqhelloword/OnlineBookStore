package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import bean.Ebook;
import bean.Obook;
import bean.Pbook;

import dao.DbMethod;

public class getBookList {
	private DbMethod dm;
	public getBookList(){
		this.dm=new DbMethod();
	}
	public ArrayList<Map<String,Object>> getEBookList(){//电子书
		ArrayList<Map<String,Object>> eBookList=new ArrayList<Map<String,Object>>();
		ArrayList<Ebook> eb=dm.searchebook();
		for(int i=0;i<eb.size();i++){
			eBookList.add(this.ClassToMap(eb.get(i)));
		}
		return eBookList;
	}
	public ArrayList<Map<String,Object>> getPBookList(){//实体书
		ArrayList<Map<String,Object>> pBookList=new ArrayList<Map<String,Object>>();
		ArrayList<Pbook> pb=dm.searchPbook();
		for(int i=0;i<pb.size();i++){
			pBookList.add(this.ClassToMap(pb.get(i)));
		}
		return pBookList;
	}
	public ArrayList<Map<String,Object>> getOBookList(){//二手书
		ArrayList<Map<String,Object>> OBookList=new ArrayList<Map<String,Object>>();
		ArrayList<Obook> ob=dm.searchobook();
		for(int i=0;i<ob.size();i++){
			OBookList.add(this.ClassToMap(ob.get(i)));
		}
		return OBookList;
	}
	public ArrayList<Map<String,Object>> getTopSoldList(){
		ArrayList<Map<String,Object>> topSoldList=new ArrayList<Map<String,Object>>();
		ArrayList<Pbook> pb=dm.searchTopList();//设定为取热销前10，目前数据库没那么多数据，只取了前2条
		for(int i=0;i<pb.size();i++){
			topSoldList.add(this.ClassToMap(pb.get(i)));
		}
		return topSoldList;
	}
	public void closeDM(){
		this.dm.closeConn();
	}
	public Map<String,Object> ClassToMap(Obook ob){
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("idobook", ob.getIdobook());
			map.put("obookAbstract", ob.getObookAbstract());
			map.put("obookClickTimes", ob.getObookClickTimes());
			map.put("obookName", ob.getObookName());
			map.put("obookPictureUrl", ob.getObookPictureUrl());
			map.put("obookPrice", ob.getObookPrice());
			map.put("obookPublisher", ob.getObookPublisher());
			map.put("obookSoldNumber", ob.getObookSoldNumber());
			map.put("obookPublishTime", ob.getObookPublishTime());
			map.put("obookStockNumber", ob.getObookStockNumber());
			map.put("obookWriter", ob.getObookWriter());
			return map;
		
	}
	public Map<String,Object> ClassToMap(Pbook ob){
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("idPbook", ob.getIdPbook());
		map.put("PbookAbstract", ob.getPbookAbstract());
		map.put("PbookClickTimes", ob.getPbookClickTimes());
		map.put("PbookName", ob.getPbookName());
		map.put("PbookPictureUrl", ob.getPbookPictureUrl());
		map.put("PbookPrice", ob.getPbookPrice());
		map.put("PbookPublisher", ob.getPbookPublisher());
		map.put("PbookSoldNumber", ob.getPbookSoldNumber());
		map.put("PbookPublishTime", ob.getPbookPublishTime());
		map.put("PbookStockNumber", ob.getPbookStockNumber());
		map.put("PbookWriter", ob.getPbookWriter());
		return map;
}
	public Map<String,Object> ClassToMap(Ebook ob){
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("idebook", ob.getIdebook());
		map.put("ebookAbstract", ob.getEbookAbstract());
		map.put("ebookClickTimes", ob.getEbookClickTimes());
		map.put("ebookPictureUrl", ob.getEbookPictureUrl());
		map.put("ebookPrice", ob.getEbookPrice());
		map.put("ebookSoldNumber", ob.getEbookSoldNumber());
		map.put("ebookWriter", ob.getEbookWriter());
		map.put("ebookName", ob.getEbookNameS());
		return map;
}
}
