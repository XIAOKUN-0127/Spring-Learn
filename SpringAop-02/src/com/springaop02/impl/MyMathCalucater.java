package com.springaop02.impl;

import org.springframework.stereotype.Component;

import com.springaop02.inter.Calucater;
@Component
public class MyMathCalucater implements Calucater {

	@Override
	public int add(int i, int j) {
	
		int result=i + j;
		
		return result;
	}

	@Override
	public int sub(int i, int j) {
		
		int result=i - j;
		
		return result;
	}

	@Override
	public int mul(int i, int j) {
		
		int result=i * j;
		
		return result;
	}

	@Override
	public int div(int i, int j) {
		
		int result=i / j;
		
		return result;
	}

}
