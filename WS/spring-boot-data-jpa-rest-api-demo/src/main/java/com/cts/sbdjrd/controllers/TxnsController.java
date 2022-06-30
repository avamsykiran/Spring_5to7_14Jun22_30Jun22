package com.cts.sbdjrd.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.sbdjrd.entity.Txn;
import com.cts.sbdjrd.exception.AccountHolderNotFoundException;
import com.cts.sbdjrd.exception.InvalidTxnException;
import com.cts.sbdjrd.service.AccountHolderService;
import com.cts.sbdjrd.service.TxnService;

@RestController
@RequestMapping("/accounts/{ahId}/txns")
public class TxnsController {

	@Autowired
	private TxnService txnService;

	@GetMapping
	public ResponseEntity<List<Txn>> defaultGetRequestAction(@PathVariable("ahId") Long ahId) {
		return new ResponseEntity<>(txnService.getAllByAhId(ahId), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Txn> doSaveTxn(@PathVariable("ahId")Long ahId,@RequestBody @Valid Txn txn,BindingResult br) throws AccountHolderNotFoundException, InvalidTxnException {
		if(br.hasErrors()) {
			throw new InvalidTxnException(
			br.getAllErrors().stream().map(err -> err.getDefaultMessage()).reduce((m1,m2) -> m1+","+m2).orElse(""));	
		}
		
		return new ResponseEntity<>(txnService.add(ahId, txn),HttpStatus.CREATED);
	}
}
