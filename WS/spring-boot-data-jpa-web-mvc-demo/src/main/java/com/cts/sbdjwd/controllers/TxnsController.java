package com.cts.sbdjwd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cts.sbdjwd.entity.AccountHolder;
import com.cts.sbdjwd.entity.Txn;
import com.cts.sbdjwd.service.AccountHolderService;
import com.cts.sbdjwd.service.TxnService;

@Controller
@RequestMapping("/txns")
@Scope("session")
public class TxnsController {
	
	private AccountHolder ah;
	
	@Autowired
	private AccountHolderService ahService;
	
	@Autowired
	private TxnService txnService;
	
	@GetMapping
	public ModelAndView defaultGetRequestAction(@RequestParam(name="ahId",required = false)Long ahId) {
		
		ModelAndView mv = null;
		
		if(ahId!=null) {
			this.ah = ahService.getById(ahId); 
		}
		
		if(ah!=null) {
			mv = new ModelAndView("txns/txns-page");
			mv.addObject("ah",ah);
			mv.addObject("txn",new Txn());
			mv.addObject("txns",txnService.getAllByAhId(ahId));
		}else {
			mv=new ModelAndView("/accounts");
		}
		
		return mv;
	}
}


