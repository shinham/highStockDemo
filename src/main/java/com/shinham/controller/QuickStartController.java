package com.shinham.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class QuickStartController {
	
	  @RequestMapping("/quick")
	  @ResponseBody
	    public String quick(){
	        return "springboot 访问成功!";
	    }
}
