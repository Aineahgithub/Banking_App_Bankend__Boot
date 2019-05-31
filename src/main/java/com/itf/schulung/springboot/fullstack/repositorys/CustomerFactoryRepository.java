package com.itf.schulung.springboot.fullstack.repositorys;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.itf.schulung.springboot.fullstack.model.CustomerFactory;

public interface CustomerFactoryRepository extends CrudRepository<CustomerFactory, Long> {
	List<CustomerFactory>findAll();

}
