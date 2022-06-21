package com.cts.sbdjwd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cts.sbdjwd.service.AccountHolderService;

@Controller
@RequestMapping("/accounts")
public class AccountHoldersController {

	@Autowired
	private AccountHolderService ahs;
	
	@GetMapping
	public ModelAndView defaultAccountsAction() {
		return new ModelAndView("accounts/accounts-page", "ahs",ahs.getAll()); 
	}
}
