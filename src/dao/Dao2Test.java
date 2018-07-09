package dao;

import static org.junit.Assert.*;

import java.sql.SQLException;

import bean.NewUserBean;
import org.junit.Test;

public class Dao2Test {
																//测试用的东西，无用
	@Test
	public void test() {
		Dao2 dao2= new Dao2();
		NewUserBean newUserBean=new NewUserBean();
		newUserBean.setUserAccount("123");
		newUserBean.setUserPassword("456");
		try {
			newUserBean=(NewUserBean)dao2.getObject("bean.NewUserBean", "userAccount", "张三");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print(newUserBean);
		//fail("Not yet implemented");
	}

}
