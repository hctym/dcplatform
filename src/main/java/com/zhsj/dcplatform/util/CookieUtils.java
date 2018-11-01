package com.zhsj.dcplatform.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class CookieUtils {

	public static void writeCookie(HttpServletResponse response, String name, String value){
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(24*60*60*100);
		cookie.setPath("/");
		response.addCookie(cookie);
	}
	
	public static String readCookie(HttpServletRequest request, String name){
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie: cookies){
			if(name.equals(cookie.getName())){
				return cookie.getValue();
			}
		}
		return null;
	}
}
