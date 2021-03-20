package com.springaop03.utils;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 1.切入点表达式
 * 		@Befor(value="execution(权限访问符 返回值类型 方法全类名(方法参数类型))")
 * 		@Befor(value="execution(public void com.springaop01.LogUtils(int,int))")
 * 		*:通配符 表示多个字符或一层目录
 * 		当 execution(* *())时,第二个*可表示多层目录
 * 		..:表示多层目录
 * 2.切入方法参数 
 * 		JoinPoint 切入点 封装了目标对象目标方法的参数、方法名等信息
 * 		声明返回参数和异常信息
 * 		@AfterReturning(value="execution()",returning="result")
 * 		public void logReturn(Object result){}
 * 		@AfterThrowing(value="execution()",Throwing="excupution")
 * 		public void logThrowing(Excupution excuception){}
 * 		可以指定返回NullpointException
 * 3.通知方法执行顺序
 * 		before-->afterend-->afterreturning(afterThrowing)
 * 4.jdk代理和cglib代理
 * 		jdk代理:目标类有接口采用接口方式生成代理对象，spring容器内只存在代理对象，当用类型获得bean时参数为接口类型；
 * 		cglib代理:目标类没有接口，采用类的继承方式，目标类为基类，代理类为子类，
 * 5.
 * @author admin
 *
 */
@Aspect
@Component
public class LogUtils {
	//方法执行前
	@Before(value = "execution( * *(int, *))")
	public void logStart(JoinPoint joinPoint) {
		Signature signature=joinPoint.getSignature();
		String name=signature.getName();
		System.out.println("logStart...["+Arrays.asList(joinPoint.getArgs())+"]"+name);
	}
	//方法执行后
	@AfterReturning(value = "execution(public int com.springaop03.impl.MyMathCalucater.*(int, int))",returning = "result")
	public void logReturn(Object result) {
		System.out.println("logReturn..."+result);
	}
	//方法执行异常
	@AfterThrowing(value = "execution(public int com.springaop03.impl.MyMathCalucater.*(int, int))",throwing = "exception")
	public void logException(Exception exception) {
		System.out.println("logException...["+exception+"]");
	}
	//方法执行结束
	@After("execution(public int com.springaop03.impl.MyMathCalucater.*(int, int))")
	public void logEnd() {
		System.out.println("logEnd...");
	}
	//@Around
}
