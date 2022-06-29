package com.cts.sbdjrd.service;

import java.util.List;

import com.cts.sbdjrd.entity.Txn;
import com.cts.sbdjrd.exception.AccountHolderNotFoundException;

public interface TxnService {
	
	List<Txn> getAllByAhId(long ahId);
	Txn getById(long txnId);
	Txn add(Long ahId,Txn txn) throws AccountHolderNotFoundException;
	void deleteById(long txnId);

}
