package com.cts.sbdjrd.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.sbdjrd.entity.AccountHolder;
import com.cts.sbdjrd.exception.AccountHolderNotFoundException;
import com.cts.sbdjrd.exception.InvalidAccountHolderException;
import com.cts.sbdjrd.service.AccountHolderService;

@RestController
@RequestMapping("/accounts")
public class AccountHoldersController {

	@Autowired
	private AccountHolderService ahs;
	
	@GetMapping
	public ResponseEntity<List<AccountHolder>> defaultAccountsAction() {
		return new ResponseEntity<List<AccountHolder>>(ahs.getAll(), HttpStatus.OK); 
	}
	
	@GetMapping("/{ahId}")
	public ResponseEntity<AccountHolder> getAccountByIdAction(@PathVariable("ahId") long ahId) throws AccountHolderNotFoundException {
		AccountHolder ah = ahs.getById(ahId);
		
		if(ah==null)
			throw new AccountHolderNotFoundException();
		
		return new ResponseEntity<>(ah, HttpStatus.OK);
	}
	
	@DeleteMapping("/{ahId}")
	public ResponseEntity<Void> deleteAccountsAction(@PathVariable("ahId")long ahId) {
		ahs.deleteById(ahId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping
	public ResponseEntity<AccountHolder> addAccountHolder(@RequestBody @Valid AccountHolder ah,BindingResult br) throws InvalidAccountHolderException{
		return new ResponseEntity<AccountHolder>(save(ah,br),HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<AccountHolder> updateAccountHolder(@RequestBody @Valid AccountHolder ah,BindingResult br) throws InvalidAccountHolderException{
		return new ResponseEntity<AccountHolder>(save(ah,br),HttpStatus.ACCEPTED);
	}
	
	public AccountHolder save(AccountHolder ah,BindingResult br) throws InvalidAccountHolderException{
		if(br.hasErrors()) {
			throw new InvalidAccountHolderException(
					br.getAllErrors().stream().map(err -> err.getDefaultMessage()).reduce((m1,m2) -> m1+","+m2).orElse("")
					);
		}
		
		return ahs.save(ah); 
	}
}
