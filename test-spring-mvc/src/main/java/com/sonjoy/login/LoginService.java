package com.sonjoy.login;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	public boolean isvaild(String name,String pass)
	{
		if(name.equals("sonjoy")&& pass.equals("sonjoy079"))
		{
			return true;
		}
		else return false;
	}

}
