package com.cts.sbdjwd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.sbdjwd.entity.AccountHolder;
import com.cts.sbdjwd.repo.AccountHolderRepo;

@Service
public class AccountHolderServiceImpl implements AccountHolderService {
	
	@Autowired
	private AccountHolderRepo ahRepo;

	@Override
	public List<AccountHolder> getAll() {
		return ahRepo.findAll();
	}

	@Override
	public AccountHolder getById(Long ahId) {
		return ahRepo.findById(ahId).orElse(null);
	}

	@Override
	public AccountHolder save(AccountHolder ah) {
		return ahRepo.save(ah);
	}

	@Override
	public void deleteById(Long ahId) {
		ahRepo.deleteById(ahId);
	}

}
