package com.springaop01.poxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import com.springaop01.inter.Calucater;

public class CalureterPoxy {

	public static Calucater getPoxyInnstance(Calucater calucater) {
		//获得目标类的类加载器
		ClassLoader loader=calucater.getClass().getClassLoader();
		//获得目标类实现的接口
		Class<?>[] interfaces=calucater.getClass().getInterfaces();
		//执行目标方法的处理器    代理对象调用方法时 调用该接口的实现方法
		InvocationHandler h=new InvocationHandler() {
			/**
			 * Method method 目标对象当前调用的方法
			 * Object[] args 目标对象的参数列表
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// TODO Auto-generated method stub
				//执行目标对象的当前方法  返回结果
				System.out.println("代理对象执行"+method.getName()+",参数为:"+Arrays.asList(args));
				Object result=method.invoke(calucater, args);//执行目标对象的方法
				return result;
			}
		};
		return (Calucater) Proxy.newProxyInstance(loader, interfaces, h);
	}
}
