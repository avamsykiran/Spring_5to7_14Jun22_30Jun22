package com.cts.sbdjwd.service;

import java.util.List;

import com.cts.sbdjwd.entity.Txn;
import com.cts.sbdjwd.exception.AccountHolderNotFoundException;

public interface TxnService {
	
	List<Txn> getAllByAhId(long ahId);
	Txn getById(long txnId);
	Txn add(Long ahId,Txn txn) throws AccountHolderNotFoundException;
	void deleteById(long txnId);

}
