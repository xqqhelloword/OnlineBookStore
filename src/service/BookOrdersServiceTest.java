package service;

import static org.junit.Assert.*;

import org.junit.Test;

import bean.bookorders;
import bean.user;

public class BookOrdersServiceTest {

	@Test
	public void test() {
		user newUserBean=new user();
		bookorders bookorders=new bookorders();
		newUserBean.setIdUser("1");
		BookOrdersService bookOrdersService= new BookOrdersService();
		System.out.println(111);
		//bookOrdersService.getorderlist(newUserBean);
		long startTime=System.nanoTime();   //获取开始时间  
		bookOrdersService.getOrderList(newUserBean);
		//doSomeThing(); //测试的代码段  

		long endTime=System.nanoTime(); //获取结束时间  

		System.out.println("程序运行时间： "+(endTime-startTime)+"ns"); 
		
		System.out.println(newUserBean.getClass());
	}

}
