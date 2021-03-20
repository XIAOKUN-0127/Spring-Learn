package com.springioc02.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springioc02.bean.User;
import com.springioc02.biz.AccountBiz;
import com.springioc02.biz.UserBiz;
import com.springioc02.controller.AccountServlet;
import com.springioc02.controller.UserServlet;
import com.springioc02.dao.UserDAO;

/**
 * spring的注解
 * 	1.@Autowired 自动装配
 *  2.@Controller 标识控制层(servlet)
 *  3.@Repository 标识DAO 数据访问层(持久化层)
 *  4.@Service 标识业务层
 *  5.@Component 标识组件
 * spring底层都是@Component ,@Controller等是为了让程序员区别
 * 
 * @Autowired与@Resource的区别:
 * 	javax包的注解，扩展性强；	
 * 	@Autowired只能用于spring框架；
 * 	都是自动装配
 * 注意 ：注解方式注册组件依赖spring-aop包
 * @author admin
 *
 */
public class Test01 {
	ApplicationContext ioc02=new ClassPathXmlApplicationContext("springioc02.xml");
	
	/**
	 * 注解方式将类加入springioc容器，获取spring管理的对象
	 * 默认单例
	 * 默认的对象id为类名首字母小写
	 */
	@Test
	public void test01() {
		AccountServlet accountServlet=(AccountServlet) ioc02.getBean("accountServlet");
		User user=new User();
		user.setUname("uname");
		accountServlet.getMoney(user, 100.10);
	}
	
	/**
	 * 修改默认id
	 * @Controller("newId"),@Service("newId"),@Repository("newId"),括号内直接指定当前类对象id的名称
	 */
	@Test
	public void test02() {
		/**
		 * 
		 */
		//UserDAO userDAO=(UserDAO) ioc02.getBean("udao");
		User user=new User();
		user.setUname("uname");
		//userDAO.login(user);
		//UserBiz userBiz=(UserBiz) ioc02.getBean("ub");
		//userBiz.register(user);
		UserServlet userServlet=(UserServlet) ioc02.getBean("uc");
		userServlet.login(user);
	}
	
	/**
	 * 测试 scope属性,默认为单例singleton;原型prototype
	 */
	@Test
	public void test03() {
		UserServlet userServlet01=(UserServlet) ioc02.getBean("uc");
		UserServlet userServlet02=(UserServlet) ioc02.getBean("uc");
		System.out.println("u1和u2是否为同一个对象:"+(userServlet01==userServlet02));
	}
	
	/**
	 * @Qualifier("newName")  为自动装配指定新的id
	 * @Autowired(required = false) :标识自动装配 是否必须  默认为true
	 */
	@Test
	public void test04() {
		UserServlet userServlet01=(UserServlet) ioc02.getBean("uc");
		User user=new User();
		user.setUname("uname");
		userServlet01.register(user);
	}
}
