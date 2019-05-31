package com.itf.schulung.springboot.fullstack.repositorys;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.itf.schulung.springboot.fullstack.model.Login;

public interface LoginRepository extends CrudRepository<Login, Integer> {

	Optional<Login> findByUsername(String username);

}
