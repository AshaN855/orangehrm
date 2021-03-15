package com.orangehrm.test;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.orangehrm.generics.BaseClass;

public class TestLogin extends BaseClass{
	@Test
	public void validateLogin()
	{
		Reporter.log("pass test valid user",true);
	}
}
