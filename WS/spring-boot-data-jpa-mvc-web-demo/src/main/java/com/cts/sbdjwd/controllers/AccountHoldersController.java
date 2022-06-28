package com.cts.sbdjwd.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cts.sbdjwd.entity.AccountHolder;
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
	
	@GetMapping("/add")
	public ModelAndView addAccountsAction() {
		return new ModelAndView("accounts/accounts-form", "ah",new AccountHolder()); 
	}
	
	@GetMapping("/edit")
	public ModelAndView editAccountsAction(@RequestParam("ahId")long ahId) {
		return new ModelAndView("accounts/accounts-form", "ah",ahs.getById(ahId)); 
	}
	
	@GetMapping("/delete")
	public String deleteAccountsAction(@RequestParam("ahId")long ahId) {
		ahs.deleteById(ahId);
		return "redirect:/accounts"; 
	}
	
	@PostMapping({"/add","/edit"})
	public ModelAndView saveAccountsAction(@ModelAttribute("ah") @Valid AccountHolder ah,BindingResult bindingResult) {
		
		ModelAndView mv=null;
		
		if(bindingResult.hasErrors()) {
			mv = new ModelAndView("accounts/accounts-form", "ah",ah);
		}else {
			ahs.save(ah);
			mv = new ModelAndView("redirect:/accounts");
		}
		
		return mv; 
	}
}
