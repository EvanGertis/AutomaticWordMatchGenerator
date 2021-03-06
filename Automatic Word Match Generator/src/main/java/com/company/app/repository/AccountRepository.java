package com.company.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.company.app.model.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {
	
	Account findById(int id);
	Account findByUserId(int id);
}
