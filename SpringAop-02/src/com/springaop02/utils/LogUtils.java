package com.springaop02.utils;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class LogUtils {
	//方法执行前
	@Before("execution(public int com.springaop02.impl.MyMathCalucater.*(int, int))")
	public void logStart() {
		System.out.println("logStart...");
	}
	//方法执行后
	@AfterReturning("execution(public int com.springaop02.impl.MyMathCalucater.*(int, int))")
	public void logReturn() {
		System.out.println("logReturn...");
	}
	//方法执行异常
	@AfterThrowing("execution(public int com.springaop02.impl.MyMathCalucater.*(int, int))")
	public void logException() {
		System.out.println("logException...");
	}
	//方法执行结束
	@After("execution(public int com.springaop02.impl.MyMathCalucater.*(int, int))")
	public void logEnd() {
		System.out.println("logEnd...");
	}
	//@Around
}
