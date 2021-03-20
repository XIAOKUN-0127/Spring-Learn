package com.springaop01.impl;

import com.springaop01.inter.Calucater;

public class MyMathCalucater implements Calucater {

	@Override
	public int add(int i, int j) {
		//System.out.println("【add】开始,参数为:["+i+","+j+"]");
		int result=i + j;
		//System.out.println("【add】结束,结果为:["+result+"]");
		return result;
	}

	@Override
	public int sub(int i, int j) {
		//System.out.println("【sub】开始,参数为:["+i+","+j+"]");
		int result=i - j;
		//System.out.println("【sub】结束,结果为:["+result+"]");
		return result;
	}

	@Override
	public int mul(int i, int j) {
		//System.out.println("【mul】开始,参数为:["+i+","+j+"]");
		int result=i * j;
		//System.out.println("【mul】结束,结果为:["+result+"]");
		return result;
	}

	@Override
	public int div(int i, int j) {
		//System.out.println("【div】开始,参数为:["+i+","+j+"]");
		int result=i / j;
		//System.out.println("【div】结束,结果为:["+result+"]");
		return result;
	}

}
