package com.cts.sbdjwd.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cts.sbdjwd.entity.AccountHolder;

public interface AccountHolderRepo extends JpaRepository<AccountHolder,Long>{

	@Query("UPDATE AccountHolder ah SET ah.currentBalance=:currentBalance WHERE ah.ahId=:ahId")
	void updateBalance(long ahId,double currentBalance);
}
