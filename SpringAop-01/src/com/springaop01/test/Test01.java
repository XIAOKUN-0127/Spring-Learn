package com.springaop01.test;

import org.junit.Test;

import com.springaop01.impl.MyMathCalucater;
import com.springaop01.inter.Calucater;
import com.springaop01.poxy.CalureterPoxy;
/**
 * AOP：基于oop,oop的补充
 * OOP:面向对象编程
 * 日志记录
 *   1、手动将代码写入方法前后 增加耦合(系统辅助功能和业务逻辑功能的耦合)
 *   2、将代码封装到logUtil类,同样是手动调用且方法名无法传参 ，问题依然存在。
 * @author admin
 *
 */
public class Test01 {
	@Test
	public void test01() {
		Calucater calucater=new MyMathCalucater();
		calucater.add(2, 3);
		calucater.mul(12, 2);
	}
	
	@Test
	public void test02() {
		//目标对象
		Calucater calucater=new MyMathCalucater();
		//生成代理对象
		Calucater proxy=CalureterPoxy.getPoxyInnstance(calucater);
		proxy.mul(2, 3);
	}
}
