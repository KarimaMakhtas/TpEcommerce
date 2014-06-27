package com.epsi.TPOracle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.epsi.TPOracle.service.UserService;


@Controller
@SessionAttributes("userSession")
@RequestMapping("/login")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String loginPage(){
		return "Login";
	}
	
	
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView userLogin(@ModelAttribute("email") String email,@ModelAttribute("password") String password){
		ModelAndView model=new ModelAndView("Login");
		if(userService.emailExiste(email)){
			if(userService.passwordMatchWithEmail(email,password)){
				model.setViewName("User");
				model.addObject("userSession", userService.getUserByEmail(email));
			}
			else{
				model.addObject("loginError", "mot de passe éronné");
			}
		}
		else{
			model.addObject("loginError", "email inexistant");
		}
		return model;
	}
	
	/*@RequestMapping(value="/inscription",method=RequestMethod.GET)
	public String inscriptionUserPage(){
		return "inscription";
	}
	
	@RequestMapping(value="/inscription",method=RequestMethod.POST)
	public ModelAndView inscriptionUser(@Validated User user,Model model){
		
	}*/

}
