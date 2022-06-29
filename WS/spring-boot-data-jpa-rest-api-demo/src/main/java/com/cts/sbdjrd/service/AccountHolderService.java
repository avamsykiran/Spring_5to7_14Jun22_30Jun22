package com.cts.sbdjrd.service;

import java.util.List;

import com.cts.sbdjrd.entity.AccountHolder;

public interface AccountHolderService {

	List<AccountHolder> getAll();
	AccountHolder getById(Long ahId);
	AccountHolder save(AccountHolder ah);
	void deleteById(Long ahId);
}
