package com.zhsj.dcplatform.util.login;


public class LoginUtil {

	private static ThreadLocal<LoginUser> threadLocal = new ThreadLocal<LoginUser>();
	
	
	public static void set(LoginUser LoginUser){
		threadLocal.set(LoginUser);
	}
	
	public static LoginUser get(){
		return threadLocal.get();
	}
	
	public static void remove(){
		threadLocal.remove();
	}
}
