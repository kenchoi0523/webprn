package com.kch.controller;


import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class IndexController {

	@RequestMapping(value="/",method = RequestMethod.GET)
    public String home() {
		return "index";
    }

	
}
