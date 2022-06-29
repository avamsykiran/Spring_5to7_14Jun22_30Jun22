package com.cts.sbdjrd.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cts.sbdjrd.entity.Txn;

public interface TxnRepo extends JpaRepository<Txn, Long> {
	
	@Query("SELECT t FROM Txn t WHERE t.holder.ahId=:ahId")
	List<Txn> getAllByAccountHolderId(long ahId);
}
