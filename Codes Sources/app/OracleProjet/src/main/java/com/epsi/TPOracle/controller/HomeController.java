package com.epsi.TPOracle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.epsi.TPOracle.service.ProduitService;


@Controller
public class HomeController {
  //@Autowired
  //ProduitService produitService;
  
  @RequestMapping(value="/",method=RequestMethod.GET)
  public ModelAndView home(){
	  ModelAndView model=new ModelAndView("Home");
	  //model.addObject("produits",produitService.list());
	  return model;
  }
}
