package com.itf.schulung.springboot.fullstack.repositorys;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.itf.schulung.springboot.fullstack.model.Account;

public interface AccountFactoryRepository extends CrudRepository<Account, Long> {
	List<Account> findAllByOrderByIdDesc();
	
}
