package dao;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import bean.NewUserBean;
import bean.user;
import bean.Pbook;
import org.junit.Test;

public class Dao2Test {
																//测试用的东西，无用
	@Test
	public void test() {
		Dao2 dao2= new Dao2();
		for (int i = 1; i < 100; i++) {
			/*user newUserBean=new user();
			newUserBean.setUserAccount("张三"+String.valueOf(i));
			newUserBean.setUserPassword("123");
			newUserBean.setUserPhone("123456798");
			newUserBean.setUserAddress("dasda");
			newUserBean.setUserName("da帅哥");		
			newUserBean.setIdUser(String.valueOf(i));*/
			Pbook pbook =  new Pbook();
			pbook.setPbookName("昆虫记"+String.valueOf(i));
			pbook.setPbookWriter("大帅比"+String.valueOf(i));
			pbook.setPbookPrice(String.valueOf(i));
			pbook.setIdPbook(String.valueOf(i+2));
			pbook.setPbookStockNumber(String.valueOf(999));
			pbook.setPbookSoldNumber(String.valueOf(100));
			pbook.setPbookClickTimes(String.valueOf(10));
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
			  
			String sd = sdf.format(new Date().getTime());  
			pbook.setPbookPublishTime(sd);
			dao2.getSaveObjectSql(pbook);
		}
		
		
		//long startTime=System.nanoTime();   //获取开始时间  
		
		//doSomeThing(); //测试的代码段  

		//long endTime=System.nanoTime(); //获取结束时间  

		//System.out.println("程序运行时间： "+(endTime-startTime)+"ns"); 
		
		/*try {
			System.out.print("66666");
			//newUserBean=(user)
					//dao2.deleteObject("bean.user", "UserAccount", "123456");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//System.out.print("7777"+newUserBean.getUserAccount());
		//fail("Not yet implemented");
	}

}
