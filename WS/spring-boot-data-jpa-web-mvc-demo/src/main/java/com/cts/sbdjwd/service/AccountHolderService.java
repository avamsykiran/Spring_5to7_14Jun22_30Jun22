package com.cts.sbdjwd.service;

import java.util.List;

import com.cts.sbdjwd.entity.AccountHolder;

public interface AccountHolderService {

	List<AccountHolder> getAll();
	AccountHolder getById(Long ahId);
	AccountHolder add(AccountHolder ah);
	void deleteById(Long ahId);
}
