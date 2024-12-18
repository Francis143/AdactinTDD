package com.base;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Failed implements IRetryAnalyzer{

	
	int min=0,max=3;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(min<max) {
			min++;
			return true;
		}
		return false;
	}

}
