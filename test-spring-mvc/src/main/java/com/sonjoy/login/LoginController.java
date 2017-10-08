package com.sonjoy.login;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;



@Controller
@SessionAttributes("name")
public class LoginController {
	@Autowired
    LoginService testService;  //=new UserValidationService(); 
	
	@RequestMapping(value = "/login",method=RequestMethod.GET)
	//@ResponseBody
	public String showLoginPage() {
		return "login";
		
	}
	
	@RequestMapping(value = "/login",method=RequestMethod.POST)
	//@ResponseBody
	public String handelLogin(@RequestParam String username,@RequestParam String password,ModelMap model) {
	
		if(testService.isvaild(username, password))
		{
			model.put("name", username);
			model.put("password", password);
			return "welcome";
		}
		else {
			model.put("errorMessage", "Invalid Login");
			return "login";
		}
		
		
		
	}

}
