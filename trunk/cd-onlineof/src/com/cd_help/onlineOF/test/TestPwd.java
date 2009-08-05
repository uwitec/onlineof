package com.cd_help.onlineOF.test;

import com.cd_help.onlineOF.utils.StringUtil;

import junit.framework.TestCase;

public class TestPwd extends TestCase{
	public void testPassword(){
		String str1 = "123";
		String str2 = "123";
		String pwd1 = StringUtil.encodePassword(str1, "sha");
		System.out.println("Password1="+pwd1);
		String pwd2 = StringUtil.encodePassword(str2, "sha");
		System.out.println("Password2="+pwd2);
		String pwd3 = StringUtil.encodePassword("onlineof", "MD5");
		System.out.println("Password3="+pwd3);
	}
}
