package com.cts.sbdjd.service;

import java.util.List;

import com.cts.sbdjd.entity.AccountHolder;

public interface AccountHolderService {

	List<AccountHolder> getAll();
	AccountHolder getById(Long ahId);
	AccountHolder add(AccountHolder ah);
	void deleteById(Long ahId);
}
