package com.cts.sbdjwd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cts.sbdjwd.service.GreetService;

@Controller
@RequestMapping("/greet")
public class GreetController {

	@Autowired
	private GreetService gs;
	
	@GetMapping
	public ModelAndView doGreetAction(@RequestParam(name="unm",required = false) String userName) {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("greet/greet-page");
		
		if(userName!=null) {
			mv.addObject("msg", gs.greet(userName));
		}
		
		return mv;
	}
}
