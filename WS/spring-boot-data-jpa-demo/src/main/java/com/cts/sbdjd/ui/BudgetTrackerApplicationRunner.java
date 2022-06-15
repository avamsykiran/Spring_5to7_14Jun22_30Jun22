package com.cts.sbdjd.ui;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cts.sbdjd.entity.AccountHolder;
import com.cts.sbdjd.service.AccountHolderService;

@Component
public class BudgetTrackerApplicationRunner implements CommandLineRunner {

	@Autowired
	private AccountHolderService ahService;
	
	@Autowired
	private Scanner kbin;
	
	private Logger logger;
	
	@Override
	public void run(String... args) throws Exception {
		
		this.logger = LoggerFactory.getLogger(this.getClass());
		
		Menu choice=null;
		
		while(choice!=Menu.QUIT) {
			Stream.of(Menu.values()).forEach( m -> logger.info("\n"+m.ordinal()+"\t"+m));
						
			logger.info("\nEnter a choice: ");
			int ch = kbin.nextInt();
			
			if(ch<0 || ch>=Menu.values().length) {
				logger.error("\nNo Such Choice");
				continue;
			}
			
			choice = Menu.values()[ch];
			switch(choice) {
			case LIST:doList();break;
			case ADD:doAdd();break;
			case DELETE:doDelete();break;
			case QUIT:logger.info("\nApp Terminated"); break;
			}
		}
	}
	
	private void doList() {
		List<AccountHolder> ahs = ahService.getAll();
		
		if(ahs.isEmpty()) {
			logger.info("\n No Records To Display");
		}else {
			ahs.stream().forEach(ah -> logger.info("\n"+ah));
		}
	}

	private void doDelete() {
		logger.info("\nAccount Holder Id: ");
		long ahId = kbin.nextLong();
		ahService.deleteById(ahId);
		logger.info("\n The account Holder is Deleted!");
	}
	
	private void doAdd() {
		logger.info("\nFullName: ");
		String fullName=kbin.next();
		logger.info("\nEmailId: ");
		String emailId=kbin.next();
		
		AccountHolder ah = ahService.add(new AccountHolder(fullName, emailId));
		
		logger.info("\n Account Holder Saved With Id: "+ ah.getAhId());
	}
}
