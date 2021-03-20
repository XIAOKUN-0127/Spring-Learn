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
 * 基于配置的切面编程
 * @author admin
 *
 */

public class LogUtils {
	//方法执行前
	//@Before(value = "execution( * *(int, *))")
	public void logStart(JoinPoint joinPoint) {
		Signature signature=joinPoint.getSignature();
		String name=signature.getName();
		System.out.println("logStart...["+Arrays.asList(joinPoint.getArgs())+"]"+name);
	}
	//方法执行后
	//@AfterReturning(value = "execution(public int com.springaop03.impl.MyMathCalucater.*(int, int))",returning = "result")
	public void logReturn(Object result) {
		System.out.println("logReturn..."+result);
	}
	//方法执行异常
	//@AfterThrowing(value = "execution(public int com.springaop03.impl.MyMathCalucater.*(int, int))",throwing = "exception")
	public void logException(Exception exception) {
		System.out.println("logException...["+exception+"]");
	}
	//方法执行结束
	//@After("execution(public int com.springaop03.impl.MyMathCalucater.*(int, int))")
	public void logEnd() {
		System.out.println("logEnd...");
	}
	//@Around
}
