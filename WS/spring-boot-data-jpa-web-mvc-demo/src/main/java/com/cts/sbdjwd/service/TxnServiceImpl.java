package com.cts.sbdjwd.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.sbdjwd.entity.AccountHolder;
import com.cts.sbdjwd.entity.Txn;
import com.cts.sbdjwd.entity.TxnType;
import com.cts.sbdjwd.exception.AccountHolderNotFoundException;
import com.cts.sbdjwd.repo.AccountHolderRepo;
import com.cts.sbdjwd.repo.TxnRepo;

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
		
		ahRepo.updateBalance(ahId, ah.getCurrentBalance()+amt);
		
		return txnRepo.save(txn);
	}
	
	@Transactional
	@Override
	public void deleteById(long txnId) {
		Txn txn = txnRepo.findById(txnId).get();
		AccountHolder ah = txn.getHolder();
		double amt = txn.getType()==TxnType.CREDIT?-txn.getAmount():txn.getAmount();
		
		ahRepo.updateBalance(ah.getAhId(), ah.getCurrentBalance()+amt);
		
		txnRepo.deleteById(txnId);
	}

}
