package com.cts.sbdjrd.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.sbdjrd.entity.AccountHolder;
import com.cts.sbdjrd.entity.Txn;
import com.cts.sbdjrd.entity.TxnType;
import com.cts.sbdjrd.exception.AccountHolderNotFoundException;
import com.cts.sbdjrd.repo.AccountHolderRepo;
import com.cts.sbdjrd.repo.TxnRepo;

@Service
public class TxnServiceImpl implements TxnService {

	@Autowired
	private AccountHolderRepo ahRepo;
	
	@Autowired
	private TxnRepo txnRepo;
	
	@Override
	public List<Txn> getAllByAhId(long ahId) {
		return txnRepo.getAllByAccountHolderId(ahId);
	}

	@Override
	public Txn getById(long txnId) {
		return txnRepo.findById(txnId).orElse(null);
	}

	@Transactional
	@Override
	public Txn add(Long ahId, Txn txn) throws AccountHolderNotFoundException {
		if(!ahRepo.existsById(ahId))
			throw new AccountHolderNotFoundException();
		
		AccountHolder ah = ahRepo.findById(ahId).get();
		txn.setHolder(ah);
		double amt = txn.getType()==TxnType.CREDIT?txn.getAmount():-txn.getAmount();
		
		ah.setCurrentBalance(ah.getCurrentBalance()+amt);	
		ahRepo.save(ah);
		
		return txnRepo.save(txn);
	}
	
	@Transactional
	@Override
	public void deleteById(long txnId) {
		Txn txn = txnRepo.findById(txnId).get();
		AccountHolder ah = txn.getHolder();
		double amt = txn.getType()==TxnType.CREDIT?-txn.getAmount():txn.getAmount();
		
		ah.setCurrentBalance(ah.getCurrentBalance()+amt);
		ahRepo.save(ah);
		
		txnRepo.deleteById(txnId);
	}

}
